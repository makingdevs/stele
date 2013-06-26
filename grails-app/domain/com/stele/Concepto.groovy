package com.stele

class Concepto {

  String concepto

  Institucion institucion

  Date dateCreated
  Date lastUpdated

  static constraints = {
    concepto blank:false, size:1..150
  }

}
