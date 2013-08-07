package com.stele

class PerfilController {

  def springSecurityService
  def perfilService
  def pagoService

  def index() {
    def usuarioActual = springSecurityService.currentUser
    def pagosVencidos = pagoService.obtenerPagosVencidosUsuario(springSecurityService.currentUser)
    def pagosEnTiempo = pagoService.obtenerPagosEnTiempoDescuento(springSecurityService.currentUser)
    def pagosARealizar = pagoService.obtenerPagosPorRealizar(springSecurityService.currentUser)
    [usuarioActual : usuarioActual, pagosVencidos:pagosVencidos, pagosEnTiempo:pagosEnTiempo, pagosPorRealizar:pagosARealizar]
  }

  def actualizarPassword(UpdatePasswordCommand upc) {
    if(upc.hasErrors()) {
      render upc.errors
      return 
    }
    perfilService.actualizarPasswordForUser(upc.nuevaContrasenia, springSecurityService.currentUser)
    redirect controller:'perfil'
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