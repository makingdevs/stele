package com.stele

class DatosEscolaresWrapperService {

  def excelService
  def filaExcelCommandService

  def convertirACommandsArchivo(String ruta) {
    def filas = excelService.leerArchivoDesdeLaRuta(ruta)
    
    filaExcelCommandService.convertirListaACommands(filas)
  }
}
