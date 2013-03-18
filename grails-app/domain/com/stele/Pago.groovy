package com.stele

class Pago {

  String conceptoDePago
  Date fechaDePago
  BigDecimal cantidadDePago
  TipoDePago tipoDePago
  EstatusDePago estatusDePago
  String transactionId = UUID.randomUUID().toString().replaceAll('-', '').substring(0,20)

  HistorialAcademico historialAcademico

  static constraints = {
    conceptoDePago size:1..100,blank:false
    cantidadDePago min:1,blank:false
    transactionId size:20..20
  }
}
