package com.stele

class ComprobanteController {

  def comprobanteService
  def pagoService

  def show() {
    log.debug "params : $params"
    def pago = pagoService.obtenerInformacionDelComprobante(params.long('id'))
    [info: pago]
  }

  def validarComprobante() {

  }

  def rechazarComprobante() {

  }

}