package com.stele

class Institucion {

  String nombre

  Date dateCreated
  Date lastUpdated

  static hasMany = [direcciones: Direccion, telefonos: Telefono, distribucionesInstitucionales : DistribucionInstitucional]

  static constraints = {
    nombre size:1..100,blank:false
  }

}
