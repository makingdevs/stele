package com.stele

import grails.test.mixin.TestFor
import spock.lang.Specification
import com.payable.*

@TestFor(CobroParaCamadaService)
@Mock([PaymentScheme,Payment,Discount])
class CobroParaCamadaServiceSpec extends Specification {
  
  def "Obtener pagos con descuentos aplicables"(){
    given:"una lista de pagos y un esquema de pagos con descuentos"
      def paymentGroupCommand = new PaymentGroupCommand(expirationDatesForDiscounts:[new Date()+5])
      def paymentsList = [new Payment(dueDate:new Date()+10).save(validate:false)]
      def discount = new Discount(discountName:"Por pronto pago").save(validate:false)
      def paymentScheme = new PaymentScheme(paymentAmount:500)
      paymentScheme.addToDiscounts(discount)
      paymentScheme.save(validate:false)

    and:
      def applicableDiscountServiceMock = mockFor(ApplicableDiscountService) 
      applicableDiscountServiceMock.demand.generateApplicableDiscountsForPaymentWithPaymentSchemeAndReferenceDate(1..1){ Integer id, Date dueDate, def expirationDatesForDiscounts -> new ApplicableDiscount()  }
      applicableDiscountServiceMock.demand.addApplicableDiscountToAPayment(1..1){ ApplicableDiscount ad, Payment payment ->
        paymentList[0]
      }
      service.applicableDiscountService = applicableDiscountServiceMock.createMock()
    when:
      def pagos = service.obtenerPagosConDescuentosAplicablesSiTienenFechaDeVencimiento(paymentGroupCommand, paymentScheme, paymentsList) 
      applicableDiscountServiceMock.verify()
    then:  
      pagos.size() == 1 
  }
}
