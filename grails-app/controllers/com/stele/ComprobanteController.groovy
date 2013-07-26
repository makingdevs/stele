package com.stele

class ComprobanteController {

  def pagoService
  def comprobanteService

  def show() {
    log.debug "params : $params"
    def pago = pagoService.obtenerPagoParaValidarComprobante(params.long('id'))
    [pago: pago.pago, perfil:pago.perfil]
  }

  def validarComprobante() {
    comprobanteService.aprobarPago(params.transactionId, params.fechaPago, params.tipoPago as TipoDePago)
    flash.success = "El comprobante fue aprobado"
    redirect (controller: "Pago", action: "pagosDeUnaInstitucion")
  }

  def rachazarPago() {
    pagoService.rechazarComprobanteDePago(params.transactionId)
    redirect (controller: "Pago", action: "pagosDeUnaInstitucion")
  }

}
