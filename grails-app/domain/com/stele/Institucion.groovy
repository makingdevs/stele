package com.stele

class Institucion {

  String nombre

  static hasMany = [direccion: Direccion, telefonos: Telefono]

  static constraints = {
    nombre size:1..100,blank:false
  }

}
