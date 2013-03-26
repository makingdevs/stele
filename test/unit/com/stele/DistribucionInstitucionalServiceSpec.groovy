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
        assert distribucionInstitucional.nivelDeEstudio == nivelDeEstudioEsperado     
      where:
        datosBasicos << [
          [grado:"2",grupo:"C",nivel:"Primaria"],
          [grado:"2",grupo:"C",nivel:"PRI"],
          [grado:"2",grupo:"C",nivel:"PRIMARIA"],
          [grado:"2",grupo:"C",nivel:"BASICA"],
          [grado:"2",grupo:"C",nivel:"ELEMENTAL"],
          [grado:"2",grupo:"C",nivel:"PrImArIa"],
          [grado:"2",grupo:"C",nivel:"PrI."],
          [grado:"3",grupo:"a",nivel:"Secundaria"],
          [grado:"3",grupo:"a",nivel:"Secu"],
          [grado:"3",grupo:"a",nivel:"SECUNDARIA"],
          [grado:"3",grupo:"a",nivel:"Sec."]
        ]
        gradoEsperado << [
          "2",
          "2",
          "2",
          "2",
          "2",
          "2",
          "2",
          "3",
          "3",
          "3",
          "3"
        ]
        grupoEsperado << [
          "C",
          "C",
          "C",
          "C",
          "C",
          "C",
          "C",
          "a",
          "a",
          "a",
          "a"
        ]
        nivelEsperado  << [
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.SECUNDARIA,
          NivelDeEstudio.SECUNDARIA,
          NivelDeEstudio.SECUNDARIA,
          NivelDeEstudio.SECUNDARIA
        ]
    }
}
