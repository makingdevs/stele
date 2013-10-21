package com.stele

import com.stele.Dependiente
import com.makingdevs.*
import com.payable.*

class ComprobanteController {

  def pagoService
  def comprobanteService
  def perfilService

  def show() {
    def pago = pagoService.obtenerPagoParaValidarComprobante(params.long('id'))
    def dependiente = Payable.withCriteria {
      pagos {
        eq "id", pago.id
      }
    }
    def perfil = perfilService.obtenerPerfilDeUsuario(dependiente.perfilId)
    [pago: pago, perfil:perfil]
  }

  def validarComprobante() {
    comprobanteService.aprobarPago(params.transactionId, params.fechaPago, params.tipoPago as TipoDePago)
    flash.success = "El comprobante fue aprobado"
    redirect (controller: "Pago", action: "mostrarPagosAsociadosALaInstitucionEnBaseAHistorialesAcademicos")
  }

  def rechazarPago() {
    comprobanteService.rechazarPago(params.transactionId)
    redirect (controller: "Pago", action: "mostrarPagosAsociadosALaInstitucionEnBaseAHistorialesAcademicos")
  }

}
