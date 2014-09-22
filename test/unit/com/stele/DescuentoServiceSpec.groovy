package com.stele

import grails.test.mixin.*
import spock.lang.Specification
import com.makingdevs.*
import com.payable.*

@TestFor(DiscountService)
@Mock([Institucion, Discount])
class DescuentoServiceSpec extends Specification {

  def "Obtener todos los descuentodescuentos ligados a una Institucion"() {
    given: 
      Institucion institucion = new Institucion()
      institucion.name = "la chafita"
      institucion.save(validate:false)
    and:
      Discount discount = new Discount()
      discount.discountName = "pruebaDescuentote"
      discount.organization = institucion
      discount.amount = 1000
      discount.save(validate:false)
    when: "Se realiza la llamada al metodo buscardiscountsDeUnaInstitucion"
      def query = "esc"
      def descuentoInstitucion = service.searchDiscountsOfAnOrganization(institucion, query)
    then: "La cantidad de discounts debe ser igual a 1"
      assert descuentoInstitucion.size() == 1
      assert descuentoInstitucion.first().discountName == "pruebaDescuentote"
      assert descuentoInstitucion.first().amount == 1000
  }

}
