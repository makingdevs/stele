package com.stele

import com.makingdevs.*
import grails.converters.JSON

class PerfilController {

  def springSecurityService
  def perfilService

  def index() {
    def usuarioActual = springSecurityService.currentUser
    [usuarioActual : usuarioActual]
  }

  def actualizarPassword(UpdatePasswordCommand upc) {
    if(upc.hasErrors()) {
      render upc.errors
      return 
    }
    perfilService.actualizarPasswordForUser(upc.nuevaContrasenia, springSecurityService.currentUser)
    redirect controller:'perfil'
  }

  def actualizarFechaNacimiento() {
    def perfil = Perfil.get(params.id)
    perfil.fechaDeNacimiento = new Date().parse("dd/MM/yyyy",params.fechaNacimiento)
    perfil.save(failOnError:true)
  }

  def uploadImage(){
    println "hooolllllaaaa : $params"
    def perfil = perfilService.subirImagenPerfil(params.id, params.file)
    println perfil
    render perfil as JSON
  }

}

class UpdatePasswordCommand {

  String nuevaContrasenia
  String confirmaContrasenia

  static constraints = {
    nuevaContrasenia blank:false, nullable : false, minSize:6
    confirmaContrasenia blank:false, nullable : false, minSize:6, validator: { value, obj -> 
      value.size() == obj.nuevaContrasenia.size() && value == obj.nuevaContrasenia
    }
  }
}