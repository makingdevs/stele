package com.stele

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification

@TestFor(FilaExcelCommandService)
class FilaExcelCommandServiceSpec extends Specification {

  def "Deberia convertir una fila de datos obtenidos en excel a objetos command"() {
    when : "Llamamos al servicio de procesamiento"
      FilaExcelCommand command = service.convertirACommand(filaDeExcel)
    then : "Los resultados deben ser"
      assert command
    where :
      filaDeExcel << [
        [""] * 13
      ]
  }

}
