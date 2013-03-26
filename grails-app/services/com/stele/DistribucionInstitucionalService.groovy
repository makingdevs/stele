package com.stele

class DistribucionInstitucionalService {

  def obtenerDistribucionInstitucionalDesdeCommand(FilaExcelCommand filaExcelCommand) { 
    def distribucionInstitucional = new DistribucionInstitucional()
    distribucionInstitucional.grado = filaExcelCommand.grado
    distribucionInstitucional.grupo = filaExcelCommand.grupo
    distribucionInstitucional.nivelDeEstudio = validaNivelDeEstudio(filaExcelCommand.nivel)
    distribucionInstitucional
  }

  private NivelDeEstudio validaNivelDeEstudio(String nivel){
    def nivelToUpper = nivel.toUpperCase()
    def preescolar = /\b${NivelDeEstudio.PREESCOLAR.toString()toUpperCase().substring(0,3)}\w*/
    def primaria = /\b${NivelDeEstudio.PRIMARIA.toString()toUpperCase().substring(0,3)}\w*/
    def secundaria = /\b${NivelDeEstudio.SECUNDARIA.toString()toUpperCase().substring(0,3)}\w*/
    def bachillerato = /\b${NivelDeEstudio.BACHILLERATO.toString()toUpperCase().substring(0,3)}\w*/
    def educacionSuperior = /\b${NivelDeEstudio.EDUCACION_SUPERIOR.toString()toUpperCase().substring(0,3)}\w*/

    if( ((nivelToUpper =~ preescolar).find()) )
      return NivelDeEstudio.PREESCOLAR
    else if( ((nivelToUpper =~ primaria).find()) )
      return NivelDeEstudio.PRIMARIA
    else if( ((nivelToUpper =~ secundaria).find()) )
      return NivelDeEstudio.SECUNDARIA
    else if( ((nivelToUpper =~ bachillerato).find()) )
      return NivelDeEstudio.bachillerato
    else if( ((nivelToUpper =~ educacionSuperior).find()) )
      return NivelDeEstudio.educacionSuperior
    else
      return NivelDeEstudio.PRIMARIA
  }

}
