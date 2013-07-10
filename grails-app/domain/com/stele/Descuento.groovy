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
    porcentaje min:0.0
    cantidad min:0.0
  }

}
