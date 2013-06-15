package com.stele

class CicloEscolar {

  String clave
  String descripcion
  Date fechaInicio
  Date fechaFin

  Date dateCreated
  Date lastUpdated

  static constraints = {
    clave size:1..80,blank:false
    descripcion blank:true 
  }

}

