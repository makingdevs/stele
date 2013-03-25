package com.stele

import jxl.*

class ExcelService {

  def leerArchivoDesdeLaRuta(String ruta) {
    Workbook workbook = Workbook.getWorkbook(new File(ruta));
    Sheet sheet = workbook.getSheet(0)

    def contenidoDeFilas = []

    (1..sheet.getRows() - 1).each { fila ->
      contenidoDeFilas << sheet.getRow( 1 )*.getContents()
    }

    contenidoDeFilas

  }

}
