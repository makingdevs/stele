package com.stele

import static org.junit.Assert.*
import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(EsquemaDePagoService)
@Mock([Descuento,EsquemaDePago])
class EsquemaDePagoServiceSpec extends Specification {

  @Unroll("Dados las cantidades de descuento: #descuentos la cantidad aplicable de descuento es #descuentoCalculado")
	def "Dado un esquema de pago con descuentos en cantidades calcular la cantidad aplicable"() {
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
      8000           | [200,100,300] || 600                | 7400
	}

  @Unroll("Dados los porcentajes de descuento: #descuentos la cantidad aplicable de descuento es #descuentoCalculado")
  def "Dado un esquema de pago con descuentos en porcentajes calcular la cantidad aplicable"() {
    given:
      crearEsquemaDePagoConDescuentos(cantidadDePago, descuentos, true)
    when:
      def cantidadDeDescuentoAplicable = service.obtenerCantidadDeDescuentoAplicable(1L)
    then:
      cantidadDeDescuentoAplicable == descuentoCalculado
      cantidadDePago - descuentoCalculado == cantidadAPagar
    where:
      cantidadDePago | descuentos    || descuentoCalculado | cantidadAPagar
      1000           | [10]          || 100                | 900
      1000           | [10,15]       || 250                | 750
      8000           | [10,5,10]     || 2000               | 6000
  }

  private def crearEsquemaDePagoConDescuentos(cantidadDePago, descuentos, calcularConPorcentajes=false){
    EsquemaDePago esquemaDePago = new EsquemaDePago(cantidadDePago:cantidadDePago)
    descuentos.eachWithIndex { d, i ->
      Descuento descuento = new Descuento(
        nombreDeDescuento:"Descuento $i",
        fechaDeVencimiento:new Date(),
        diasPreviosParaCancelarDescuento:0).save(validate:false)
      if(calcularConPorcentajes){
        descuento.porcentaje=d
        descuento.cantidad=0
      }else{
        descuento.porcentaje=0
        descuento.cantidad=d 
      }
      
      esquemaDePago.addToDescuentos(descuento)
    }
    esquemaDePago.save(validate:false)
    esquemaDePago
  }
}
