package com.stele

class DistribucionInstitucionalService {

  def obtenerDistribucionInstitucionalDesdeCommand(FilaExcelCommand filaExcelCommand) { 
    def distribucionInstitucional = new DistribucionInstitucional()
    distribucionInstitucional.grado = filaExcelCommand.grado
    distribucionInstitucional.grupo = filaExcelCommand.grupo
    distribucionInstitucional.nivelDeEstudio = NivelDeEstudio.PRIMARIA
    distribucionInstitucional
  }

  private enum validaNivelDeEstudio(String nivel){

    def preescolar = /\b${NivelDeEstudio.PREESCOLAR}\w*/
    def primaria = /\b${NivelDeEstudio.PRIMARIA}\w*/
    def secunadaria = /\b${NivelDeEstudio.SECUNDARIA}\w*/
    def bachillerato = /\b${NivelDeEstudio.BACHILLERATO}\w*/
    def educacionSuperior = /\b${NivelDeEstudio.EDUCACION_SUPERIOR}\w*/

    if( ((nivel =~ preescolar).find()) )
      return NivelDeEstudio.PREESCOLAR
    else if( ((nivel =~ primaria).find()) )
      return NivelDeEstudio.PRIMARIA
    else if( ((nivel =~ secunadaria).find()) )
      return NivelDeEstudio.SECUNDARIA
    else if( ((nivel =~ bachillerato).find()) )
      return NivelDeEstudio.bachillerato
    else if( ((nivel =~ educacionSuperior).find()) )
      return NivelDeEstudio.educacionSuperior
    else
      return NivelDeEstudio.PRIMARIA

  }

}
