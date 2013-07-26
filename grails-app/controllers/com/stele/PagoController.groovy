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
    params.max
    params.fetch = [historialAcademico:"${historial}"]
    params.offset
    params.fetchSize
    params.order = "asc"
    println params
   [pagosInstitucion: Pago.list(params), usuario: springSecurityService.currentUser, pagosCount: historial.size()]
  }

}
