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

    def busquedaDependienteParaGenerarPago() {
      def searchResult = searchableService.search(params.nombreDependiente)
      render template:'busquedaDependiente', model:[dependientes: searchResult ?: "", institucion: springSecurityService.currentUser.instituciones?.first()]
    }

    def busquedaDependienteParaObtenerPagos() {
      def searchResult = searchableService.search(params.nombreDependiente)
      render template:'resultados', model:[dependientes: searchResult ?: "", institucion: springSecurityService.currentUser.instituciones?.first()]
    }

    def buscarDependienteInscripcion() {
      def dependientesCoincidentes = searchableService.search(params.nombreDependienteBusqueda)
      render template:'/inscripcionManual/listaDependientes', model:[dependientes: dependientesCoincidentes.results]
    }
    
}
