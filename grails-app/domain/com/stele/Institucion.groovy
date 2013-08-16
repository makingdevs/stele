package com.stele

import com.stele.seguridad.Usuario
import groovy.transform.ToString
import com.makingdevs.*

@ToString
class Institucion {

  String nombre

  Date dateCreated
  Date lastUpdated

  static belongsTo = Usuario
  static hasMany = [direcciones: Direccion, telefonos: Telefono, distribucionesInstitucionales : DistribucionInstitucional, usuarios : Usuario]

  static constraints = {
    nombre size:1..100,blank:false
  }

}
