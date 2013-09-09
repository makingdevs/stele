package com.stele

import com.stele.Descuento
import com.stele.Recargo
import com.stele.Dependiente

class GeneracionDePagoService {

  def conceptoService
  def springSecurityService

  def paraCamadaPagoCommand(CamadaPagoCommand camadaPagoCommand) {
    def existeConcepto = conceptoService.verificarConceptoPagoExistente(camadaPagoCommand.conceptoDePago)
    if (!existeConcepto)
        conceptoService.guardarConceptoDePagoGenerado(springSecurityService.currentUser,camadaPagoCommand.conceptoDePago)
    List listaDependientesExistentes = []
    def dependientes = Dependiente.findAllByCamada(camadaPagoCommand.camada)

    camadaPagoCommand?.listaDependientes?.each { it ->
      if ( !(it.equals("[") || it.equals("]") || it.equals(",") || it.equals(" ")) ) 
          listaDependientesExistentes.add(it.toLong())
    }

    listaDependientesExistentes?.removeAll(dependientes*.id)

    if (listaDependientesExistentes){
      dependientes+= Dependiente.withCriteria {
        'in'('id', listaDependientesExistentes)
      }
    }

    def listaDeDescuentosParaAplicar = obtenerDescuentosAsociadosAPagos(camadaPagoCommand)
    List descuentos = []
    List fechasDescuentos = []

    def meses = camadaPagoCommand.meses
     listaDeDescuentosParaAplicar.each { descuento ->
        fechasDescuentos = obtenerFechaAplicacion(meses, descuento)
        fechasDescuentos.each { fecha ->
          Descuento desc = new Descuento()
          desc.nombreDeDescuento = descuento.nombreDeDescuento
          desc.porcentaje = descuento?.porcentaje 
          desc.cantidad = descuento?.cantidad
          desc.fechaDeVencimiento = fecha
          desc.institucion = descuento.institucion
          desc.save()
          descuentos.add(desc)
        }
      }

    List<Pago> pagos = []
    dependientes.each { dependiente ->
      def pago = generarPagoParaDependienteConCommand(dependiente, camadaPagoCommand, descuentos)
      pago.each { p ->
        dependiente.addToPagos(p)
        pagos << p
      }
      dependiente.save()
    }
    pagos
  }

  private def generarPagoParaDependienteConCommand(Dependiente dependiente, CamadaPagoCommand camadaPagoCommand, List descuentos) {

    def recargo = obtenerRecargosAsociadosAPagos(camadaPagoCommand)

    HistorialAcademico historialAcademico = dependiente.historialAcademico.max {
      it.dateCreated
    }

    generarTalonarioDePagos(historialAcademico, camadaPagoCommand, recargo, descuentos)

  }

   def generarTalonarioDePagos(HistorialAcademico historialAcademico, CamadaPagoCommand camadaPagoCommand, def recargo, List descuentos) {
    def meses = camadaPagoCommand.meses
    List pagos = []
    List fechasDeVencimiento = obtenerFechasDeVencimientoDePago(meses, camadaPagoCommand)

    fechasDeVencimiento.each { fechaDeVencimiento ->
      Pago pago = new Pago()
      pago.conceptoDePago = camadaPagoCommand.conceptoDePago
        
      if (esPagoDobleEsteMes(camadaPagoCommand, fechaDeVencimiento)) 
        pago.cantidadDePago = camadaPagoCommand.cantidadDePago * 2
      else 
        pago.cantidadDePago = camadaPagoCommand.cantidadDePago
      pago.fechaDeVencimiento = fechaDeVencimiento
      pago.historialAcademico = historialAcademico
      descuentos.each { descuento ->
        pago.addToDescuentos(descuento)
      }
  
      if (recargo)
        pago.addToRecargos(recargo)
  
      pagos.add(pago.save())

    }
    pagos
  }

  def obtenerDescuentosAsociadosAPagos(CamadaPagoCommand camadaPagoCommand) {
    def listaIdDescuentos = []

    def lista = camadaPagoCommand?.descuentos?.first()?.replace('[','')?.replace(']','')?.split(',')
    lista.each { descuetoId ->
      if (descuetoId)
        listaIdDescuentos.add(descuetoId.toLong())
    }

    Descuento.withCriteria {
      'in'('id', listaIdDescuentos)
    }
  }

  def obtenerRecargosAsociadosAPagos(CamadaPagoCommand camadaPagoCommand) {
    Recargo.findById(camadaPagoCommand?.recargoid?.first())
  }

  def obtenerFechasDeVencimientoDePago(String[] meses, CamadaPagoCommand cpc) {
    List fechas =[]

    Calendar cal = Calendar.getInstance()
    cal.setTime(cpc.fechaDeVencimiento)

    fechas.add(cpc.fechaDeVencimiento)

    def year = cal.get(Calendar.YEAR)
    def month = cal.get(Calendar.MONTH)
    def day = cal .get(Calendar.DAY_OF_MONTH)
    meses.each { mes ->

      if (mes.toInteger() < month) {
        cal.set(year+1, mes.toInteger(), day)
        fechas.add(cal.getTime())
      } else if (mes.toInteger() > month) {
        cal.set(year, mes.toInteger(), day)
        fechas.add(cal.getTime())
      } 

    }
    fechas
  }

  def obtenerFechaAplicacion(String[] meses, Descuento descuento) {
    List fechasAplicacion = []

    Calendar cal = Calendar.getInstance()
    cal.setTime(descuento.fechaDeVencimiento)

    def year = cal.get(Calendar.YEAR)
    def month = cal.get(Calendar.MONTH)
    def day = cal.get(Calendar.DAY_OF_MONTH)

    meses.each { mes ->
      if (mes.toInteger() < month) {
        cal.set(year+1, mes.toInteger(), day)
        fechasAplicacion.add(cal.getTime())
      } else if (mes.toInteger() > month) {
        cal.set(year, mes.toInteger(), day)
        fechasAplicacion.add(cal.getTime())
      } 
    }

    fechasAplicacion
  }

  private Boolean esPagoDobleEsteMes(CamadaPagoCommand camadaPagoCommand, def fechaDeVencimiento){
    Calendar cal = Calendar.getInstance()
    cal.setTime(fechaDeVencimiento)
    def month = cal.get(Calendar.MONTH)

    camadaPagoCommand.pagoDoble?.contains(month.toString())

  }
}
