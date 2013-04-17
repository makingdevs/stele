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

  def conteoDeDependientes(estructuraInstitucional, profundidadAIr, nivelActual = 0) {
    def llaves = estructuraInstitucional.collect { k, v -> k }

    def conteo = [:]
    llaves.each {
      if(profundidadAIr == nivelActual) {
        conteo."$it" = conteoDeDatosPorDependientes( estructuraInstitucional."$it" )
      } else {
        conteo."$it" = conteoDeDependientes(estructuraInstitucional."$it", profundidadAIr, nivelActual + 1)
      }
    }
    conteo
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

  def conteoDeDependientesPorNivelYGrado(estructuraInstitucional) {
    def llaves = estructuraInstitucional.collect { k, v -> k }

    def conteoPorNivelYGrado = [:]
    llaves.each {
      def llavesNivelDos = estructuraInstitucional."$it".collect { k, v -> k }
      llavesNivelDos.each { it2 ->
        def llavesNivelTres = estructuraInstitucional."$it"."$it2".collect { k, v -> k }
        llavesNivelTres.each { it3 ->
          conteoPorNivelYGrado."$it.$it2.$it3" = conteoDeDatosPorDependientes( estructuraInstitucional."$it"."$it2"."$it3" )
        }
      }
    }

    conteoPorNivelYGrado
  }

  def conteoDeDependientesPorNivelGradoYTurno(estructuraInstitucional) {
    def llaves = estructuraInstitucional.collect { k, v -> k }

    def conteoPorNivelGradoYTurno = [:]
    llaves.each {
      def llavesNivelDos = estructuraInstitucional."$it".collect { k, v -> k }
      llavesNivelDos.each { it2 ->
        def llavesNivelTres = estructuraInstitucional."$it"."$it2".collect { k, v -> k }
        llavesNivelTres.each { it3 ->
          def llavesNivelCuatro = estructuraInstitucional."$it"."$it2"."$it3".collect { k, v -> k }
          llavesNivelCuatro.each { it4 ->
            conteoPorNivelGradoYTurno."$it.$it2.$it3.$it4" = conteoDeDatosPorDependientes( estructuraInstitucional."$it"."$it2"."$it3"."$it4" )
          }
        }
      }
    }

    conteoPorNivelGradoYTurno
  }

  def conteoDeDependientesPorNivelGradoTurnoYGrupo(estructuraInstitucional) {
    def llaves = estructuraInstitucional.collect { k, v -> k }

    def conteoPorNivelGradoTurnoYGrupo = [:]
    llaves.each {
      def llavesNivelDos = estructuraInstitucional."$it".collect { k, v -> k }
      llavesNivelDos.each { it2 ->
        def llavesNivelTres = estructuraInstitucional."$it"."$it2".collect { k, v -> k }
        llavesNivelTres.each { it3 ->
          def llavesNivelCuatro = estructuraInstitucional."$it"."$it2"."$it3".collect { k, v -> k }
          llavesNivelCuatro.each { it4 ->
            def llavesNivelCinco = estructuraInstitucional."$it"."$it2"."$it3"."$it4".collect { k, v -> k }
            llavesNivelCinco.each { it5 ->
              conteoPorNivelGradoTurnoYGrupo."$it.$it2.$it3.$it4.$it5" = conteoDeDatosPorDependientes( estructuraInstitucional."$it"."$it2"."$it3"."$it4"."$it5" )
            }
          }
        }
      }
    }

    conteoPorNivelGradoTurnoYGrupo
  }
}
