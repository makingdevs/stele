package com.stele

import grails.plugin.spock.IntegrationSpec

class ExcelServiceIntegrationSpec extends IntegrationSpec {

  def excelService

  def "De acuerdo a una ruta de archivo debe regresar una lista de filas"() {
    when : "Invocamos al método de lectura"
      def resultado = excelService.leerArchivoDesdeLaRuta("test/integration/com/stele/layout.xls")

    then : "Obtenemos los siguientes resultados : "
      println resultado.size()
      assert filasDeArchivo.size() == resultado.size()
      assert filasDeArchivo == resultado
      assert filasDeArchivo[0] == resultado[0]

    where :
      filasDeArchivo << [
        [
          ["2012/2013","Felipe","Juárez","Murillo","fjuarez@gmail.com","1234567890","M123456","Juárez","Murrieta","Felipe Jr.","Primaria","4","A","Matutino"],
          ["2012/2013","José Juan","Reyes","Zuñiga","neodevelop@gmail.com","3456789012","M002344","Reyes","Bernal","María Fernanda","Secundaria","3","C","Vespertino"],
          ["2012/2013","Rockdrigo ","Martínez","García","rockdrogmg@gmail.com","6748398792","M986350","Martínez","Carrera","Rockdriguito","Primaria","5","A","Matutino"]

        ]
      ]
  }


}
