package com.stele

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(EsquemaDePagoService)
class EsquemaDePagoServiceSpec extends Specification {

	def "Dado un esquema de pago calcular la cantidad de descuento aplicable"() {
    when:
      def cantidadDeDescuentoAplicable = service.obtenerCantidadDeDescuentoAplicable(esquemaDePagoId)
    then:
      cantidadDeDescuentoAplicable == descuentoAplicableCalculado
    where:
      esquemaDePagoId || descuentoAplicableCalculado
      1L              || 300
	}
}
