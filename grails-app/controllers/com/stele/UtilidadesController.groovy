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
    def nivel = NivelDeEstudio.find{it.value == params.nivel}
    def turno = Turno.find{it.value == params.turno}
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
    def grado = params.grado
    def grupos = DistribucionInstitucional.withCriteria {
      eq('turno', flash.turno)
      eq('nivelDeEstudio', flash.nivel)
      eq('grado', grado.toInteger())
         projections {
          groupProperty('grupo')
         }
    }
    def turnos = flash.turnos
    def turno = flash.turno
    def niveles = flash.niveles
    def nivel = flash.nivel
    def grados = flash.grados
    flash.turnos = turnos
    flash.turno = turno
    flash.niveles = niveles
    flash.nivel = nivel
    flash.grados = grados
    flash.grado = grado
    render template:'busquedaForm', model:[turnos:turnos,turno:turno,niveles:niveles,nivel:nivel, grados:grados, grado:grado, grupos:grupos, grupo:null]
  }

  def ajaxGrupo() { }

  def avisoPrivacidad(){}
  
  def terminosYCondiciones(){}

  def precio(){}

  def contacto(){}

  def servicios(){}
}
