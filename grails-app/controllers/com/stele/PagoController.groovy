package com.stele

class PagoController {

  def springSecurityService
  def pagoService

  def index() { 
    def pagosDeUsuario = pagoService.obtenerPagosDeUsuario(springSecurityService.currentUser)
    [pagosDeUsuario: pagosDeUsuario, usuario: springSecurityService.currentUser]
  }

  def pagosDeUnaInstitucion() {
    def pagosDeInstitucion = pagoService.obtenerPagosXInstitucion(springSecurityService.currentUser)

   [pagosInstitucion: pagosDeInstitucion, usuario: springSecurityService.currentUser]
  }

}
