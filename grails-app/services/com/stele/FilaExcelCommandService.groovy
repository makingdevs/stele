package com.stele

class FilaExcelCommandService {

  def convertirListaACommands(def filas) {
    def listaDeCommands = []

    filas.each { fila ->
      listaDeCommands << convertirACommand(fila)
    }

    listaDeCommands
  }

  FilaExcelCommand convertirACommand(def filaDeExcel) {
    new FilaExcelCommand(
      cicloEscolar : filaDeExcel[0]?.trim(),
      tutorNombre : filaDeExcel[1]?.trim(),
      tutorApellidoPaterno : filaDeExcel[2]?.trim(),
      tutorApellidoMaterno : filaDeExcel[3]?.trim(),
      correoElectronico : filaDeExcel[4]?.trim(),
      telefono : filaDeExcel[5]?.trim(),
      matricula : filaDeExcel[6]?.trim(),
      dependienteApellidoPaterno : filaDeExcel[7]?.trim(),
      dependienteApellidoMaterno : filaDeExcel[8]?.trim(),
      dependienteNombre : filaDeExcel[9]?.trim(),
      nivel : filaDeExcel[10]?.trim(),
      grado : filaDeExcel[11]?.trim(),
      grupo : filaDeExcel[12]?.trim())
  }

}
