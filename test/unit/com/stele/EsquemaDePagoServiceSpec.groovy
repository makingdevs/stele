package com.stele

import static org.junit.Assert.*
import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(EsquemaDePagoService)
@Mock([Descuento,EsquemaDePago])
class EsquemaDePagoServiceSpec extends Specification {

  @Unroll("Dados los descuentos #descuentos la cantidad aplicable de descuento es #descuentoCalculado")
	def "Dado un esquema de pago calcular la cantidad de descuento aplicable"() {
    given:
      crearEsquemaDePagoConDescuentos(cantidadDePago, descuentos)
    when:
      def cantidadDeDescuentoAplicable = service.obtenerCantidadDeDescuentoAplicable(1L)
    then:
      cantidadDeDescuentoAplicable == descuentoCalculado
      cantidadDePago - descuentoCalculado == cantidadAPagar
    where:
      cantidadDePago | descuentos    || descuentoCalculado | cantidadAPagar
      1000           | [200]         || 200                | 800
      1000           | [200,300]     || 500                | 500
      8000           | [200,100,300] || 600                | 7500
	}

  private def crearEsquemaDePagoConDescuentos(cantidadDePago, descuentos){
    EsquemaDePago esquemaDePago = new EsquemaDePago(cantidadDePago:cantidadDePago)
    descuentos.eachWithIndex { d, i ->
      Descuento descuento = new Descuento(
        nombreDeDescuento:"Descuento $i",
        porcentaje:0,
        cantidad:d,
        fechaDeVencimiento:new Date(),
        diasPreviosParaCancelarDescuento:0).save(validate:false)
      esquemaDePago.addToDescuentos(descuento)
    }
    esquemaDePago.save(validate:false)
    esquemaDePago
  }
}
