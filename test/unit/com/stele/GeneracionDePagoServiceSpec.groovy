package com.stele

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import com.stele.seguridad.Usuario
import com.payable.*

@TestFor(GeneracionDePagoService)
@Mock([Pago, Dependiente, HistorialAcademico, Descuento, Concepto, Recargo, Institucion])
class GeneracionDePagoServiceSpec extends Specification {

  def "Generacion de pago para una camada"() {
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)
    and :
      Institucion organizacion = new Institucion()
      organizacion.nombre = "making_devs"
      organizacion.save(validate:false)
    and :
      GrupoPagoCommand gpc = new GrupoPagoCommand(cantidadDePago:monto, 
        conceptoDePago:concepto,
        fechaDeVencimiento:fechaDeVencimiento,
        organizacion:organizacion,
        payables:[dependiente])
    and :
        creoColaboradores()
    when :
      def pagos = service.generaPagoParaGrupo(gpc)

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
      Institucion organizacion = new Institucion()
      organizacion.nombre = "making_devs"
      organizacion.save(validate:false)
    and :
      GrupoPagoCommand gpc = new GrupoPagoCommand(cantidadDePago:monto, 
        conceptoDePago:concepto,
        fechaDeVencimiento:fechaDeVencimiento,
        organizacion:organizacion,
        payables:[dependiente])
    and :
      def mocks = creoColaboradores()
    when:
      def pagos = service.generaPagoParaGrupo(gpc)
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
      Institucion organizacion = new Institucion()
      organizacion.nombre = "making_devs"
      organizacion.save(validate:false)
    and :
      GrupoPagoCommand gpc = new GrupoPagoCommand(cantidadDePago:monto, 
        conceptoDePago:concepto,
        fechaDeVencimiento:fechaDeVencimiento,
        organizacion:organizacion,
        payables:[dependiente])
    and :
        def mocks = creoColaboradores()   
    when:
      // Tocar conceptoService.guardarConceptoDePagoGenerado
      // El metodo debe regresar null
      def pagos = service.generaPagoParaGrupo(gpc)
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

  /*def "Generar un pago con un descuento para una camada"(){
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)
    and :
      Institucion organizacion = new Institucion()
      organizacion.nombre = "making_devs"
      organizacion.save(validate:false)
    and :
      Descuento descuento = new Descuento()
      descuento.nombreDeDescuento = "descuento"
      descuento.cantidad = 100
      descuento.organizacion = organizacion
      descuento.diasPreviosParaCancelarDescuento = 3
      descuento.save(validate:false)
    and :
      GrupoPagoCommand gpc = new GrupoPagoCommand(cantidadDePago:monto, 
        conceptoDePago:concepto,
        fechaDeVencimiento:fechaDeVencimiento,
        organizacion:organizacion,
        payables:[dependiente],
        descuentoIds:[descuento.id])
    and :
      def mocks = creoColaboradores()
    when:
      def pagos = service.generaPagoParaGrupo(gpc)
      mocks*.verify()
    then:
      assert pagos.size() == 1
      assert pagos.first().id > 0
      assert pagos.first().conceptoDePago == concepto
      assert pagos.first().cantidadDePago == monto 

    where :
      camada | concepto   | monto | fechaDeVencimiento | descuentos
      "123"  | "concepto" | 1.00  | new Date() + 7     | [1]
  }*/

  def "Generar un pago con un recargo para una camada"() {
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)
    and :
      Institucion organizacion = new Institucion()
      organizacion.nombre = "making_devs"
      organizacion.save(validate:false)
    and :
      Recargo recargo = new Recargo()
      recargo.organizacion = organizacion
      recargo.cantidad = 30
      recargo.save(validate:false)
    and :
      GrupoPagoCommand gpc = new GrupoPagoCommand(cantidadDePago:monto, 
        conceptoDePago:concepto,
        fechaDeVencimiento:fechaDeVencimiento,
        organizacion:organizacion,
        payables:[dependiente],
        recargoId: recargo.id)
      and :
        def mocks = creoColaboradores()
      when : 
        def pagos = service.generaPagoParaGrupo(gpc)
        mocks*.verify()
      then :
        assert pagos.size() == 1
        assert pagos.first().id > 0
        assert pagos.first().recargo.id > 0 
        assert pagos.first().conceptoDePago == concepto
        assert pagos.first().cantidadDePago == monto 
      where : 
        camada | concepto   | monto | fechaDeVencimiento | recargoId
        "123"  | "concepto" | 10000.00  | new Date() + 7     |  1

  }


  def "Generar un talonario de pagos para una camada"() {
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)
    and :
      Institucion organizacion = new Institucion()
      organizacion.nombre = "making_devs"
      organizacion.save(validate:false)
    and :
      GrupoPagoCommand gpc = new GrupoPagoCommand(cantidadDePago:monto, 
        conceptoDePago:concepto,
        fechaDeVencimiento:fechaDeVencimiento,
        organizacion:organizacion,
        payables:[dependiente],
        meses:meses)
      and :
        def mocks = creoColaboradores()
      when : 
        def pagos = service.generaPagoParaGrupo(gpc)
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

  def "Generar un talonario de pagos con pagos doble para una camada"() {
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)
    and :
      Institucion organizacion = new Institucion()
      organizacion.nombre = "making_devs"
      organizacion.save(validate:false)
    and :
      GrupoPagoCommand gpc = new GrupoPagoCommand(cantidadDePago:monto, 
        conceptoDePago:concepto,
        fechaDeVencimiento:fechaDeVencimiento,
        organizacion:organizacion,
        payables:[dependiente],
        meses:meses,
        pagoDoble:pagoDoble)
    and :
      def mocks = creoColaboradores()
    when : 
      def pagos = service.generaPagoParaGrupo(gpc)
      mocks*.verify()
    then :
      assert pagos.size() == 5
      assert pagos.first().id == 1
      assert pagos.first().conceptoDePago == concepto
      pagos.each { pago ->
        if( pagoDoble.contains( pago.fechaDeVencimiento.getMonth() ) )
          assert pago.cantidadDePago == 2.00
        else
          assert pago.cantidadDePago == 1.00
      }
    where : 
      camada | concepto   | monto | fechaDeVencimiento | meses       | pagoDoble
      "123"  | "concepto" | 1.00  | new Date() + 7     | [1,3,5,7,9] | [1,5,9]
  }


  private def creoColaboradores(){
    Usuario usuario = new Usuario()

    def conceptoServiceMock = mockFor(ConceptoService)
    conceptoServiceMock.demand.buscarOSalvarConceptoDePago(1..1){String conc = "concepto" -> return new Concepto()}
    service.conceptoService = conceptoServiceMock.createMock()   

    [conceptoServiceMock]
  }

}
