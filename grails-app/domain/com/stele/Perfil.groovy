package com.stele

import com.stele.seguridad.Usuario

class Perfil {

  String nombre
  String apellidoPaterno
  String apellidoMaterno
  Date fechaDeNacimiento
  Sexo sexo = Sexo.QUIMERA
  String avatar = "http://www.nelson-rives.com/images/noUserPhoto.png"

  static hasMany = [direccion: Direccion, telefonos: Telefono]

  Date dateCreated
  Date lastUpdated

  static constraints = {
    nombre size:1..50,blank:false
    apellidoPaterno size:1..50,blank:false
    apellidoMaterno size:1..50,blank:true,nullable:true
    fechaDeNacimiento nullable:true
    avatar url:true
  }

  String nombreCompleto() {
    "$nombre $apellidoPaterno ${apellidoMaterno ?: ''}"
  }
}
