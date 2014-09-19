package com.stele

import grails.converters.JSON
import org.grails.s3.S3Asset
import com.payable.*

class ReciboPagoController {

  def proofOfPaymentService

  def index() { 
    [payment: Payment.get(params.id)]
  }

  def subirArchivo() {
    Payment payment = proofOfPaymentService.addProofOfPayment(params.long('id'), params.file) 
    render payment as JSON
  }

  def muestra(){
    S3Asset s3 = S3Asset.get(params.id)
    [s3:s3]
  }

}
