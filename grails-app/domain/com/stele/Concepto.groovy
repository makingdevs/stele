package com.stele

class Concepto {

  String concepto

  Date dateCreated
  Date lastUpdated

  static constraints = {
    concepto blank:false, size:1..150
  }

}
