package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification

@TestFor(DistribucionInstitucionalService)
class DistribucionInstitucionalServiceSpec extends Specification{

    def "Obtener una distribucion organizacional apartir de un command leeido desde un excel"(){

      given:
        def filaExcelCommand = new FilaExcelCommand(datosBasicos) 
      when:
        def distribucionInstitucional = service.obtenerDistribucionInstitucionalDesdeCommand(filaExcelCommand)
      then:
        assert distribucionInstitucional.grado == gradoEsperado
        assert distribucionInstitucional.grupo == grupoEsperado 
        assert distribucionInstitucional.nivelDeEstudio.value == nivelDeEstudioEsperado     
      where:
        datosBasicos << [
          [grado:"2",grupo:"C",nivel:"Primaria"],
          [grado:"3",grupo:"a",nivel:"Secunadaria"]
        ]
        gradoEsperado << [
          "2",
          "3",
          "Secunadaria"
        ]
        grupoEsperado << [
          "C",
          "a",
          "Secunadaria"
        ]
    }
}
