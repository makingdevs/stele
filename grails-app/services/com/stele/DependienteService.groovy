package com.stele

class DependienteService {

    def obtenerDependienteDesdeCommand(FilaExcelCommand filaExcelCommand) {
      def dependiente = new Dependiente()
      def perfil = new Perfil()
      dependiente.perfil = perfil
      dependiente.matricula = filaExcelCommand.matricula
      dependiente.perfil.nombre = filaExcelCommand.dependienteNombre
      dependiente.perfil.apellidoPaterno = filaExcelCommand.dependienteApellidoPaterno
      dependiente.perfil.apellidoMaterno = filaExcelCommand.dependienteApellidoMaterno
      dependiente
    }
}
