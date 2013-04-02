package com.stele

class DistribucionInstitucionalService {

  def obtenerDistribucionInstitucionalDesdeCommand(FilaExcelCommand filaExcelCommand) { 
    def distribucionInstitucional = new DistribucionInstitucional()
    distribucionInstitucional.grado = filaExcelCommand.grado.isNumber() ? filaExcelCommand.grado.toInteger() : 0
    distribucionInstitucional.grupo = filaExcelCommand.grupo
    distribucionInstitucional.nivelDeEstudio = validaNivelDeEstudio(filaExcelCommand.nivel)
    distribucionInstitucional.turno = validaTurno(filaExcelCommand.turno)
    distribucionInstitucional
  }

  private NivelDeEstudio validaNivelDeEstudio(String nivel){
    def nivelToUpper = nivel.toUpperCase()
    def preescolar = NivelDeEstudio.PREESCOLAR.toString()toUpperCase()substring(0,3)
    def primaria = NivelDeEstudio.PRIMARIA.toString()toUpperCase()substring(0,3)
    def secundaria = NivelDeEstudio.SECUNDARIA.toString()toUpperCase()substring(0,3)
    def bachillerato = NivelDeEstudio.BACHILLERATO.toString()toUpperCase()substring(0,3)
    def educacionSuperior = NivelDeEstudio.EDUCACION_SUPERIOR.toString()toUpperCase()substring(0,3)

    switch (nivelToUpper) {
      case {it.startsWith(preescolar) }:
        return NivelDeEstudio.PREESCOLAR
        break
      case {it.startsWith(secundaria) }:
        return NivelDeEstudio.SECUNDARIA
        break
      case {it.startsWith(bachillerato) }:
        return NivelDeEstudio.BACHILLERATO
        break
      case {it.startsWith(educacionSuperior) }:
        return NivelDeEstudio.EDUCACION_SUPERIOR
        break
      default:
        return NivelDeEstudio.PRIMARIA
        break
    }
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
