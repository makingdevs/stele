package com.stele

import com.stele.seguridad.Usuario

class UsuarioController {

  static scaffold = Usuario

  def springSecurityService

  def edicion() {
  }

  def obtenerPerfilUsuario() {
    def usuarioActual = springSecurityService.currentUser

    render(contentType:"text/json") {
      [
        nombreTutor : usuarioActual.perfil.nombre,
        apellidosTutor : "${usuarioActual.perfil.apellidoPaterno} ${usuarioActual.perfil.apellidoMaterno ?: ''}",
        urlImagenTutor : "http://www.blogdelossimpson.com.ar/wp-content/uploads/2008/08/nelson1.gif"
      ]
    }
  }

  def dependientes() {
    def usuarioActual = springSecurityService.currentUser

    def dependientes = []

    usuarioActual?.dependientes?.each {
      def mapa = [:]
      mapa.imagen = ""
      mapa.matricula = it.matricula
      mapa.nombreCompleto = "${it.perfil?.nombre} ${it.perfil?.apellidoPaterno} ${it.perfil?.apellidoMaterno ?: ''} "
      mapa.nivel = "lol"
      mapa.grado = "lol"
      mapa.grupo = "lol"
      dependientes << mapa
    }


    render(contentType:"text/json") {
      dependientes
    }
  }

}
