package com.stele 

import grails.converters.JSON
import com.stele.Turno
import com.stele.NivelDeEstudio

class UtilidadesController {
	
	def ajaxTurnoANivel() {
    def turno = Turno.find{it.value == params.turno}
    def niveles  = DistribucionInstitucional.withCriteria {
      eq('turno', turno)
        projections {
          groupProperty('nivelDeEstudio')
        }
    }
  
    render (niveles*.value as JSON)
  }

  def ajaxNivelAGrado() {
    def turno = Turno.find{it.value == params.turno}
    def nivel = NivelDeEstudio.find{it.value == params.nivel}
    def grados = DistribucionInstitucional.withCriteria {
      eq('turno',turno)
      eq('nivelDeEstudio', nivel)
         projections {
          groupProperty('grado')
         }
    }

    render (grados as JSON)
  }

  def ajaxGradoAGrupo() {
    def turno = Turno.find{it.value == params.turno}
    def nivel = NivelDeEstudio.find{it.value == params.nivel}
    def grado = params.grado
    def grupos = DistribucionInstitucional.withCriteria {
      eq('turno',turno)
      eq('nivelDeEstudio',nivel)
      eq('grado', grado.toInteger())
         projections {
          groupProperty('grupo')
         }
    }

    render (grupos as JSON)
  }

  def ajaxGrupo() { }

  def avisoPrivacidad(){}
  
  def terminosYCondiciones(){}

  def precio(){}

  def contacto(){}

  def servicios(){}
}
