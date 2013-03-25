package com.stele

class DistribucionInstitucionalService {

    def obtenerDistribucionInstitucionalDesdeCommand(FilaExcelCommand filaExcelCommand) { 
      def distribucionInstitucional = new DistribucionInstitucional()
      distribucionInstitucional.nivelDeEstudio = nivelDeEstudio
      distribucionInstitucional.grado = filaExcelCommand.grado
      distribucionInstitucional.grupo = filaExcelCommand.grupo
      distribucionInstitucional.nivelDeEstudio.value = filaExcelCommand.nivel
      distribucionInstitucional
    }
}
