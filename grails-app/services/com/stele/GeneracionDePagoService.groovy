package com.stele

import com.stele.Descuento

class GeneracionDePagoService {

  def conceptoService
  def springSecurityService

  def paraCamadaPagoCommand(CamadaPagoCommand camadaPagoCommand) {
    def existeConcepto = conceptoService.verificarConceptoPagoExistente(camadaPagoCommand.conceptoDePago)
    if (!existeConcepto)
        conceptoService.guardarConceptoDePAgoGenerado(springSecurityService.currentUser,camadaPagoCommand.conceptoDePago)

    def dependientes = Dependiente.findAllByCamada(camadaPagoCommand.camada)

    List<Pago> pagos = []
    dependientes.each { dependiente ->
      def pago = generarPagoParaDependienteConCommand(dependiente, camadaPagoCommand).save()
      dependiente.addToPagos(pago)
      dependiente.save()
      pagos << pago
    }
    pagos
  }

  private def generarPagoParaDependienteConCommand(Dependiente dependiente, CamadaPagoCommand camadaPagoCommand) {
    def listaIdDescuentos = []
    camadaPagoCommand.descuentos.each { descuetoId ->
      if (descuetoId)
        listaIdDescuentos.add(descuetoId.toLong())
    }
    def listaDeDescuentosParaAplicar = Descuento.withCriteria {
      'in'('id', listaIdDescuentos)
    }
    HistorialAcademico historialAcademico = dependiente.historialAcademico.max {
      it.dateCreated
    }
    Pago pago = new Pago(camadaPagoCommand.properties)
    pago.historialAcademico = historialAcademico
    listaDeDescuentosParaAplicar.each { descuento ->
      pago.addToDescuentos(descuento)
    }
    pago
  }

}
