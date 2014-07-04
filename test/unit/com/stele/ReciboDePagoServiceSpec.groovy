package com.stele

import grails.text.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll
import com.payable.Pago
import com.

@TestFor(ReciboDePagoService)
@Mock([Pago,Dependiente,Perfil])
class ReciboDePagoServiceSpec extends Specification {
  
  def "Obtener datos del recibo de Pago"(){
    given:"Se tiene un pago conciliado de un dependiente"
      def perfilTutor = new Perfil(nombre:"Silvia",
                                   apellido_paterno:"García",
                                   apellido_materno:"Campos").save(validate:false)

      def perfilAlumno = new Perfil(nombre:"Gamaliel",
                                    apellido_paterno:"Jimenez",
                                    apellido_materno:"Garcia").save(validate:false)
      def dependiente = new Dependiente()
      def pagoConciliado = new Pago(conceptoDePago:"Inscripcion",cantidadDePago:900);
      pagoConciliado.save(validate:false)
    when:
      ComprobantePagoCommand datosReciboDePago = service.obtenerDatosReciboDePago(pagoConciliado.id);
    then:
      datosReciboDePago != null      
      datosReciboDePago.cantidadPago = 900
      datosReciboDePago.conceptoPago == "Inscripcion"
  }
}
