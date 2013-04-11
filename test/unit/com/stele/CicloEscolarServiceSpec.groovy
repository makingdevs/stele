package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification


@TestFor(CicloEscolarService)
@Mock(CicloEscolar)
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

  def "Registro de un ciclo escolar verificando que no exista"(){
    given: "Un ciclo escolar con datos"
      def cicloEscolar = new CicloEscolar()
      cicloEscolar.clave = "1234567"
      cicloEscolar.descripcion = "Prueba ciclo escolar"
      cicloEscolar.fechaInicio = new Date()
      cicloEscolar.fechaFin = new Date()
    when: "Guardamos el ciclo escolar con el servicio"
      cicloEscolar = service.registrar(cicloEscolar)
    then: "El id debe ser mayor que 0"
      assert cicloEscolar.id > 0
  }

  def "No agregar un ciclo escolar ya existente"(){
    given: "Un ciclo escolar con datos"
    when: "Intentamos guardar ciclo escolar"
    then: "El id debe ser 1"
  }

}
