package com.stele

import grails.plugin.spock.IntegrationSpec

class ExcelServiceSpec extends IntegrationSpec {

  def "De acuerdo a una ruta de archivo debe regresar una lista de filas"() {
    when : "Invocamos al método de lectura"
      def resultado = service.leerArchivoDesdeLaRuta(ruta)

    then : "Obtenemos los siguientes resultados : "
      assert filasDeArchivo.size() == resultado.size()
      assert filasDeArchivo == resultado

    where :
      ruta            || filasDeArchivo
      "layout.xls"    || ["Ciclo escolar","Nombre","Apellido paterno","Apellido materno","Correo electrónico","Telefono","Matrícula","Apellido paterno","Apellido materno","Nombre(s)","Nivel","Grado","Grupo","Turno"]
  }


}
