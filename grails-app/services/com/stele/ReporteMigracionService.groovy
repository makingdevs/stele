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
    def llaves = estructuraInstitucional.collect { k, v -> k }

    def conteoPorNivel = [:]
    llaves.each {
      def llavesNivelDos = estructuraInstitucional."$it".collect { k, v -> k }
      llavesNivelDos.each { it2 ->
        conteoPorNivel."$it.$it2" = conteoDeDatosPorDependientes( estructuraInstitucional."$it"."$it2" )
      }
    }

    conteoPorNivel
  }

}
