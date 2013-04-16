package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll


class DistribucionInstitucionalSpec extends Specification{

      @Unroll("#datosDistribucionInstitucional vs #datosDistribucionInstitucionalII")
     def "Validando la implementacion de compareTo en distribucion institucional"(){
      given: "Una distribucion institucional"
        DistribucionInstitucional distribucionInstitucional = new DistribucionInstitucional(datosDistribucionInstitucional) 
      and:"Otra distribucion institucional diferente"
        DistribucionInstitucional distribucionInstitucionalII = new DistribucionInstitucional(datosDistribucionInstitucionalII) 
      when:"Se hace la comparacion"
        def valorComparacion = distribucionInstitucional <=> distribucionInstitucionalII
      then:"Se valida el resultado"
        assert valorComparacion == valorEsperado 
        println valorComparacion
       where:
        datosDistribucionInstitucional << [
          [nivelDeEstudio:NivelDeEstudio.PRIMARIA,grado:"2",grupo:"C",turno:Turno.MATUTINO],
          [nivelDeEstudio:NivelDeEstudio.SECUNDARIA,grado:"2",grupo:"C",turno:Turno.NOCTURNO],
          [nivelDeEstudio:NivelDeEstudio.BACHILLERATO,grado:"1",grupo:"C",turno:Turno.MATUTINO]
        ]
        datosDistribucionInstitucionalII << [
          [nivelDeEstudio:NivelDeEstudio.PRIMARIA,grado:"2",grupo:"C",turno:Turno.MATUTINO],
          [nivelDeEstudio:NivelDeEstudio.PRIMARIA,grado:"2",grupo:"C",turno:Turno.VESPERTINO],
          [nivelDeEstudio:NivelDeEstudio.EDUCACION_SUPERIOR,grado:"2",grupo:"B+",turno:Turno.NOCTURNO]
        ]
        valorEsperado << [
          0,
          1,
          -1
        ]
    }
}
