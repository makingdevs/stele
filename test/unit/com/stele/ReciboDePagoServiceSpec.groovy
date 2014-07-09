package com.stele

import grails.text.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll
import com.payable.TipoDePago
import com.payable.Pago
import com.makingdevs.Perfil
import com.stele.seguridad.Usuario

@TestFor(ReciboDePagoService)
@Mock([Pago,Dependiente,Perfil,Usuario,HistorialAcademico,DistribucionInstitucional])
class ReciboDePagoServiceSpec extends Specification {
  
  def "Obtener datos del recibo de Pago"(){
    given:"Se tiene un pago conciliado de un dependiente"
      def fecha = new GregorianCalendar(2014, Calendar.MARCH, 11) 
      def pagoConciliado = new Pago(conceptoDePago:"Inscripcion",cantidadDePago:900,recargosAcumulados:400,
                                    fechaDePago:fecha.time,fechaDeVencimiento:fecha.time,
                                    tipoDePago:TipoDePago.TRANSFERENCIA_BANCARIA).save(validate:false);
      def perfilTutor = new Perfil(nombre:"Silvia",
                                   apellidoPaterno:"Garcia",
                                   apellidoMaterno:"Campos").save(validate:false)
      Usuario.metaClass.encodePassword() {}

      def usuario = new Usuario(username:"egjimenezg@gmail.com",perfil:perfilTutor).save(validate:false)
      def perfilAlumno = new Perfil(nombre:"Gamaliel",
                                    apellidoPaterno:"Jimenez",
                                    apellidoMaterno:"Garcia").save(validate:false)
      def dependiente = new Dependiente(perfil:perfilAlumno,pagos:[pagoConciliado],usuario:usuario).save(validate:false)
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
      datosReciboDePago.tipoPago == TipoDePago.TRANSFERENCIA_BANCARIA.toString()
  }
}
