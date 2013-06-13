package com.stele

import com.stele.seguridad.Usuario
import com.stele.seguridad.Rol
import com.stele.seguridad.UsuarioRol

class RegistroController {

  def index() { }

  def crear(){    
    Institucion institucion = new Institucion(params.institucion)
    Usuario usuario = new Usuario(params.usuario + [enabled:true])
    Perfil perfil = new Perfil(params.perfil)
    if(!Usuario.findByUsername(usuario.username)){
      def rol = Rol.findByAuthority("ROLE_DIRECTOR")
      usuario.perfil = perfil.save()
      usuario.addToInstituciones(institucion)
      usuario.save()
      UsuarioRol.create(usuario, rol, true)
    }
    redirect controller:'login'
  }
}