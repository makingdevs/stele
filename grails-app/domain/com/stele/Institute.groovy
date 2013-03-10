package com.stele

class Institute {

  String nombre

  Date dateCreated
  Date lastUpdated

  static constraints = {
    nombre size:1..100
  }
}
