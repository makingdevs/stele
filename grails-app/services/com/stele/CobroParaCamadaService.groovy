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

  def generarFechasDeVencimientoParaDescuentosAplicablesAPartirDeLosDiasDeVencimiento(diasVencimiento,months){
    def fechasDeVencimiento = []
    def now = (new Date()).toCalendar()
    diasVencimiento.each{ diaVencimiento ->
      months?.sort().each{ month ->
        def fecha = Calendar.instance 
        fecha[Calendar.MONTH] = month   
        if(fecha[Calendar.MONTH] < now[Calendar.MONTH]){
          fecha[Calendar.YEAR]+=1 
        }

        fecha[Calendar.DAY_OF_MONTH] = diaVencimiento   

        fechasDeVencimiento << fecha.time
      }
    }
    fechasDeVencimiento
  }
  
  def obtenerPagosRecurrentesConDescuentosAplicables(PaymentScheme paymentScheme, def expirationDatesForDiscounts, def pagos){
        
  }

}
