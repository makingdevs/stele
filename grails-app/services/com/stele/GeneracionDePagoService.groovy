package com.stele

class GeneracionDePagoService {

  def paraCamadaPagoCommand(CamadaPagoCommand camadaPagoCommand) {

    def dependientes = Dependiente.findAllByCamada(camadaPagoCommand.camada)

    List<Pago> pagos = []
    dependientes.each { dependiente ->
      pagos << generarPagoParaDependienteConCommand(dependiente, camadaPagoCommand)
    }
    pagos
  }

  private def generarPagoParaDependienteConCommand(Dependiente dependiente, CamadaPagoCommand camadaPagoCommand) {
    HistorialAcademico historialAcademico = dependiente.historialAcademico.max {
      it.dateCreated
    }

    Pago pago = new Pago(camadaPagoCommand.properties)
    pago.historialAcademico = historialAcademico
    pago.save(flush:true)
    pago
  }

}
