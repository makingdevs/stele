package com.stele

import com.stele.seguridad.Usuario
import grails.converters.JSON
import com.makingdevs.*

class TelefonoController {

  def springSecurityService

  def agregarTelefonoAsync(TelefonoCommand cmd) {
    if(cmd.hasErrors()) {
      log.debug "U JUST SHIT THE BED!!!"
      return 
    }

    def usuario = springSecurityService.currentUser
    Perfil perfil = usuario.perfil

    Telefono telefono = new Telefono(cmd.properties)
    perfil.addToTelefonos(telefono)
    perfil.save(flush:true)
    render template:"/telefono/list", model:[telefonos:perfil.telefonos]
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
