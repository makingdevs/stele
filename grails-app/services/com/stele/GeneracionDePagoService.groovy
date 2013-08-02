package com.stele

import com.stele.seguridad.Usuario
import com.stele.Descuento

class GeneracionDePagoService {

  def conceptoService

  def paraCamadaPagoCommand(CamadaPagoCommand camadaPagoCommand, Usuario usuario, def descuentos) {

    def dependientes = Dependiente.findAllByCamada(camadaPagoCommand.camada)
    conceptoService.guardarConceptoDePagoGenerado(usuario, camadaPagoCommand.properties.conceptoDePago)
    List<Pago> pagos = []
    dependientes.each { dependiente ->
      def pago = generarPagoParaDependienteConCommand(dependiente, camadaPagoCommand, descuentos).save()
      dependiente.addToPagos(pago)
      dependiente.save()
      pagos << pago
    }
    pagos
  }

  private def generarPagoParaDependienteConCommand(Dependiente dependiente, CamadaPagoCommand camadaPagoCommand, def descuentos) {
    def list = []
    descuentos.each { id ->
      list.add(id.toLong())
    }
    def descuentoList = Descuento.withCriteria {
      'in'('id', list)
    }
    HistorialAcademico historialAcademico = dependiente.historialAcademico.max {
      it.dateCreated
    }
    Pago pago = new Pago(camadaPagoCommand.properties)
    pago.historialAcademico = historialAcademico
    descuentoList.each { descuento ->
      pago.addToDescuentos(descuento)
    }
    pago
  }

}
