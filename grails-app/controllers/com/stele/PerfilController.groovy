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

    perfilService.actualizarPasswordForUser(upc, springSecurityService.currentUser)
    redirect controller:'perfil'
  }

}

