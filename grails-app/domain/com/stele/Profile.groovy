package com.stele

class Profile {

  String nombre
  String apellidoPaterno
  String apellidoMaterno
  String curp
  Date fechaDeNacimiento

  Date dateCreated
  Date lastUpdated

  static constraints = {
    apellidoMaterno blank: true, nullable: true
  }
}
