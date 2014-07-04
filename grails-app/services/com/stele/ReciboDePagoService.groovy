package com.stele

import grails.transaction.Transactional
import com.payable.Pago

@Transactional
class ReciboDePagoService {
  
  def dependienteService

  def obtenerDatosReciboDePago(pagoId){
    def pago = Pago.get(pagoId)
    def dependientes = dependienteService.obtenerDependientesPorPagos([pago])

    new ComprobantePagoCommand(cantidadPago:pago.cantidadDePago,
                               conceptoPago:pago.conceptoDePago,
                               nombreAlumno = dependientes[0].perfil.nombre)
                               //apellidoPaternoAlumno = dependiente.pefil.apellidoPaterno,
                               //apellidoMaternoAlumno = dependiente.perfil.apellidoMaterno) 
  }

}
