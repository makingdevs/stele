package com.stele

import grails.test.mixin.*
import spock.lang.Specification
import com.makingdevs.*
import com.payable.*

@TestFor(DescuentoService)
@Mock([Institucion, Descuento])
class DescuentoServiceSpec extends Specification {

  def "Obtener todos los descuentos ligados a una Institucion"() {
    given: 
      Institucion institucion = new Institucion()
      institucion.nombre = "la chafita"
      institucion.save(validate:false)
    and:
      Descuento descuento = new Descuento()
      descuento.nombreDeDescuento = "pruebaDescuentote"
      descuento.organizacion = institucion
      descuento.cantidad = 1000
      descuento.save(validate:false)
    when: "Se realiza la llamada al metodo buscarDescuentosDeUnaInstitucion"
      def query = "esc"
      def descuentoInstitucion = service.buscarDescuentosDeUnaOrganizacion(institucion, query)
    then: "La cantidad de descuentos debe ser igual a 1"
      assert descuentoInstitucion.size() == 1
      assert descuentoInstitucion.first().nombreDeDescuento == "pruebaDescuentote"
      assert descuentoInstitucion.first().cantidad == 1000
  }

}