package com.stele

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import com.stele.seguridad.Usuario
import com.payable.*

@TestFor(GenerationOfPaymentService)
@Mock([Payment, Dependiente, HistorialAcademico, Discount, Concept, Surcharge, Institucion,PaymentLink])
class GeneracionDePagoServiceSpec extends Specification {

  def "Generacion de pago para una camada"() {
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)
    and :
      Institucion organizacion = new Institucion()
      organizacion.name = "making_devs"
      organizacion.save(validate:false)
    and :
      PaymentGroupCommand pgc = new PaymentGroupCommand(paymentAmount:monto, 
        paymentConcept:concepto,
        dueDate:fechaDeVencimiento,
        organization:organizacion,
        instances:[dependiente])
    and :
        crearColaboradores()
    when :
      def pagos = service.generatePaymentsForGroup(pgc)

    then :
      assert pagos.size() == 1
      assert pagos.first().id > 0
      assert pagos.first().paymentConcept == concepto
      assert pagos.first().paymentAmount == monto
      
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
      organizacion.name = "making_devs"
      organizacion.save(validate:false)
    and :
      PaymentGroupCommand pgc = new PaymentGroupCommand(paymentAmount:monto, 
        paymentConcept:concepto,
        dueDate:fechaDeVencimiento,
        organization:organizacion,
        instances:[dependiente])
    and :
      def mocks = crearColaboradores()
    when:
      def pagos = service.generatePaymentsForGroup(pgc)
      mocks*.verify()
    then:
      assert pagos.size() == 1
      assert pagos.first().id > 0
      assert pagos.first().paymentConcept == concepto
      assert pagos.first().paymentAmount == monto 
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
      organizacion.name = "making_devs"
      organizacion.save(validate:false)
    and :
      PaymentGroupCommand gpc = new PaymentGroupCommand(paymentAmount:monto, 
        paymentConcept:concepto,
        dueDate:fechaDeVencimiento,
        organization:organizacion,
        instances:[dependiente])
    and :
        def mocks = crearColaboradores()   
    when:
      // Tocar conceptoService.guardarConceptoDePagoGenerado
      // El metodo debe regresar null
      def pagos = service.generatePaymentsForGroup(gpc)
      mocks*.verify()
    then:
      assert pagos.size() == 1
      assert pagos.first().id > 0
      assert pagos.first().paymentConcept == concepto
      assert pagos.first().paymentAmount == monto 
    where :
      camada | concepto   | monto | fechaDeVencimiento
      "123"  | "concepto" | 1.00  | new Date() + 7
  }

  def "Generar un pago con un recargo para una camada"() {
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)
    and :
      Institucion organizacion = new Institucion()
      organizacion.name = "making_devs"
      organizacion.save(validate:false)
    and :
      Surcharge surcharge = new Surcharge()
      surcharge.organization = organizacion
      surcharge.amount = 30
      surcharge.save(validate:false)
    and :
      PaymentGroupCommand pgc = new PaymentGroupCommand(paymentAmount:monto, 
        paymentConcept:concepto,
        dueDate:fechaDeVencimiento,
        organization:organizacion,
        instances:[dependiente],
        surchargeId: surcharge.id)
      and :
        def mocks = crearColaboradores()
      when : 
        def pagos = service.generatePaymentsForGroup(pgc)
        mocks*.verify()
      then :
        assert pagos.size() == 1
        assert pagos.first().id > 0
        assert pagos.first().surcharge.id > 0 
        assert pagos.first().paymentConcept == concepto
        assert pagos.first().paymentAmount == monto 
      where : 
        camada | concepto   | monto     | fechaDeVencimiento | recargoId
        "123"  | "concepto" | 10000.00  | new Date() + 7     |  1
  }

  def "Generar un talonario de pagos para una camada"() {
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)
    and :
      Institucion organizacion = new Institucion()
      organizacion.name = "making_devs"
      organizacion.save(validate:false)
    and :
      PaymentGroupCommand pgc = new PaymentGroupCommand(paymentAmount:monto, 
        paymentConcept:concepto,
        dueDate:fechaDeVencimiento,
        organization:organizacion,
        instances:[dependiente],
        months:meses)
      and :
        def mocks = crearColaboradores()
      when : 
        def pagos = service.generatePaymentsForGroup(pgc)
        mocks*.verify()
      then :
        assert pagos.size() == 4
        assert pagos.first().id > 0
        assert pagos.first().paymentConcept == concepto
        assert pagos.first().paymentAmount == monto 

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
      organizacion.name = "making_devs"
      organizacion.save(validate:false)
    and :
      PaymentGroupCommand pgc = new PaymentGroupCommand(paymentAmount:monto, 
        paymentConcept:concepto,
        dueDate:fechaDeVencimiento,
        organization:organizacion,
        instances:[dependiente],
        months:meses,
        doublePayment:pagoDoble)
    and :
      def mocks = crearColaboradores()
    when : 
      def pagos = service.generatePaymentsForGroup(pgc)
      mocks*.verify()
    then :
      assert pagos.size() == meses.size()
      assert pagos.first().id == 1
      assert pagos.first().paymentConcept == concepto
      pagos.each { pago ->
        if( pagoDoble.contains( pago.dueDate.getMonth().toString() ) )
          assert pago.paymentAmount == 2.00
        else
          assert pago.paymentAmount == 1.00
      }
    where : 
      camada | concepto   | monto | fechaDeVencimiento | meses       | pagoDoble
      "123"  | "concepto" | 1.00  | new Date() + 7     | [1,3,5,7,9] | [1,5,9]
  }


  private def crearColaboradores(){
    Usuario usuario = new Usuario()

    def conceptoServiceMock = mockFor(ConceptService)
    conceptoServiceMock.demand.savePaymentConcept(1..1){String conc = "concepto" -> return new Concepto()}
    service.conceptService = conceptoServiceMock.createMock()   

    [conceptoServiceMock]
  }

}
