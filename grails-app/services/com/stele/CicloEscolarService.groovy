package com.stele

class CicloEscolarService {

  def obtenerCicloEscolarDesdeCommand(FilaExcelCommand filaExcelCommand) {
    def cicloEscolar = new CicloEscolar()
    cicloEscolar.clave = filaExcelCommand.cicloEscolar
    cicloEscolar
  }

  def obtenerCicloEscolarDesdeCommand(InscripcionCommand insc) {
    def cicloEscolar = new CicloEscolar()
    cicloEscolar.clave = insc.cicloEscolar
    cicloEscolar
  }

  def registrar(CicloEscolar cicloEscolar){
    def existeCicloEscolar = CicloEscolar.findByClave(cicloEscolar.clave)
    existeCicloEscolar ?: cicloEscolar.save()
  }
}
