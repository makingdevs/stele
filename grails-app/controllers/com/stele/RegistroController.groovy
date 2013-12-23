package com.stele

import com.makingdevs.*
import com.megatome.grails.RecaptchaService
import grails.util.Environment

class RegistroController {

  RecaptchaService recaptchaService
  def usuarioService

  def index() {
  }

  def crear(){    
    if (!recaptchaService.verifyAnswer(session, request.getRemoteAddr(), params) &&  Environment.current == "PRODUCTION")  {
      flash.error = "Favor de verificar los caracteres ingresados"
      render (view: "index", model:[params:params])
    } else { 
      usuarioService.registrarUsuarioDirector(params)
      redirect controller:'login'
    }
  } 
}