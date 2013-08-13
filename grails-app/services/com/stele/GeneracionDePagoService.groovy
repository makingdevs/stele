package com.stele

import com.stele.Descuento
import com.stele.Recargo

class GeneracionDePagoService {

  def conceptoService
  def springSecurityService

  def paraCamadaPagoCommand(CamadaPagoCommand camadaPagoCommand) {
    def existeConcepto = conceptoService.verificarConceptoPagoExistente(camadaPagoCommand.conceptoDePago)
    if (!existeConcepto)
        conceptoService.guardarConceptoDePagoGenerado(springSecurityService.currentUser,camadaPagoCommand.conceptoDePago)

    def dependientes = Dependiente.findAllByCamada(camadaPagoCommand.camada)

    List<Pago> pagos = []
    dependientes.each { dependiente ->
      def pago = generarPagoParaDependienteConCommand(dependiente, camadaPagoCommand)
      pago.each { p ->
        dependiente.addToPagos(p)
        pagos << p
      }
      dependiente.save()
    }
    pagos
  }

  private def generarPagoParaDependienteConCommand(Dependiente dependiente, CamadaPagoCommand camadaPagoCommand) {

    def listaDeDescuentosParaAplicar = obtenerDescuentosAsociadosAPagos(camadaPagoCommand)

    def recargo = obtenerRecargosAsociadosAPagos(camadaPagoCommand)

    HistorialAcademico historialAcademico = dependiente.historialAcademico.max {
      it.dateCreated
    }

    generarTalonarioDePagos(historialAcademico, camadaPagoCommand, recargo, listaDeDescuentosParaAplicar)

  }

   def generarTalonarioDePagos(HistorialAcademico historialAcademico, CamadaPagoCommand camadaPagoCommand, def recargo, def listaDeDescuentosParaAplicar) {
    def meses = camadaPagoCommand.meses
    List pagos = []

    List fechasDeVencimiento = obtenerFechasDeVencimientoDePago(meses, camadaPagoCommand)

    fechasDeVencimiento.each { fechaDeVencimiento ->
      Pago pago = new Pago()
      pago.conceptoDePago = camadaPagoCommand.conceptoDePago
      pago.cantidadDePago = camadaPagoCommand.cantidadDePago
      pago.fechaDeVencimiento = fechaDeVencimiento
      pago.historialAcademico = historialAcademico
      
      listaDeDescuentosParaAplicar.each { descuento ->
        pago.addToDescuentos(descuento)
      }
  
      if (recargo)
        pago.addToRecargos(recargo)
  
      pagos.add(pago.save(flush:true))

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

}
