package com.stele

class EsquemaDePago {

  BigDecimal cantidadDePago
  Concepto concepto
  Recargo recargo

  static hasMany = [descuentos:Descuento]

  static constraints = {
    recargo(nullable:true)
  }

}
