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
    def recargo = obtenerRecargosAsociadosAPAgos(camadaPagoCommand)
    HistorialAcademico historialAcademico = dependiente.historialAcademico.max {
      it.dateCreated
    }
    Pago pago = new Pago(camadaPagoCommand.properties)
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

    camadaPagoCommand.descuento.each { descuetoId ->
      if (descuetoId)
        listaIdDescuentos.add(descuetoId.toLong())
    }

    Descuento.withCriteria {
      'in'('id', listaIdDescuentos)
    }
  }

  def obtenerRecargosAsociadosAPAgos(CamadaPagoCommand camadaPagoCommand) {
    Recargo.findById(camadaPagoCommand?.recargo)
  }

}
