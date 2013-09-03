package com.stele

import org.grails.s3.S3Asset

class Pago {
  String conceptoDePago
  Date fechaDePago
  Date fechaDeVencimiento
  BigDecimal cantidadDePago
  BigDecimal recargosAcumulados = 0
  BigDecimal descuentoAplicable = 0
  TipoDePago tipoDePago = TipoDePago.TRANSFERENCIA_BANCARIA
  EstatusDePago estatusDePago = EstatusDePago.CREADO
  String transactionId = UUID.randomUUID().toString().replaceAll('-', '').substring(0,20)
  S3Asset comprobanteDePago
  Recargo recargo

  HistorialAcademico historialAcademico

  static hasMany = [descuentos : Descuento]

  Date dateCreated
  Date lastUpdated

  static constraints = {
    conceptoDePago size:1..100,blank:false
    cantidadDePago min:1.0
    recargosAcumulados()
    descuentoAplicable()
    fechaDePago nullable: true
    transactionId size:20..20
    historialAcademico nullable:true
    comprobanteDePago nullable:true
    recargo nullable:true
  }

  BigDecimal getSumaDescuentosPorcentaje() {
    descuentos?.porcentaje?.sum()  
  }

  BigDecimal getSumaDescuentosCantidad() {
    descuentos?.cantidad?.sum()  
  }

  BigDecimal getDescuentoRealPorcentaje() {
    ( sumaDescuentosPorcentaje / 100 ) * cantidadDePago 
  }

  BigDecimal getPorcentajeEnBaseACantidad() {
    ( sumaDescuentosCantidad * 100 ) / cantidadDePago
  }

  BigDecimal getCantidadDePagoConRecargos(){
    cantidadDePago + recargosAcumulados
  }

  BigDecimal getCantidadDePagoConDescuento(){
    cantidadDePago - descuentoAplicable
  }

}
