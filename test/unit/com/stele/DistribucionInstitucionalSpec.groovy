package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class DistribucionInstitucionalSpec extends Specification{

     def "Validando la implementacion de compareTo en distribucion institucional"(){
      given: "Una distribucion institucional"
        DistribucionInstitucional distribucionInstitucional = new DistribucionInstitucional() 
        NivelDeEstudio nivelDeEstudio = NivelDeEstudio.PRIMARIA
        Integer grado
        String grupo
        Turno turno = Turno.MATUTINO
      and:"Otra distribucion institucional diferente"
      when: "Se hace la comparacion"
      then: "Se valida el resultado"
    }
}
