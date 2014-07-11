package com.stele

import com.stele.Dependiente
import com.makingdevs.*
import com.payable.*

class ComprobanteController {

  def pagoService
  def comprobanteService
  def perfilService
  def dependienteService
  def notificacionService

  def show() {
    def pago = pagoService.obtenerPagoParaValidarComprobante(params.long('id'))
    def dependiente = Payable.withCriteria {
      pagos {
        eq "id", pago.id
      }
    }
    def perfil = perfilService.obtenerPerfilDeUsuario(dependiente.usuario.perfil.first().id)
    [pago: pago, perfil:perfil]
  }

  def validarComprobante() {
    def pago = comprobanteService.aprobarPago(params.transactionId, Date.parse('dd/MM/yyyy',params.fechaDePago), params.tipoDePago)
    def dependiente = dependienteService.obtenerDependientesPorPagos([pago])
    notificacionService.notificarPagoAprovado(dependiente)
    flash.success = "El comprobante fue aprobado"
    redirect (controller: "Pago", action: "mostrarPagosAsociadosALaInstitucionEnBaseAHistorialesAcademicos")
  }

  def rechazarPago() {
    def pago = comprobanteService.rechazarPago(params.transactionId)
    def dependiente = dependienteService.obtenerDependientesPorPagos([pago])
    notificacionService.notificarPagoRechazado(dependiente)
    log.error "El pago se ha rechazado"
    redirect (controller: "Pago", action: "mostrarPagosAsociadosALaInstitucionEnBaseAHistorialesAcademicos")
  }

  def detalle() {
    def pago = pagoService.obtenerPagoParaValidarComprobante(params.long('id'))
    def dependiente = Payable.withCriteria {
      pagos {
        eq "id", pago.id
      }
    }
    def perfil = perfilService.obtenerPerfilDeUsuario(dependiente.usuario.perfil.first().id)
    [pago: pago, perfil:perfil] 
  }

  def comprobantePagoMes(){
    def pago = pagoService.obtenerPagoParaValidarComprobante(params.long('id'))
    def dependiente = Payable.withCriteria {
      pagos {
        eq "id", pago.id
      }
    }
    [pago: pago]
  }

  def descargarComprobante(){
    response.setHeader "Content-disposition", "attachment; filename=comprobante";
    response.outputStream <<  comprobanteService.obtenerBytesDeComprobante(params.pagoId)
  }

}
