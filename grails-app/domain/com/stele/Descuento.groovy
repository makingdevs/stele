package com.stele

class Descuento {

  String nombreDeDescuento
  BigDecimal porcentaje
  BigDecimal cantidad
  Date fechaDeVencimiento

  Date dateCreated
  Date lastUpdated

  Institucion institucion

  static constraints = {
    nombreDeDescuento blank:false, size:1..150
    porcentaje nullable: true, min:0.0
    cantidad nullable: true, min:0.0
  }

  String toString(){
    "${nombreDeDescuento} por ${porcentaje} % - \$ ${cantidad}"
  }

}
