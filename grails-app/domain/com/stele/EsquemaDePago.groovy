package com.stele

class EsquemaDePago {

  Concepto concepto
  Recargo recargo

  static hasMany = [descuentos:Descuento]

}
