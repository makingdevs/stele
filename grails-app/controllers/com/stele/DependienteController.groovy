package com.stele

import com.stele.Turno
import com.stele.NivelDeEstudio
import com.stele.seguridad.Usuario
import com.stele.Dependiente

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
      render template:'dependienteCar', model:[dependientesPorEstructura:listaDependientesPorEstructura, institucion:springSecurityService.currentUser.instituciones?.first()]
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
      def dependientes = []
      if(params.nombreDependiente)
        dependientes = dependienteService.findDependientesByNameAndOrganization(params.nombreDependiente, springSecurityService.currentUser.instituciones?.first()
)
      flash.dependiente = dependientes ? "" : "No se encontraron dependientes con ese nombre"

      render template:'busquedaDependiente', model:[dependientes:dependientes ?: [], institucion: springSecurityService.currentUser.instituciones?.first()]
    }

    def busquedaDependienteParaObtenerPagos() {
      def dependientes = []

      if(params.nombreDependiente)
        dependientes = dependienteService.findDependientesByNameAndOrganization(params.nombreDependiente, springSecurityService.currentUser.instituciones?.first())

      flash.dependiente = dependientes ? "" : "No se encontraron dependientes con ese nombre"

      render template:'resultados', model:[dependientes: dependientes ?: [], institucion: springSecurityService.currentUser.instituciones?.first()]
    }

    private def separarDependientesPorInstitucion(dependiente){
      def ids = dependiente*.id
      def institucion = springSecurityService.currentUser.instituciones?.first()
      def resultados = Usuario.withCriteria{
        dependientes{
          'in'('id', ids) 
        }
        instituciones{
          eq('id', institucion.id)
        }
      }
    resultados
  }

}
