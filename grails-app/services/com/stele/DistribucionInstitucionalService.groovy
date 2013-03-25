package com.stele

class DistribucionInstitucionalService {

    def obtenerDistribucionInstitucionalDesdeCommand(FilaExcelCommand filaExcelCommand) { 
      def distribucionInstitucional = new DistribucionInstitucional()
      distribucionInstitucional.grado = filaExcelCommand.grado
      distribucionInstitucional.grupo = filaExcelCommand.grupo
      distribucionInstitucional
    }
}
