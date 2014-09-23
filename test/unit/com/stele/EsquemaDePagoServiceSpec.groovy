package com.stele

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import com.payable.*

@TestFor(PaymentSchemeService)
@Mock([Concept,Institucion,Surcharge,Discount,PaymentScheme])
class EsquemaDePagoServiceSpec extends Specification {

  def "Generar un objeto esquema de pago nuevo"() {
    setup:
      Institucion institucion = new Institucion()
      institucion.name = "making_devs"
      institucion.save(validate:false)
    and:
      Concept concept = new Concept()
      concept.description = "concepto"
      concept.organization = institucion
      concept.save(validate:false)
    and:
      Surcharge surcharge = new Surcharge()
      surcharge.amount = 350
      surcharge.save(validate:false) 
    and:
      Discount discount = new Discount()
      discount.discountName = "descuento"
      discount.amount = 5000
      discount.previousDaysForCancelingDiscount = 6
      discount.organization = institucion
      discount.save(validate:false)
    and:
      PaymentGroupCommand pgc = new PaymentGroupCommand()
      pgc.paymentAmount = 13000
      pgc.paymentConcept = "concepto"
      pgc.surchargeId = surcharge.id
      pgc.discountIds = [discount.id]
    when:
      def paymentScheme = service.savePaymentScheme(pgc)
    then:
      assert paymentScheme.id > 0
      assert paymentScheme.surcharge.id >0
      assert paymentScheme.paymentAmount == 13000
  }


}
