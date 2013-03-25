package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification


@TestFor(CicloEscolarService)
class CicloEscolarServiceSpec extends Specification{

  def "Obtener un ciclo escolar apartir de un command leeido desde un excel"(){

    given:
        def filaExcelCommand = new FilaExcelCommand(datosBasicos) 
      when:
        def cicloEscolar = service.obtenerCicloEscolarDesdeCommand(filaExcelCommand)
      then:
        assert cicloEscolar.clave == cicloEscolarEsperado
      where:
        datosBasicos << [
          [cicloEscolar:"12345"],
          [cicloEscolar:"ADD12345"]
        ]
        cicloEscolarEsperado << [
          "12345",
          "ADD12345"
        ]
  }

}
