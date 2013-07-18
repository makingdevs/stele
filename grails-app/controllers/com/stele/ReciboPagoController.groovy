package com.stele

import grails.converters.JSON
import org.grails.s3.S3Asset

class ReciboPagoController {

  def comprobanteService

  def index() { 
    [pago: Pago.get(params.id)]
  }

  def subirArchivo() {
    log.debug "params : $params"
    Pago pago = comprobanteService.agregarComprobanteAPago(params.long('id'), params.file) 
    render pago as JSON
  }

  def muestra(){
    S3Asset s3 = S3Asset.get(params.id)
    [s3:s3]
  }

}
