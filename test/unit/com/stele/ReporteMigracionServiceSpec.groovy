package com.stele

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification

@TestFor(ReporteMigracionService)
class ReporteMigracionServiceSpec extends Specification {

  def "Obtener conteo de dependientes" () {

    when : "Llamamos al contador de datos"
      def totalDependientes = service.conteoDeDatosPorDependientes(estructuraInstitucional)

    then : "Los resultados son"
      assert totalDependientes == totalDependientesEsperados

    where :
      estructuraInstitucional                                       || totalDependientesEsperados
      ['20':['NIVEL':['1':['TURNO':['A' : [1,2,3,4,5,6,10]]]]]]     || 7
      ['21':['NIVEL':['1':['TURNO':['A' : [1,2,3,4,5,6,10,11]]]]]]  || 8
      ['22':['NIVEL':['1':['TURNO':['A' : [1,2,3], 'B' :[1,2]]]]]]  || 5
      ['22':['NIVEL':['1':['TURNO1':['A' : [1,2,3], 'B' :[1,2]],
                           'TURNO2':['A' : [1,2,3], 'B' :[1,2]]]]]] || 10
      

  }

}
