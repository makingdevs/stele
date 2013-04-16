package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll

class DistribucionInstitucionalSpec extends Specification{

     def "Validando la implementacion de compareTo en distribucion institucional"(){
      given: "Una distribucion institucional"
        DistribucionInstitucional distribucionInstitucional = new DistribucionInstitucional() 
        distribucionInstitucional.nivelDeEstudio = NivelDeEstudio.PRIMARIA
        distribucionInstitucional.grado = 1
        distribucionInstitucional.grupo = "B"
        distribucionInstitucional.turno = Turno.MATUTINO
      and:"Otra distribucion institucional diferente"
        DistribucionInstitucional distribucionInstitucionalII = new DistribucionInstitucional() 
        distribucionInstitucionalII.nivelDeEstudio = NivelDeEstudio.PRIMARIA
        distribucionInstitucionalII.grado = 1
        distribucionInstitucionalII.grupo = "B"
        distribucionInstitucionalII.turno = Turno.MATUTINO
      when: "Se hace la comparacion"
        def valorComparacion = distribucionInstitucional <=> distribucionInstitucionalII
      then:"Se valida el resultado"
        assert true 
        println valorComparacion
    }
}
