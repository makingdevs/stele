package com.stele

class PerfilController {

  def springSecurityService

  def index() {
    def usuarioActual = springSecurityService.currentUser
    [usuarioActual : usuarioActual]
  }

  def actualizarPassword() {
    log.debug "params : ${params}"
    redirect controller:'perfil'
  }

}
