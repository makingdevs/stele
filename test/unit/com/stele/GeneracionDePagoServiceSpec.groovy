package com.stele

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import com.stele.seguridad.Usuario
import grails.plugins.springsecurity.SpringSecurityService

@TestFor(GeneracionDePagoService)
@Mock([Pago, Dependiente, HistorialAcademico, Descuento, Concepto, Recargo])
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
        def mocks = creoColaboradoresEstatusDos()   
    when:
      // Tocar conceptoService.guardarConceptoDePagoGenerado
      // El metodo debe regresar null
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

  def "Generar un pago con un descuento para una camada"(){
     setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)

    and :
      CamadaPagoCommand cmd = new CamadaPagoCommand(camada:camada,
        conceptoDePago:concepto,
        cantidadDePago:monto,
        descuentos:descuentos,
        fechaDeVencimiento:fechaDeVencimiento)
    and :
      Descuento descuento = new Descuento()
      descuento.nombreDeDescuento = "descuento 1"
      descuento.cantidad = 100
      descuento.fechaDeVencimiento = new Date() + 3
      descuento.id = 1
      descuento.save(flush:true)
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
      camada | concepto   | monto | fechaDeVencimiento | descuentos
      "123"  | "concepto" | 1.00  | new Date() + 7     | [1]
  }

  def "Generar un pago con un recargo para una camada"() {
      setup:
        Dependiente dependiente = new Dependiente(camada:camada)
        dependiente.addToHistorialAcademico(new HistorialAcademico())
        dependiente.save(validate:false)
      and :
        CamadaPagoCommand cmd = new CamadaPagoCommand(camada:camada,
          conceptoDePago:concepto,
          cantidadDePago:monto,
          fechaDeVencimiento:fechaDeVencimiento,
          recargoid:recargoId)

      and :
        Recargo recargos = new Recargo()
        recargos.save() 
      and :
        def mocks = creoColaboradores()
      when : 
        def pagos = service.paraCamadaPagoCommand(cmd)
        mocks*.verify()
      then :
        assert pagos.size() == 1
        assert pagos.first().id > 0
        assert pagos.first().conceptoDePago == concepto
        assert pagos.first().cantidadDePago == monto 
      where : 
        camada | concepto   | monto | fechaDeVencimiento | recargoId
        "123"  | "concepto" | 1.00  | new Date() + 7     |  1

  }


  def "Generar un talonario de pagos para una camada"() {
      setup:
        Dependiente dependiente = new Dependiente(camada:camada)
        dependiente.addToHistorialAcademico(new HistorialAcademico())
        dependiente.save(validate:false)
      and :
        CamadaPagoCommand cmd = new CamadaPagoCommand(camada:camada,
          conceptoDePago:concepto,
          cantidadDePago:monto,
          fechaDeVencimiento:fechaDeVencimiento,
          meses: meses
          )
      and :
        def mocks = creoColaboradores()
      when : 
        def pagos = service.paraCamadaPagoCommand(cmd)
        mocks*.verify()
      then :
        assert pagos.size() == 5
        assert pagos.first().id > 0
        assert pagos.first().conceptoDePago == concepto
        assert pagos.first().cantidadDePago == monto 

      where : 
        camada | concepto   | monto | fechaDeVencimiento | meses
        "123"  | "concepto" | 1.00  | new Date() + 7     | [1,3,5,10]
  }

  private def creoColaboradores(){
    Usuario usuario = new Usuario()

    def conceptoServiceMock = mockFor(ConceptoService)
    conceptoServiceMock.demand.verificarConceptoPagoExistente(1..1){String conc = "concepto" -> return false}
    conceptoServiceMock.demand.guardarConceptoDePagoGenerado(1..1){Usuario u, String conc = "concepto" -> return true}
    service.conceptoService = conceptoServiceMock.createMock()
    def springSecurityServiceMock = mockFor(SpringSecurityService)
    springSecurityServiceMock.demand.getCurrentUser(1..1){-> usuario }
    service.springSecurityService = springSecurityServiceMock.createMock()    

    [conceptoServiceMock,springSecurityServiceMock]
  }

  private def creoColaboradoresEstatusDos(){
    Usuario usuario = new Usuario()
    def springSecurityServiceMock = mockFor(SpringSecurityService)
    springSecurityServiceMock.demand.getCurrentUser(0..0){-> usuario }
    service.springSecurityService = springSecurityServiceMock.createMock()    
    def conceptoServiceMock = mockFor(ConceptoService)
    conceptoServiceMock.demand.verificarConceptoPagoExistente(1..1){String conc -> return true}
    conceptoServiceMock.demand.guardarConceptoDePagoGenerado(0..0){}
    service.conceptoService = conceptoServiceMock.createMock()
    
    [conceptoServiceMock,springSecurityServiceMock]
  }

}
