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
      dependiente.addToPagos(pago)
      dependiente.save()
      pagos << pago
    }
    pagos
  }

  private def generarPagoParaDependienteConCommand(Dependiente dependiente, CamadaPagoCommand camadaPagoCommand) {
    def listaDeDescuentosParaAplicar = obtenerDescuentosAsociadosAPagos(camadaPagoCommand)
    def recargo = obtenerRecargosAsociadosAPagos(camadaPagoCommand)
    HistorialAcademico historialAcademico = dependiente.historialAcademico.max {
      it.dateCreated
    }
    Pago pago = new Pago()
    pago.conceptoDePago = camadaPagoCommand.conceptoDePago
    pago.cantidadDePago = camadaPagoCommand.cantidadDePago
    pago.fechaDeVencimiento = camadaPagoCommand.fechaDeVencimiento
    pago.historialAcademico = historialAcademico
    listaDeDescuentosParaAplicar.each { descuento ->
      pago.addToDescuentos(descuento)
    }
    if (recargo)
      pago.addToRecargos(recargo)

    pago.save(flush:true)
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
    Recargo.findById(camadaPagoCommand?.recargoid)
  }

}
