package com.stele

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import com.stele.seguridad.Usuario
import grails.plugins.springsecurity.SpringSecurityService

@TestFor(GeneracionDePagoService)
@Mock([Pago, Dependiente, HistorialAcademico])
class GeneracionDePagoServiceSpec extends Specification {

  def "Generacion de pago para una camada"() {
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)

    and :
      CamadaPagoCommand cmd = new CamadaPagoCommand(camada:camada,
        conceptoDePago:concepto,
        cantidadDePago:monto,
        fechaDeVencimiento:fechaDeVencimiento)
    and :
        creoColaboradores()
    when :
      def pagos = service.paraCamadaPagoCommand(cmd)

    then :
      assert pagos.size() == 1
      assert pagos.first().id > 0
      assert pagos.first().conceptoDePago == concepto
      assert pagos.first().cantidadDePago == monto
      
    where :
      camada | concepto   | monto | fechaDeVencimiento
      "123"  | "concepto" | 1.00  | new Date() + 7
  }

  def "Guardar un concepto al generar el pago de una camada"(){
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)
    and :
      CamadaPagoCommand cmd = new CamadaPagoCommand(camada:camada,
        conceptoDePago:concepto,
        cantidadDePago:monto,
        fechaDeVencimiento:fechaDeVencimiento)
    and :
        def mocks = creoColaboradores()
    when:
      def pagos = service.paraCamadaPagoCommand(cmd)
      mocks*.verify()
    then:
      assert pagos.size() == 1
      assert pagos.first().id > 0
      assert pagos.first().conceptoDePago == concepto
      assert pagos.first().cantidadDePago == monto 
    where :
      camada | concepto   | monto | fechaDeVencimiento
      "123"  | "concepto" | 1.00  | new Date() + 7
  }

  def "No guardar un concepto existente al generar un pago de una camada"(){
    when:
      def s = 1
      // Tocar conceptoService.guardarConceptoDePagoGenerado
      // El metodo debe regresar null
    then:
      2 == s+1
  }

  def "Generar un pago con un descuento para una camada"(){
    when:
      def s = 1
      // Tocar descuentoService
      // Debera validar que se aplica el descuento
      // La cantidad del pago debe ser original y 
      // LA cantidad de descuentos sea 1 y que tenag un monto o porcentaje
    then:
      2 == s+1
  }

  private def creoColaboradores(){
    Usuario usuario = new Usuario()
    def springSecurityServiceMock = mockFor(SpringSecurityService)
    springSecurityServiceMock.demand.getCurrentUser(1..1){-> usuario }
    service.springSecurityService = springSecurityServiceMock.createMock()    
    def conceptoServiceMock = mockFor(ConceptoService)
    conceptoServiceMock.demand.guardarConceptoDePagoGenerado(1..1){Usuario u, String conc -> new Concepto()}
    service.conceptoService = conceptoServiceMock.createMock()
    
    [conceptoServiceMock,springSecurityServiceMock]
  }

}
