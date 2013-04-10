package com.stele

class ReporteMigracionService {

  def conteoDeDatosPorDependientes(estructuraInstitucional) {
    if( estructuraInstitucional instanceof List ) {
      return estructuraInstitucional.size()
    }

    def llave = estructuraInstitucional.collect { k, v -> k }
    def sumatoria = 0
    llave.each {
      def resultado = conteoDeDatosPorDependientes( estructuraInstitucional."$it" )
      if(resultado instanceof Integer)
        sumatoria += resultado
    }

    sumatoria
  }

  def conteoDeDependientesPorCicloEscolar(estructuraInstitucional) {
    def llaves = estructuraInstitucional.collect { k, v -> k }

    def conteoPorCicloEscolar = [:]
    llaves.each {
      conteoPorCicloEscolar."$it" = conteoDeDatosPorDependientes( estructuraInstitucional."$it" )
    }

    conteoPorCicloEscolar
  }
  
  def conteoDeDependientesPorNivel(estructuraInstitucional) {
    def mapa = estructuraInstitucional.collect { k, v -> v }

    def mapa2 = mapa*.collect { k, v -> k }.flatten()

    def conteoPorNivel = [:]
    mapa.eachWithIndex { it, index ->
      conteoPorNivel."${mapa2[index]}" = conteoDeDatosPorDependientes( it )
    }

    conteoPorNivel
  }

}
