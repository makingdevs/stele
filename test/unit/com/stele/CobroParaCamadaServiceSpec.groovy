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

  def "obtener fechas de vencimiento para los descuentos aplicables a partir de los dias de vencimiento"(){
    given: "una lista de dias de vencimento de los descuentos y el mes del pago"
      def diasVencimientoDescuentosAplicables = [11,22] 
    when: 
      def fechasDeVencimiento = service.generarFechasDeVencimientoParaDescuentosAplicablesAPartirDeLosDiasDeVencimiento(diasVencimientoDescuentosAplicables,month) 
    then:
      fechasDeVencimiento.size() == 2
      fechasDeVencimiento*.toCalendar()*.get(Calendar.MONTH) == _months 
      fechasDeVencimiento*.toCalendar()*.get(Calendar.DAY_OF_MONTH) == _days 
      fechasDeVencimiento*.toCalendar()*.get(Calendar.YEAR) == _year
    where:
      month | _months   || _days    || _year
      8     |  [8,8]    || [11,22]  ||  [2015,2015]
      9     |  [9,9]    || [11,22]  ||  [2014,2014]
      10    |  [10,10]  || [11,22]  ||  [2014,2014]
  }

  def "Obtener los descuentos aplicables para los cobros recurrentes"(){
    given:"un esquema de pago y los pagos"
      def camadaPagoCommand = new CamadaPagoCommand(meses:[10,11],diasVencimientoDescuento:[11])
      def discount = new Discount(discountName:"Descuento_Prueba").save(validate:false)
      def paymentScheme = new PaymentScheme() 
      paymentScheme.addToDiscounts(discount).save(validate:false) 
      def fechasDeVencimiento = []
      camadaPagoCommand.meses.each{
        fechasDeVencimiento += service.generarFechasDeVencimientoParaDescuentosAplicablesAPartirDeLosDiasDeVencimiento(camadaPagoCommand.diasVencimientoDescuento,camadaPagoCommand.meses.first())
      }
      def calendars = fechasDeVencimiento*.toCalendar()
      calendars.collect{ it[Calendar.DAY_OF_MONTH] = 25 }  
      def pagos = []
      calendars.each{
        pagos << new Payment(dueDate:it.time).save(validate:false) 
      }
       
      def applicableDiscountServiceMock = mockFor(ApplicableDiscountService) 

      camadaPagoCommand.meses.each{
        applicableDiscountServiceMock.demand.generateApplicableDiscountsForPaymentWithPaymentSchemeAndReferenceDate(){ Long id, Date dueDate, def expirationDatesForDiscounts -> 
          new ApplicableDiscount()
        }
        applicableDiscountServiceMock.demand.addApplicableDiscountToAPayment(){ ApplicableDiscount applicableDiscount, Long paymentId ->
          new Payment(applicableDiscount:applicableDiscount) 
        }
      }
     
      service.applicableDiscountService = applicableDiscountServiceMock.createMock()
    when:
      def pagosConDescuentos = service.obtenerPagosRecurrentesConDescuentosAplicables(paymentScheme,camadaPagoCommand,pagos,1)  
      applicableDiscountServiceMock.verify()
    then: 
     assert pagosConDescuentos.size() == 2 
     assert pagosConDescuentos*.applicableDiscounts.size() == 2
  }

}
