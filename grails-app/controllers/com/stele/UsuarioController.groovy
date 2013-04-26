package com.stele

import com.stele.seguridad.Usuario

class UsuarioController {

  static scaffold = Usuario

  def edicion() {
  }

  def obtenerPerfilUsuario() {
    render(contentType:"text/json") {
      [nombreTutor : "Nelson", apellidosTutor : "Muntz", urlImagenTutor : "http://www.blogdelossimpson.com.ar/wp-content/uploads/2008/08/nelson1.gif"]
    }
  }

}
