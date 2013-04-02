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
    def resultado

    switch (nivelToUpper) {
      case {it.startsWith(preescolar) }:
        resultado = NivelDeEstudio.PREESCOLAR
        break
      case {it.startsWith(secundaria) }:
        resultado = NivelDeEstudio.SECUNDARIA
        break
      case {it.startsWith(bachillerato) }:
        resultado = NivelDeEstudio.BACHILLERATO
        break
      case {it.startsWith(educacionSuperior) }:
        resultado = NivelDeEstudio.EDUCACION_SUPERIOR
        break
      default:
        resultado = NivelDeEstudio.PRIMARIA
        break
    }
    resultado
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
