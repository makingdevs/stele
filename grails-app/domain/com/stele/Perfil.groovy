package com.stele

class Perfil {

  String nombre
  String apellidoPaterno
  String apellindoMaterno
  Date fechaDeNacimiento
  Sexo sexo = Sexo.QUIMERA

  static belongsTo = [dependiente : Dependiente]
  static hasMany = [direccion: Direccion, telefonos: Telefono]

  Date dateCreated
  Date lastUpdated

  static constraints = {
    nombre size:1..50,blank:false
    apellidoPaterno size:1..50,blank:false
    apellindoMaterno size:1..50,blank:true,nullable:true
  }
}