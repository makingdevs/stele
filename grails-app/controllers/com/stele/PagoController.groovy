package com.stele

import com.payable.*

class PagoController {

  def springSecurityService
  def pagoService
  def historialAcademicoService

  def index() { 
    def pagosDeUsuario = pagoService.estadoDeCuentaUsuario(springSecurityService.currentUser)
    [pagosDeUsuario: pagosDeUsuario, usuario: springSecurityService.currentUser]
  }

  def mostrarPagosAsociadosALaInstitucionEnBaseAHistorialesAcademicos() {
   def pagosAsociadosAInstitucion = historialAcademicoService.obtenerHistorilesAcademicosYPagosDeUnaInstitucion(springSecurityService.currentUser)
   render (view: "pagosAsociadosAUnaInstitucion", model:[pagosInstitucion:pagosAsociadosAInstitucion, usuario:springSecurityService.currentUser])
  }

}
