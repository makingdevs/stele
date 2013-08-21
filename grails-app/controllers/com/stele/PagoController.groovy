package com.stele

import com.stele.Pago

class PagoController {

  def springSecurityService
  def pagoService

  def index() { 
    def pagosDeUsuario = pagoService.obtenerPagosDeUsuario(springSecurityService.currentUser)
    [pagosDeUsuario: pagosDeUsuario.pagos, usuario: springSecurityService.currentUser, pagosCount: pagosDeUsuario.dependiente]
  }

  def pagosDeUnaInstitucion() {
    def pago = pagoService.obtenerPagosDeUnaInstitucion(springSecurityService.currentUser)
   [
   pagosInstitucion: Pago.findAllByHistorialAcademicoInList(pago.historial), 
   usuario: springSecurityService.currentUser, 
   pagosCount: pago.dependiente]
  }

}
