package com.stele

import com.stele.seguridad.Usuario

class RegistroController {

  def index() { }

  def crear(){    
    Institucion institucion = new Institucion(params.institucion)
    Usuario usuario = new Usuario(params.usuario)
    Perfil perfil = new Perfil(params.perfil)
    usuario.perfil = perfil.save()
    usuario.addToInstituciones(institucion)
    usuario.save()
    render view:'index'
  }
}