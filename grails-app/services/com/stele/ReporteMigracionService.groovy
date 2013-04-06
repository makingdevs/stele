package com.stele

class ReporteMigracionService {

  def conteoDeDatosPorDependientes(estructuraInstitucional) {
    if( estructuraInstitucional instanceof List ) {
      return estructuraInstitucional.size()
    }

    def llave = estructuraInstitucional.collect { k, v -> k }
    conteoDeDatosPorDependientes( estructuraInstitucional.(llave[0]) )
  }

}
