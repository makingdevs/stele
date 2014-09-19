package com.stele

import com.stele.Dependiente
import com.makingdevs.*
import com.payable.*

class ComprobanteController {

  def paymentService
  def proofOfPaymentService 
  def perfilService
  def dependienteService
  def notificacionService

  def show() {
    def payment = Payment.get(params.long('id'))
    def dependiente = dependienteService.findDependienteFromPaymentId(payment.id)

    def perfil = perfilService.obtenerPerfilDeUsuario(dependiente.usuario.perfil.first().id)
    [payment:payment, perfil:perfil]
  }

  def validarComprobante() {
    def payment = proofOfPaymentService.approvePayment(params.transactionId, Date.parse('dd/MM/yyyy',params.fechaDePago), params.tipoDePago, params.folioBanco)
    def dependiente = dependienteService.findDependienteFromPaymentId(payment.id)
    notificacionService.notificarPagoAprovado(dependiente)
    flash.success = "El comprobante fue aprobado"
    redirect (controller: "Pago", action: "mostrarPagosAsociadosALaInstitucionEnBaseAHistorialesAcademicos")
  }

  def rechazarPago() {
    def payment = proofOfPaymentService.rejectPayment(params.transactionId)
    def dependiente = dependienteService.findDependienteFromPaymentId(payment.id)
    notificacionService.notificarPagoRechazado(dependiente)
    redirect (controller: "Pago", action: "mostrarPagosAsociadosALaInstitucionEnBaseAHistorialesAcademicos")
  }

  def detalle() {
    def Payment = pagoService.obtenerPagoParaValidarComprobante(params.long('id'))
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
    response.setContentType("application/octet-stream");
    response.setHeader "Content-disposition", "attachment; filename=Comprobante";
    response.outputStream <<  proofOfPaymentService.bytesOfProofOfPayment(params.pagoId)
  }

}
