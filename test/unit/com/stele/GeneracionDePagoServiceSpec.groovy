package com.stele

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

@TestFor(GeneracionDePagoService)
@Mock([Pago, Dependiente, HistorialAcademico])
class GeneracionDePagoServiceSpec extends Specification {

  void "Generacion de pago para una camada"() {
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)

    and :
      CamadaPagoCommand cmd = new CamadaPagoCommand(camada:camada,
        conceptoDePago:concepto,
        cantidadDePago:monto,
        fechaDeVencimiento:fechaDeVencimiento)

    when :
      def pagos = service.paraCamadaPagoCommand(cmd)

    then :
      assert pagos.size() == 1
      assert pagos.first().id > 0
      assert pagos.first().conceptoDePago == concepto
      
    where :
      camada | concepto   | monto | fechaDeVencimiento
      "123"  | "concepto" | 1.00  | new Date() + 7
  }

}
