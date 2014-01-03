package com.stele

import com.stele.Turno
import com.stele.NivelDeEstudio

class DependienteController {

    def springSecurityService
    def searchableService
    def distribucionInstitucionalService
    def historialAcademicoService
    def dependienteService

    def search() {
      def distribucionesInstitucionales = distribucionInstitucionalService.obtenerDistribucionInstitucionalEnBaseAParametros(params,springSecurityService.currentUser.instituciones?.first())
      def historialesAcademicos = historialAcademicoService.obtenerHistorialesAcademicosEnBaseADistribucionInstitucional(distribucionesInstitucionales)
      def listaDependientesPorEstructura = generarEstructuraDependientes(historialesAcademicos)
      render template:'dependienteCar', model:[dependiente:listaDependientesPorEstructura, institucion:springSecurityService.currentUser.instituciones?.first()]
    }


    private def generarEstructuraDependientes(historialesAcademicos) {
      def dependientesPorNivel = []
      def dependientesPorGrado = []
      def dependientesPorGrupo = []
      def dependientesEstructura = []
      
      def dependientesPorTurno = dependienteService.agruparDependientesPorTurno(historialesAcademicos)
      dependientesPorTurno.each{ dependientesTurno ->
        dependientesPorNivel << dependienteService.agruparDependientesPorNivel(dependientesTurno.key,dependientesTurno.value,springSecurityService.currentUser.instituciones?.first())
      }
      dependientesPorNivel.each { niveles ->
        niveles.each{ estructura ->
          dependientesPorGrado << dependienteService.agruparDependientesPorGrado(estructura.key, estructura.value)
        }
      }
      dependientesPorGrado.each{ grados ->
        grados.each{ estructura -> 
          dependientesPorGrupo << dependienteService.agruparDependientesPorGrupo(estructura.key, estructura.value)
        }
      }
      dependientesPorGrupo.each{ grupos ->
        grupos.each{ estructura ->
          dependientesEstructura << estructura.value
        }
      }
      dependientesEstructura
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

    def busquedaDependienteParaGenerarPago() {
      def searchResult = searchableService.search(params.nombreDependiente)
      render template:'busquedaDependiente', model:[dependientes: searchResult ?: "", institucion: springSecurityService.currentUser.instituciones?.first()]
    }

    def busquedaDependienteParaObtenerPagos() {
      def searchResult = searchableService.search(params.nombreDependiente)
      render template:'resultados', model:[dependientes: searchResult ?: "", institucion: springSecurityService.currentUser.instituciones?.first()]
    }

    def buscarDependienteInscripcion() {

    }
}
