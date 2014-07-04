package com.stele

import grails.text.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll
import com.payable.Pago
import com.makingdevs.Perfil

@TestFor(ReciboDePagoService)
@Mock([Pago,Dependiente,Perfil])
class ReciboDePagoServiceSpec extends Specification {
  
  def "Obtener datos del recibo de Pago"(){
    given:"Se tiene un pago conciliado de un dependiente"
      def pagoConciliado = new Pago(conceptoDePago:"Inscripcion",cantidadDePago:900).save(validate:false);
      def perfilTutor = new Perfil(nombre:"Silvia",
                                   apellido_paterno:"García",
                                   apellido_materno:"Campos").save(validate:false)

      def perfilAlumno = new Perfil(nombre:"Gamaliel",
                                    apellido_paterno:"Jimenez",
                                    apellido_materno:"Garcia").save(validate:false)
      def dependiente = new Dependiente(perfil:perfilAlumno,pagos:[pagoConciliado]).save(validate:false)
      def dependienteList = [dependiente]
      Dependiente.metaClass.static.withCriteria = {  dependienteList }
    and: 
      def dependienteServiceMock = mockFor(DependienteService)
      dependienteServiceMock.demand.obtenerDependientesPorPagos{ listaPagos ->}
      service.dependienteService = dependienteServiceMock.createMock()
    when:
      ComprobantePagoCommand datosReciboDePago = service.obtenerDatosReciboDePago(pagoConciliado.id);
    then:
      datosReciboDePago != null      
      datosReciboDePago.nombreAlumno == "Gamaliel"
      //datosReciboDePago.apellidoPaternoAlumno == "Jimenez"
      //datosReciboDePago.apellidoMaternoAlumno == "Garcia"
      datosReciboDePago.cantidadPago == 900
      datosReciboDePago.conceptoPago == "Inscripcion"
  }
}
