package com.stele

class DistribucionInstitucionalService {

  def obtenerDistribucionInstitucionalDesdeCommand(FilaExcelCommand filaExcelCommand) { 
    def distribucionInstitucional = new DistribucionInstitucional()
    distribucionInstitucional.grado = filaExcelCommand.grado
    distribucionInstitucional.grupo = filaExcelCommand.grupo
    distribucionInstitucional.nivelDeEstudio = validaNivelDeEstudio(filaExcelCommand.nivel)
    distribucionInstitucional.turno = validaTurno(filaExcelCommand.turno)
    distribucionInstitucional
  }

  private NivelDeEstudio validaNivelDeEstudio(String nivel){
    def nivelToUpper = nivel.toUpperCase()
    def preescolar = /\b${NivelDeEstudio.PREESCOLAR.toString()toUpperCase()substring(0,3)}\w*/
    def primaria = /\b${NivelDeEstudio.PRIMARIA.toString()toUpperCase()substring(0,3)}\w*/
    def secundaria = /\b${NivelDeEstudio.SECUNDARIA.toString()toUpperCase()substring(0,3)}\w*/
    def bachillerato = /\b${NivelDeEstudio.BACHILLERATO.toString()toUpperCase()substring(0,3)}\w*/
    def educacionSuperior = /\b${NivelDeEstudio.EDUCACION_SUPERIOR.toString()toUpperCase()substring(0,3)}\w*/

    if( ((nivelToUpper =~ preescolar).find()) )
      return NivelDeEstudio.PREESCOLAR
    else if( ((nivelToUpper =~ secundaria).find()) )
      return NivelDeEstudio.SECUNDARIA
    else if( ((nivelToUpper =~ bachillerato).find()) )
      return NivelDeEstudio.BACHILLERATO
    else if( ((nivelToUpper =~ educacionSuperior).find()) )
      return NivelDeEstudio.EDUCACION_SUPERIOR
    else
      return NivelDeEstudio.PRIMARIA
  }

  private Turno validaTurno(String turno){
    def turnoToUpper = turno.toUpperCase()
    def matutino = /\b${Turno.MATUTINO.toString()toUpperCase()substring(0,1)}\w*/
    def vespertino = /\b${Turno.VESPERTINO.toString()toUpperCase()substring(0,1)}\w*/
    def tarde = /\bT\w*/
    def nocturno = /\b${Turno.NOCTURNO.toString()toUpperCase()substring(0,1)}\w*/

    if( ((turnoToUpper =~ vespertino).find()) ||  ((turnoToUpper =~ tarde).find()) )
      return Turno.VESPERTINO
    else if( ((turnoToUpper =~ nocturno).find()) )
      return Turno.NOCTURNO
    else
      return Turno.MATUTINO

  }

}
