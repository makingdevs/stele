package com.stele

import com.stele.seguridad.Usuario

class UsuarioController {

  static scaffold = Usuario

  def edicion() {
  }

  def obtenerPerfilUsuario() {
    render(contentType:"text/json") {
      [nombreTutor : "ROFLMAO", apellidosTutor : "La Bamba", urlImagenTutor : ""]
    }
  }

}
