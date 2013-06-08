package com.stele

import com.stele.seguridad.Usuario

class PerfilService {

  def actualizarPasswordForUser(String nuevaContrasenia, def usuario) {
    usuario.password = nuevaContrasenia
    usuario.save(flush:true)
    usuario
  }

}