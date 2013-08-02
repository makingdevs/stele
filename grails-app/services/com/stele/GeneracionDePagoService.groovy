package com.stele

import com.stele.seguridad.Usuario
import com.stele.Descuento

class GeneracionDePagoService {

  def conceptoService

  def paraCamadaPagoCommand(CamadaPagoCommand camadaPagoCommand) {

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
    HistorialAcademico historialAcademico = dependiente.historialAcademico.max {
      it.dateCreated
    }
    Pago pago = new Pago(camadaPagoCommand.properties)
    pago.historialAcademico = historialAcademico
    pago
  }

}
