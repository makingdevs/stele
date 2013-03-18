package com.stele

class Telefono {

  String numeroTelefonico
  TipoDeTelefono tipoDeTelefono
  String extension

  static constraints = {
    numeroTelefonico size:1..10,blank:false
    extension size:1..6,nullable:true,blank:true
  }
}
