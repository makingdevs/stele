package com.stele

import com.makingdevs.*

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