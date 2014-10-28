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
    def payemntList = []
    applicableDiscounts.each{ applicableDiscount ->
      applicableDiscountService.addApplicableDiscountToAPayment(applicableDiscount, payment.id) 
    }
  }
}
