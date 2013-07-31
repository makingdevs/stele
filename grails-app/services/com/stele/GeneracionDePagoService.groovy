package com.stele

import com.stele.seguridad.Usuario

class GeneracionDePagoService {

  def conceptoService

  def paraCamadaPagoCommand(CamadaPagoCommand camadaPagoCommand, Usuario usuario) {

    def dependientes = Dependiente.findAllByCamada(camadaPagoCommand.camada)
    println camadaPagoCommand.properties.conceptoDePago
    conceptoService.guardarConceptoDePagoGenerado(usuario, camadaPagoCommand.properties.conceptoDePago)
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
    HistorialAcademico historialAcademico = dependiente.historialAcademico.max {
      it.dateCreated
    }
    Pago pago = new Pago(camadaPagoCommand.properties)
    pago.historialAcademico = historialAcademico
    pago
  }

}
