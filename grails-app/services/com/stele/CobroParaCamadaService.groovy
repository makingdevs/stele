package com.stele

import grails.transaction.Transactional
import com.payable.*

@Transactional
class CobroParaCamadaService {

  def applicableDiscountService 
  
  def obtenerPagosConDescuentosAplicablesSiTienenFechaDeVencimiento(PaymentGroupCommand pgc,PaymentScheme paymentScheme, def pagos){
    def listaDePagos = []
    pagos.each{ pago -> 
      def descuentosAplicables = applicableDiscountService.generateApplicableDiscountsForPaymentWithPaymentSchemeAndReferenceDate(paymentScheme.id, pago.dueDate, pgc.expirationDatesForDiscounts)
      listaDePagos += asignarDescuentosAplicablesALosPagos(descuentosAplicables,pago)
    } 

    listaDePagos 
  }
  
  def asignarDescuentosAplicablesALosPagos(def applicableDiscounts,Payment payment){
    def paymentList = []

    applicableDiscounts.each{ applicableDiscount ->
      paymentList << applicableDiscountService.addApplicableDiscountToAPayment(applicableDiscount, payment.id) 
    }

    paymentList
  }

  def generarFechasDeVencimientoParaDescuentosAplicablesAPartirDeLosDiasDeVencimiento(diasVencimiento,month){
    def fechasDeVencimiento = []
    def now = (new Date()).toCalendar()
    
    diasVencimiento?.each{ diaVencimiento ->
      def fecha = Calendar.instance 
      fecha[Calendar.MONTH] = month   
      if(fecha[Calendar.MONTH] < now[Calendar.MONTH])
        fecha[Calendar.YEAR]+=1 
      
      fecha[Calendar.DAY_OF_MONTH] = diaVencimiento   

      fechasDeVencimiento << fecha.time
    }
    
    fechasDeVencimiento.sort()
  }
  
  def obtenerPagosRecurrentesConDescuentosAplicables(PaymentScheme paymentScheme, CamadaPagoCommand camadaPagoCommand, def pagos, Long numeroInstancias){
    def pagosConDescuentos = []          
    def descuentosAplicables = []
    def index = 0

    numeroInstancias.times{ i ->
      camadaPagoCommand.meses.each{ mes -> 
        def monthOfThePayment =  pagos[index]?.dueDate.toCalendar()[Calendar.MONTH]
        def fechasDeVencimiento = generarFechasDeVencimientoParaDescuentosAplicablesAPartirDeLosDiasDeVencimiento(camadaPagoCommand.diasVencimientoDescuento,monthOfThePayment)
        descuentosAplicables =  applicableDiscountService.generateApplicableDiscountsForPaymentWithPaymentSchemeAndReferenceDate(paymentScheme.id,pagos[index]?.dueDate,fechasDeVencimiento)
        descuentosAplicables.each{ descuentoAplicable ->
          pagos[index] = applicableDiscountService.addApplicableDiscountToAPayment(descuentoAplicable,pagos[index].id) 
        } 
        
        pagosConDescuentos << pagos[index]
        index++;
      }  
    }    

    pagosConDescuentos 
  }

}
