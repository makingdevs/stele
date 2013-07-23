package com.stele

class ComprobanteController {

  def pagoService

  def show() {
    log.debug "params : $params"
    def pago = pagoService.obtenerPagoParaValidarComprobante(params.long('id'))
    [pago: pago]
  }

  def validarComprobante() {

  }

  def rechazarComprobante() {

  }

}
