package com.stele

import com.stele.DistribucionInstitucional
import com.stele.Turno
import com.stele.NivelDeEstudio
import com.stele.HistorialAcademico

class DependienteController {

    def springSecurityService

    def nuevo() { }

    def search() {
      def distribucionInstitucional = DistribucionInstitucional.withCriteria {
        if (params.turno)
          eq('turno', Turno.find{it.value == params?.turno})
        if (params.nivel)
          eq('nivelDeEstudio', NivelDeEstudio.find{it.value == params.nivel})
        if (params.grado)
          eq('grado', params?.grado.toInteger())
        if (params.grupo)
          eq('grupo', params?.grupo)
        eq('institucion', springSecurityService.currentUser.instituciones?.first())

      }
      def dependientesPorDistribucionEnHistorial = HistorialAcademico.withCriteria {
        'in'('distribucionInstitucional', distribucionInstitucional)
        dependiente{
            if(params.matricula)
              ilike('matricula', params.matricula)
            join('perfil')
        }
      }
      flash.dependientes = dependientesPorDistribucionEnHistorial.dependiente*.id
      render template:'dependienteCar', model:[dependiente:dependientesPorDistribucionEnHistorial, institucion:springSecurityService.currentUser.instituciones?.first()]
    }

    def busqueda() { 
      def turnos = DistribucionInstitucional.withCriteria {
        projections {
          groupProperty('turno')
        }
      }
      flash.turnos = turnos
      [turnos:turnos,turno:null]
    }

    def descripcionDependientes() {
      def listaHistorialesId = []
      def lista = params.dependiente
      lista.each { it ->
        if (it.equals("[") || it.equals("]") || it.equals(",") || it.equals(" ")){
        }
        else{
          listaHistorialesId.add(it.toLong())
        }
      }
      def historialAcademico = HistorialAcademico.withCriteria {
        'in'('id',listaHistorialesId )
        dependiente{
          join('perfil')
        }
      }
      render (view:"dependientesDetalleList", model:[dependiente:historialAcademico])
    }
    def ajaxTurnoANivel() {
      def turno = Turno.find{it.value == params.turno}
      def niveles = DistribucionInstitucional.withCriteria {
        eq('turno', turno)
          projections {
            groupProperty('nivelDeEstudio')
          }
      }
      def turnos = flash.turnos
      def nivel=null
      flash.turnos = turnos
      flash.turno = turno
      flash.niveles = niveles
      render template:'busquedaForm', model:[turnos:turnos,turno:turno,niveles:niveles,nivel:nivel]
    }

    def ajaxNivelAGrado() {
      def nivel = NivelDeEstudio.find{it.value == params.nivel}
      def grados = DistribucionInstitucional.withCriteria {
        eq('turno', flash.turno)
        eq('nivelDeEstudio', nivel)
           projections {
            groupProperty('grado')
           }
      }
      def turnos = flash.turnos
      def turno = flash.turno
      def niveles = flash.niveles
      flash.turnos = turnos
      flash.turno = turno
      flash.niveles = niveles
      flash.grados = grados
      flash.nivel = nivel
      render template:'busquedaForm', model:[turnos:turnos,turno:turno,niveles:niveles,nivel:nivel, grados:grados, grado:null]
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
}



