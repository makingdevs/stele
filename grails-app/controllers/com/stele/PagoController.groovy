package com.stele

import com.payable.*

class PagoController {

  def springSecurityService
  def pagoService
  def historialAcademicoService
  def comprobanteService

  def index() { 
    def pagosDeUsuario = pagoService.estadoDeCuentaUsuario(springSecurityService.currentUser)
    [pagosDeUsuario: pagosDeUsuario, usuario: springSecurityService.currentUser]
  }

  def mostrarPagosAsociadosALaInstitucionEnBaseAHistorialesAcademicos() {
   def historialesAcademicos = historialAcademicoService.obtenerHistorilesAcademicosDelaInstitucion(springSecurityService.currentUser)
   def pagosAsociadosAInstitucion = historialesAcademicos*.dependiente*.pagos.flatten()
   render (view: "pagosAsociadosAUnaInstitucion", model:[pagosInstitucion:pagosAsociadosAInstitucion, usuario:springSecurityService.currentUser])
  }

  def generarPagoEnVentanilla() {
    render (view:"manual")
  }

  def pagoInmediatoVentanilla() {
    def fecha = new Date().parse("dd/MM/yyyy", params.fechaDePago)
    def pago = comprobanteService.aprobarPago(params.transactionId,fecha, params.tipoDePago)
    render view:"manual"
  }

}
