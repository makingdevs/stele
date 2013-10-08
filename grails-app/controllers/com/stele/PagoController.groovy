package com.stele

import com.payable.*

class PagoController {

  def springSecurityService
  def pagoService

  def index() { 
    def pagosDeUsuario = pagoService.obtenerPagosDeUsuario(springSecurityService.currentUser)
    [pagosDeUsuario: pagosDeUsuario.pagos, usuario: springSecurityService.currentUser]
  }

  def pagosDeUnaInstitucion() {
    def pago = pagoService.obtenerPagosDeUnaInstitucion(springSecurityService.currentUser)
   [
   pagosInstitucion: Pago.findAllByHistorialAcademicoInList(pago.historial), 
   usuario: springSecurityService.currentUser, 
   pagosCount: pago.dependiente]
  }

}
