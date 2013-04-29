package com.stele

import com.stele.seguridad.Usuario

class UsuarioController {

  static scaffold = Usuario

  def springSecurityService

  def edicion() {
  }

  def obtenerPerfilUsuario() {
    def usuarioActual = springSecurityService.currentUser
    log.debug "username : ${usuarioActual}"
    log.debug "dependientes : ${usuarioActual.dependientes}"

    render(contentType:"text/json") {
      [
        nombreTutor : usuarioActual.perfil.nombre,
        apellidosTutor : "${usuarioActual.perfil.apellidoPaterno} ${usuarioActual.perfil.apellidoMaterno ?: ''}",
        urlImagenTutor : "http://www.blogdelossimpson.com.ar/wp-content/uploads/2008/08/nelson1.gif",
        dependientes : [usuarioActual.dependientes]
      ]
    }
  }

}
