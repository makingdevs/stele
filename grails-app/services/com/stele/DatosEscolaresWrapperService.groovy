package com.stele

class DatosEscolaresWrapperService {

  def excelService
  def filaExcelCommandService

  def obtenerFilasExcelCommandsDesdeArchivo(FileInputStream archivoDeExcel) {
    def filas = excelService.procesarFilas(archivoDeExcel)
    filaExcelCommandService.convertirListaACommands(filas.grep{ l -> l.size() })
  }
}
