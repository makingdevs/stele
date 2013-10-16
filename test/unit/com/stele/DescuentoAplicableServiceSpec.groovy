package stele

import grails.test.mixin.*
import spock.lang.Specification
import spock.lang.Unroll
import com.stele.seguridad.Usuario
import com.payable.*

@TestFor(DescuentoAplicableService)
@Maock([Pago,Descuento, DescuentoAplicable])
class DescuentoAplicableServiceSpec extends Specification {

  def "generar un DescuentoAplicable con fecha vencimiento"() {
    setup:
      Descuento descuento = new Descuento()
      descuento.cantidad = 100
      descuento.save(validate:false)
  }

}