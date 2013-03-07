package com.stele

class Profile {

  String nombre
  String apellidoPaterno
  String apellidoMaterno
  String curp
  Date fechaDeNacimiento
  Sexo sexo

  Date dateCreated
  Date lastUpdated

  static constraints = {
    nombre blank:false, size:1..100
    apellidoPaterno blank:false, size:1..100
    apellidoMaterno nullable:true, size:1..100
    fechaDeNacimiento nullable:true
    sexo()
    curp size:1..18
  }
}
