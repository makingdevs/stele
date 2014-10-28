package com.stele

import grails.test.mixin.TestFor
import spock.lang.*
import com.payable.*

@TestFor(CobroParaCamadaService)
@Mock([PaymentScheme,Payment,Discount,ApplicableDiscount])
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
      def applicableDiscountForPayment = new ApplicableDiscount(expirationDate:paymentGroupCommand.expirationDatesForDiscounts[0],
      discount:discount)
      def applicableDiscountServiceMock = mockFor(ApplicableDiscountService) 

      applicableDiscountServiceMock.demand.generateApplicableDiscountsForPaymentWithPaymentSchemeAndReferenceDate(1..1){ Long id, Date dueDate, def expirationDatesForDiscounts -> 
        [applicableDiscountForPayment] 
      }

      applicableDiscountServiceMock.demand.addApplicableDiscountToAPayment(1..1){ ApplicableDiscount applicableDiscount, Long paymentId ->
        paymentsList[0].addToApplicableDiscounts(applicableDiscount)
        return paymentsList[0].save(validate:false)
      }

      service.applicableDiscountService = applicableDiscountServiceMock.createMock()

    when:
      def pagos = service.obtenerPagosConDescuentosAplicablesSiTienenFechaDeVencimiento(paymentGroupCommand, paymentScheme, paymentsList) 
      applicableDiscountServiceMock.verify()
    then:  
      assert pagos.size() == 1
      assert pagos.first().applicableDiscounts.size() == 1  
      assert pagos.first().dueDate.clearTime() == (new Date()+10).clearTime()
      assert pagos.first().applicableDiscounts.first().expirationDate.clearTime() == (new Date()+5).clearTime()  
  }

  def "Obtener fechas de vencimiento para los descuentos aplicables a partir de los días de vencimiento"(){
    given: "una lista de dias de vencimento de los descuentos y los meses para los pagos recurrentes"
      def diasVencimientoDescuentosAplicables = [11,22] 
      def months = [8,9,10]
    when: 
      def fechasDeVencimiento = service.generarFechasDeVencimientoParaDescuentosAplicablesAPartirDeLosDiasDeVencimiento(diasVencimientoDescuentosAplicables,months) 
    then:
      assert fechasDeVencimiento.size() == 6
      assert fechasDeVencimiento*.toCalendar()*.get(Calendar.MONTH) == [8,9,10,8,9,10]
      assert fechasDeVencimiento*.toCalendar()*.get(Calendar.DAY_OF_MONTH) == [11,11,11,22,22,22]
      assert fechasDeVencimiento.first().toCalendar()[Calendar.YEAR] == (new Date()).toCalendar()[Calendar.YEAR]+1
  }
      
  @Ignore
  def "Obtener los descuentos aplicables para los cobros recurrentes"(){
    given:"un conjunto de fechas de vencimiento para los descuentos aplicables y un esquema de pago"
      def fechasDeVencimiento = service.generarFechasDeVencimientoParaDescuentosAplicablesAPartirDeLosDiasDeVencimiento([11],[8,9,10]) 
      def paymentSchema = new PaymentScheme() 
    when:
         
    then:  
      
  }

}
