package com.stele

class Concepto {

  String descripcion

  Institucion institucion

  Date dateCreated
  Date lastUpdated

  static constraints = {
    descripcion blank:false, size:1..150
  }

}
