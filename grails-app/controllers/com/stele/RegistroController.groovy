package com.stele

import com.stele.seguridad.Usuario
import com.stele.seguridad.Rol
import com.stele.seguridad.UsuarioRol
import com.makingdevs.*
import com.megatome.grails.RecaptchaService

class RegistroController {

   RecaptchaService recaptchaService

  def index() { }

  def crear(){    
    if (!recaptchaService.verifyAnswer(session, request.getRemoteAddr(), params))  {
      flash.error = "Favor de verificar los caracteres ingresados"
      render (view: "index", model:[params:params])
    } else {
      Institucion institucion = new Institucion(params.institucion)
      Usuario usuario = new Usuario(params.usuario + [enabled:true])
      Perfil perfil = new Perfil(params.perfil)
      if(!Usuario.findByUsername(usuario.username)){
        def rol = Rol.findByAuthority("ROLE_DIRECTOR")
        usuario.perfil = perfil.save()
        usuario.addToInstituciones(institucion)
        usuario.save()
        log.debug usuario.instituciones
        UsuarioRol.create(usuario, rol, true)
      }
      redirect controller:'login'
    }
  }
}