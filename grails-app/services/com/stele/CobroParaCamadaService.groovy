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
    } 
    listaDePagos << pagos[0] 
  }

}
