package com.stele

class Telefono {

  String numeroTelefonico
  TipoDeTelefono tipoDeTelefono = TipoDeTelefono.CELULAR
  String extension

  Date dateCreated
  Date lastUpdated

  static constraints = {
    numeroTelefonico size:1..10,blank:false
    extension size:1..6,nullable:true,blank:true
  }
}
