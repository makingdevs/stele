package com.stele

class ComprobanteController {

  def pagoService

  def show() {
    log.debug "params : $params"
    def pago = pagoService.obtenerPagoParaValidarComprobante(params.long('id'))
    [pago: pago.pago, perfil:pago.perfil]
  }

  def validarComprobante() {
    def datosForm = params
    pagoService.validarComprobanteDePago(datosForm)
    flash.success = "El comprobante fue aprobado"
    redirect (controller: "Pago", action: "pagosDeUnaInstitucion")
  }

  def rechazarComprobante() {
    def datosForms = params
    println datosForms
    pagoService.rechazarComprobanteDePago(datosForms)
    redirect (controller: "Pago", action: "pagosDeUnaInstitucion")
  }

}
