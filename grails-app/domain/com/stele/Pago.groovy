package com.stele

import org.grails.s3.S3Asset

class Pago {
  String conceptoDePago
  Date fechaDePago
  Date fechaDeVencimiento
  BigDecimal cantidadDePago
  TipoDePago tipoDePago = TipoDePago.TRANSFERENCIA_BANCARIA
  EstatusDePago estatusDePago = EstatusDePago.CREADO
  String transactionId = UUID.randomUUID().toString().replaceAll('-', '').substring(0,20)
  S3Asset comprobanteDePago

  HistorialAcademico historialAcademico

  static hasMany = [descuentos : Descuento, recargos: Recargo]

  Date dateCreated
  Date lastUpdated

  static constraints = {
    conceptoDePago size:1..100,blank:false
    cantidadDePago min:1.0
    fechaDePago nullable: true
    transactionId size:20..20
    historialAcademico nullable:true
    comprobanteDePago nullable:true
  }
}
