package com.stele

import com.stele.HistorialAcademico
import com.stele.Dependiente
import com.makingdevs.*

class ComprobanteController {

  def pagoService
  def comprobanteService
  def perfilService

  def show() {
    def pago = pagoService.obtenerPagoParaValidarComprobante(params.long('id'))
    def historialAcademico = HistorialAcademico.findById(pago.historialAcademicoId)
    def dependiente = Dependiente.findById(historialAcademico.dependienteId)
    def perfil = perfilService.obtenerPerfilDeUsuario(dependiente.perfilId)
    [pago: pago, perfil:perfil]
  }

  def validarComprobante() {
    comprobanteService.aprobarPago(params.transactionId, params.fechaPago, params.tipoPago as TipoDePago)
    flash.success = "El comprobante fue aprobado"
    redirect (controller: "Pago", action: "pagosDeUnaInstitucion")
  }

  def rechazarPago() {
    comprobanteService.rechazarPago(params.transactionId)
    redirect (controller: "Pago", action: "pagosDeUnaInstitucion")
  }

}
