package com.stele

import com.payable.PaymentGroupCommand
import java.text.SimpleDateFormat

class WrapperCommandService {

  PaymentGroupCommand generarParseoDeCamadaPagoCommandAGrupoPagoCommand(CamadaPagoCommand camadaPagoCommand, Institucion institucion) {
    PaymentGroupCommand pgc = new PaymentGroupCommand()
    if (camadaPagoCommand.recargoid){
      if (camadaPagoCommand.recargoid.first() != "")
        pgc.surchargeId = camadaPagoCommand.recargoid?.first()?.toLong()
    }
    
    if(camadaPagoCommand.fechasDeExpiracionDescuento){
      def sdf = new SimpleDateFormat("dd/MM/yy")
      def fechasDeExpiracionParaDescuentos = [];

      camadaPagoCommand.fechasDeExpiracionDescuento.each{ fechaDeExpiracion ->
        try{
          fechasDeExpiracionParaDescuentos << sdf.parse(fechaDeExpiracion) 
        }catch(Exception exception){
          log.error "The date has not been converted"
        }
      }
      pgc.expirationDatesForDiscounts = fechasDeExpiracionParaDescuentos
    }

    if (!pgc.surchargeId)
      pgc.surchargeId = camadaPagoCommand?.idRecargo?.toLong()
    pgc.paymentAmount = camadaPagoCommand.cantidadDePago ?: camadaPagoCommand.cantidadDePagoRecurrente
    pgc.paymentConcept = camadaPagoCommand.conceptoDePago ?: camadaPagoCommand.conceptoDePagoRecurrente
    if (camadaPagoCommand?.fechaDeVencimiento)  
      pgc.dueDate = new Date().parse("dd/MM/yyyy", camadaPagoCommand?.fechaDeVencimiento)
    if (camadaPagoCommand.descuentos){
      if (camadaPagoCommand.descuentos.first() != "") 
        pgc.discountIds = camadaPagoCommand?.descuentos.collect{it.replace('[','').replace(']','')}
    }
    if (!pgc.discountIds)
      pgc.discountIds= camadaPagoCommand.idsDescuentos?.replace('[','')?.replace(']','')?.split(',')
    pgc.organization = institucion
    pgc.daysPaymentDue = camadaPagoCommand.diasVencimientoPago
    pgc.instances = obtenerListaDeDependientes(camadaPagoCommand)
    pgc.months = camadaPagoCommand.meses ?: []
    pgc.doublePayment = camadaPagoCommand?.pagoDoble ?:[]
    pgc
  }

  private def obtenerListaDeDependientes(CamadaPagoCommand camadaPagoCommand) {
    def listaDependientesExistentes = []
    def dependientes = Dependiente.findAllByCamada(camadaPagoCommand.camada)
    listaDependientesExistentes << camadaPagoCommand?.listaDependientes?.replace('[','')?.replace(']','')?.split(',')
    listaDependientesExistentes?.removeAll(dependientes*.id)

    if (listaDependientesExistentes){
      dependientes+= Dependiente.withCriteria {
        'in'('id', listaDependientesExistentes.flatten()*.toLong())
      }
    }
    dependientes
  }

}
