package com.stele

import static org.junit.Assert.*
import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import com.payable.GrupoPagoCommand

@TestFor(WrapperCommandService)
@Mock([CamadaPagoCommand, GrupoPagoCommand, Dependiente])
class WrapperCommandServiceSpec extends Specification {

  def "Generar parseo de camadaCommad a GrupoCommand directo"() {
    given:
      Dependiente dependiente1 = new Dependiente()
      dependiente1.matricula = "M224589"
      dependiente1.camada = "Making_Devs"
      dependiente1.save(validate:false)
    and:
      Dependiente dependiente2 = new Dependiente()
      dependiente2.matricula = "M221454"
      dependiente2.camada = "Making_Devs"
      dependiente2.save(validate:false)
    and:
      CamadaPagoCommand cpc = new CamadaPagoCommand()
      cpc.camada = "Making_Devs"
      cpc.conceptoDePago = "Inscripcion"
      cpc.cantidadDePago = 15000
      cpc.fechaDeVencimiento = new Date() + 30
      cpc.diasPreviosParaCancelarDescuento = 5
      cpc.meses = [2,4,6,8]  
      cpc.pagoDoble = [2,8]
      cpc.listaDependientes = 

  }

}