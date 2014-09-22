package com.stele

import grails.text.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll
import com.payable.PaymentType
import com.payable.Payment
import com.payable.PaymentLink
import com.makingdevs.Perfil
import com.stele.seguridad.Usuario

@TestFor(ReciboDePagoService)
@Mock([Payment,PaymentLink,Dependiente,Perfil,Usuario,HistorialAcademico,DistribucionInstitucional])
class ReciboDePagoServiceSpec extends Specification {
  
  def "Obtener datos del recibo de Pago"(){
    given:"Se tiene un pago conciliado de un dependiente"
      def fecha = new GregorianCalendar(2014, Calendar.MARCH, 11) 
      def pagoConciliado = new Payment(paymentConcept:"Inscripcion",paymentAmount:900,accumulatedSurcharges:400,
                                    paymentDate:fecha.time,fechaDeVencimiento:fecha.time,
                                    paymentType:PaymentType.WIRE_TRANSFER,
                                    reference:"2000").save(validate:false);

      def perfilTutor = new Perfil(nombre:"Silvia",
                                   apellidoPaterno:"Garcia",
                                   apellidoMaterno:"Campos").save(validate:false)
      Usuario.metaClass.encodePassword() {}

      def usuario = new Usuario(username:"egjimenezg@gmail.com",perfil:perfilTutor).save(validate:false)
      def perfilAlumno = new Perfil(nombre:"Gamaliel",
                                    apellidoPaterno:"Jimenez",
                                    apellidoMaterno:"Garcia").save(validate:false)
      def dependiente = new Dependiente(perfil:perfilAlumno,usuario:usuario).save(validate:false)
      def paymentLink = new PaymentLink(paymentRef:dependiente.id,type:dependiente.class.simpleName,payments:[pagoConciliado]).save(validate:false)
      def distribucionInstitucional = new DistribucionInstitucional(nivelDeEstudio:NivelDeEstudio.PRIMARIA,grado:4,grupo:"A").save(validate:false)
      def historialAcademico = new HistorialAcademico(distribucionInstitucional:distribucionInstitucional,
                                                      dependiente:dependiente).save(validate:false)
      def dependienteList = [dependiente]
    and: 
      def dependienteServiceMock = mockFor(DependienteService)
      def historialAcademicoServiceMock = mockFor(HistorialAcademicoService)
      service.dependienteService = dependienteServiceMock.createMock()
      service.historialAcademicoService = historialAcademicoServiceMock.createMock()
      dependienteServiceMock.demand.obtenerDependientesPorPagos{ listaPagos -> dependienteList }
      historialAcademicoServiceMock.demand.obtenerhistorialAcademicoPorDependiente{id -> historialAcademico} 
    when:
      ComprobantePagoCommand datosReciboDePago = service.obtenerDatosReciboDePago(pagoConciliado.id);
      dependienteServiceMock.verify()
      historialAcademicoServiceMock.verify()
    then:
      datosReciboDePago.nombreAlumno == "Gamaliel Jimenez Garcia"
      datosReciboDePago.nombreTutor == "Silvia Garcia Campos";
      datosReciboDePago.nivelEstudio == NivelDeEstudio.PRIMARIA.toString()
      datosReciboDePago.grado == 4 
      datosReciboDePago.grupo == "A"
      datosReciboDePago.conceptoPago == "Inscripcion"
      datosReciboDePago.cantidadPago == 900
      datosReciboDePago.recargosAcumulados == 400
      datosReciboDePago.total == 500
      datosReciboDePago.fechaPago == fecha.time
      datosReciboDePago.tipoPago == PaymentType.WIRE_TRANSFER.toString()
      datosReciboDePago.referencia == "2000"
  }
}
