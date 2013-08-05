package com.stele

class Recargo {

  BigDecimal porcentaje
  BigDecimal cantidad

  Date dateCreated
  Date lastUpdated

  Institucion institucion

  static constraints = {
    porcentaje nullable: true, min:0.0
    cantidad nullable: true, min:0.0
  }

}