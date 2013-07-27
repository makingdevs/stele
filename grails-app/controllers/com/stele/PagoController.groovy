package com.stele

import com.stele.Pago

class PagoController {

  def springSecurityService
  def pagoService

  def index() { 
    def pagosDeUsuario = pagoService.obtenerPagosDeUsuario(springSecurityService.currentUser)
    [pagosDeUsuario: pagosDeUsuario, usuario: springSecurityService.currentUser]
  }

  def pagosDeUnaInstitucion() {
    def historial = pagoService.obtenerPagosDeUnaInstitucion(springSecurityService.currentUser)
   [
   pagosInstitucion: Pago.findAllByHistorialAcademicoInList(historial,[max : params.max?:10,offset : params.offset?:0 ]), 
   usuario: springSecurityService.currentUser, 
   pagosCount: historial.size()]
  }

}
