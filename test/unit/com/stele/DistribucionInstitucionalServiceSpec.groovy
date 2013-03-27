package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(DistribucionInstitucionalService)
class DistribucionInstitucionalServiceSpec extends Specification{

    @Unroll("#datosBasicos")
    def "Obtener una distribucion organizacional apartir de un command leeido desde un excel"(){

      given:
        def filaExcelCommand = new FilaExcelCommand(datosBasicos) 
      when:
        def distribucionInstitucional = service.obtenerDistribucionInstitucionalDesdeCommand(filaExcelCommand)
      then:
        assert distribucionInstitucional.grado == gradoEsperado
        assert distribucionInstitucional.grupo == grupoEsperado 
        assert distribucionInstitucional.nivelDeEstudio == nivelDeEstudioEsperado
        assert distribucionInstitucional.turno == turnoEsperado     
      where:
        datosBasicos << [
          [grado:"2",grupo:"C",nivel:"Primaria",turno:"Matutino"],
          [grado:"2",grupo:"C",nivel:"PRI",turno:"Noche"],
          [grado:"2",grupo:"C",nivel:"PRIMARIA",turno:"Mat"],
          [grado:"2",grupo:"C",nivel:"priMaria",turno:"Mañ."],
          [grado:"2",grupo:"C",nivel:"PRImaria",turno:"Vesp"],
          [grado:"2",grupo:"C",nivel:"PrImArIa",turno:"vespertino"],
          [grado:"2",grupo:"C",nivel:"PrI.",turno:"tarde"],
          [grado:"3",grupo:"a",nivel:"Secundaria",turno:"Tard."],
          [grado:"3",grupo:"a",nivel:"Secu",turno:"noc."],
          [grado:"3",grupo:"a",nivel:"SECUNDARIA",turno:"nocturno"],
          [grado:"3",grupo:"a",nivel:"seCU",turno:"v"]
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
        nivelDeEstudioEsperado  << [
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
        turnoEsperado << [
          Turno.MATUTINO,
          Turno.NOCTURNO,
          Turno.MATUTINO,
          Turno.MATUTINO,
          Turno.VESPERTINO,
          Turno.VESPERTINO,
          Turno.VESPERTINO,
          Turno.VESPERTINO,
          Turno.NOCTURNO,
          Turno.NOCTURNO,
          Turno.VESPERTINO
        ]
    }
}
