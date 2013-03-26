package com.stele

import grails.plugin.spock.IntegrationSpec

class ExcelServiceIntegrationSpec extends IntegrationSpec {

  def excelService

  def "De acuerdo a una ruta de archivo debe regresar una lista de filas"() {
    when : "Invocamos al método de lectura"
      def resultado = excelService.leerArchivoDesdeLaRuta(ruta)

    then : "Obtenemos los siguientes resultados : "
      assert filasDeArchivo.size() == resultado.size()
      assert filasDeArchivo == resultado
      assert filasDeArchivo[0] == resultado[0]

    where :
      ruta                                    || filasDeArchivo
      "test/integration/com/stele/layout.xls" || [["Ciclo escolar","Nombre","Apellido paterno","Apellido materno","Correo electrónico","Telefono","Matrícula","Apellido paterno","Apellido materno","Nombre(s)","Nivel","Grado","Grupo","Turno"]]
  }


}
