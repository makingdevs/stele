package com.stele

class TelefonoController {

  def agregarTelefonoAsync(TelefonoCommand cmd) {
    if(cmd.hasErrors()) {
      log.debug "U JUST SHIT THE BED!!!"
      return 
    }

    Telefono tel = new Telefono(cmd.properties)
    tel.save(flush:true)
  }

}

class TelefonoCommand {

  Boolean principal
  String lada
  String numeroTelefonico
  TipoDeTelefono tipoDeTelefono
  String extension

  static constraints = {
    lada nullable:true, blank: true, size:1..3
    numeroTelefonico size:1..10, blank:false, nullable:false
    extension size:1..6, nullable: true, blank:true
    tipoDeTelefono nullable: false
    principal nullable: false
  }

}
