package com.stele

import com.stele.seguridad.Usuario

class UsuarioController {

  static scaffold = Usuario

  def springSecurityService

  def perfil() {
    def usuarioActual = springSecurityService.currentUser
    [usuarioActual : usuarioActual]
  }

}
