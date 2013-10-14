package com.stele

import static org.junit.Assert.*
import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import com.payable.GrupoPagoCommand

@TestFor(WrapperCommandService)
@Mock([Dependiente, Institucion])
class WrapperCommandServiceSpec extends Specification {

  def "Generar parseo de camadaCommad a GrupoCommand directo"() {
    given:
      Institucion institucion = new Institucion()
      institucion.nombre = "la del moño colorado"
      institucion.save(validate:false)
    and:
      Dependiente dependiente1 = new Dependiente()
      dependiente1.matricula = "M224589"
      dependiente1.camada = camada
      dependiente1.save(validate:false)
    and:
      Dependiente dependiente2 = new Dependiente()
      dependiente2.matricula = "M221454"
      dependiente2.camada = camada
      dependiente2.save(validate:false)
    and:
      CamadaPagoCommand cpc = new CamadaPagoCommand()
      cpc.camada = camada
      cpc.conceptoDePago = conceptoDePago
      cpc.cantidadDePago = cantidadDePago
      cpc.fechaDeVencimiento = fechaDeVencimiento
      cpc.diasPreviosParaCancelarDescuento = diasPrevios
      cpc.meses = meses
      cpc.pagoDoble = pagoDoble
      cpc.listaDependientes = "[${dependiente1.id}, ${dependiente2.id}]"
    when: "verificar que el parseo de los command es satisfactorio"
      def grupoCommand = service.generarParseoDeCamadaPagoCommandAGrupoPagoCommand(cpc, institucion)
    then:
      assert grupoCommand instanceof GrupoPagoCommand  
      assert grupoCommand.cantidadDePago == cantidadDePago
      assert grupoCommand.organizacion.id  == institucion.id
    where:
     camada        |cantidadDePago | conceptoDePago | fechaDeVencimiento | diasPrevios | meses      | pagoDoble 
     "Making_Devs" | 15000         | "Inscripcion"  | new Date() + 30    |  6          | [2,4,6,8]  | [2,8]
  }

}