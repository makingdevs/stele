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

}
