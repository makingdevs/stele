package com.stele

class PerfilService {

  def registrar(Perfil perfil) {
    perfil.save()
  }

  def actualizarPasswordForUser(String nuevaContrasenia, def usuario) {
    usuario.password = nuevaContrasenia
    usuario.save(flush:true)
    usuario
  }

}