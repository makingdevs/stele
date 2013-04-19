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

  def conteoDeDependientesParaElNivel(estructuraInstitucional, nivel, nivelActual = 0) {
    def llaves = estructuraInstitucional.collect { k, v -> k }

    def conteo = [:]
    llaves.each {
      if(nivel == nivelActual) {
        conteo."$it" = conteoDeDatosPorDependientes( estructuraInstitucional."$it" )
      } else {
        conteo."$it" = conteoDeDependientesParaElNivel(estructuraInstitucional."$it", nivel, nivelActual + 1)
      }
    }
    conteo
  }
}
