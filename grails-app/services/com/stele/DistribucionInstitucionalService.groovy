package com.stele

class DistribucionInstitucionalService {

  def obtenerDistribucionInstitucionalDesdeCommand(FilaExcelCommand filaExcelCommand) { 
    def distribucionInstitucional = new DistribucionInstitucional()
    distribucionInstitucional.grado = filaExcelCommand.grado.isNumber() ? filaExcelCommand.grado.toInteger() : 0
    distribucionInstitucional.grupo = filaExcelCommand.grupo.toUpperCase()
    distribucionInstitucional.nivelDeEstudio = validaNivelDeEstudio(filaExcelCommand.nivel)
    distribucionInstitucional.turno = validaTurno(filaExcelCommand.turno)
    distribucionInstitucional
  }

  private NivelDeEstudio validaNivelDeEstudio(String nivel){
    def nivelToUpper = nivel.toUpperCase()
    def preescolar = NivelDeEstudio.PREESCOLAR.toString()toUpperCase()substring(0,3)
    def secundaria = NivelDeEstudio.SECUNDARIA.toString()toUpperCase()substring(0,3)
    def bachillerato = NivelDeEstudio.BACHILLERATO.toString()toUpperCase()substring(0,3)
    def educacionSuperior = NivelDeEstudio.EDUCACION_SUPERIOR.toString()toUpperCase()substring(0,3)
    def resultado

    switch (nivelToUpper) {
      case {it?.startsWith(preescolar) || it?.startsWith("kin")}:
      return NivelDeEstudio.PREESCOLAR
      break
      case {it?.startsWith(secundaria) }:
      return NivelDeEstudio.SECUNDARIA
      break
      case {it?.startsWith(bachillerato) }:
      return NivelDeEstudio.BACHILLERATO
      break
      case {it?.startsWith(educacionSuperior) }:
      return NivelDeEstudio.EDUCACION_SUPERIOR
      break
      default:
      return NivelDeEstudio.PRIMARIA
      break
    }
  }

  private Turno validaTurno(String turno){
    def turnoToUpper = turno.toUpperCase()
    def matutino = Turno.MATUTINO.toString()toUpperCase()getAt(0)
    def nocturno = Turno.NOCTURNO.toString()toUpperCase()getAt(0)

    switch(turnoToUpper) {
      case {it?.startsWith(matutino)}:
      return Turno.MATUTINO
      break
      case {it?.startsWith(nocturno)}:
      return Turno.NOCTURNO
      break
      default:
      return Turno.VESPERTINO
      break
    }
  }

  def registrar(DistribucionInstitucional distribucionInstitucional, Long institucionId){
    Institucion institucion = Institucion.get(institucionId)
    if(institucion){
        institucion.addToDistribucionesInstitucionales(distribucionInstitucional)
        institucion.save()
      }else{
        throw RuntimeException("No existe la institución...")
      }
  }

}
