package com.stele

class PerfilController {

  def springSecurityService
  def perfilService

  def index() {
    def usuarioActual = springSecurityService.currentUser
    [usuarioActual : usuarioActual]
  }

  def actualizarPassword(UpdatePasswordCommand upc) {
    log.debug "actualizando passwords"

    if(upc.hasErrors()) {
      render upc.errors
      return 
    }

    perfilService.actualizarPasswordForUser(upc.nuevaContrasenia, springSecurityService.currentUser)
    redirect controller:'perfil'
  }

}

class UpdatePasswordCommand {

  String nuevaContrasenia
  String confirmaContrasenia

  static constraints = {
    nuevaContrasenia blank:false, nullable : false, minSize:6
    confirmaContrasenia blank:false, nullable : false, minSize:6, validator: { value, obj -> 
      value.size() == obj.nuevaContrasenia.size() && value == obj.nuevaContrasenia
    }
  }
}