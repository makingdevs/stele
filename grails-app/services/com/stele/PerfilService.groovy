package com.stele

import com.stele.seguridad.Usuario

class PerfilService {

  def actualizarPasswordForUser(String nuevaContrasenia, def usuario) {
    log.debug "updating password"
    usuario.password = nuevaContrasenia
    usuario.save(flush:true)
    usuario
  }

}