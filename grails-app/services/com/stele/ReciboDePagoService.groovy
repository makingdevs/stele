package com.stele

import grails.transaction.Transactional

@Transactional
class ReciboDePagoService {

  def obtenerDatosReciboDePago(pagoId){
    def pago = Pago.get(pagoId)
    new ComprobantePagoCommand() 
  }

}
