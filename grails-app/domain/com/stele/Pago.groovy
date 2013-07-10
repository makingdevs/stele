package com.stele

class Pago {

  String conceptoDePago
  Date fechaDePago
  Date fechaDeVencimiento
  BigDecimal cantidadDePago
  TipoDePago tipoDePago = TipoDePago.TRANSFERENCIA_BANCARIA
  EstatusDePago estatusDePago = EstatusDePago.PROCESO
  String transactionId = UUID.randomUUID().toString().replaceAll('-', '').substring(0,20)

  HistorialAcademico historialAcademico

  static hasMany = [descuentos : Descuento]

  Date dateCreated
  Date lastUpdated

  static constraints = {
    conceptoDePago size:1..100,blank:false
    cantidadDePago min:1.0
    fechaDePago nullable: true
    transactionId size:20..20
    historialAcademico nullable: true
  }
}
