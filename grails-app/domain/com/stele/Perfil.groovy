package com.stele

class Perfil {

  String nombre
  String apellidoPaterno
  String apellindoMaterno
  Date fechaDeNacimiento

  static hasMany = [direccion: Direccion, telefonos: Telefono]

  static constraints = {
  }
}
