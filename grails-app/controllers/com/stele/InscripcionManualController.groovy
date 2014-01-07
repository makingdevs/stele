package com.stele

import grails.converters.JSON
import com.stele.seguridad.Usuario

class InscripcionManualController {

	  def springSecurityService
    def inscripcionManualService
    def historialAcademicoService

		def inscripcion() {
    	def user = springSecurityService.currentUser
    	[usuario:user]
		}

		def crearUsuarioCondependiente(InscripcionCommand insc ) {
      def institucion = springSecurityService.currentUser.instituciones?.first()
      def registroAlumnoTutor = inscripcionManualService.generarRegistroDeAlumnoYTutor(insc, institucion)
      if (registroAlumnoTutor instanceof String)
        flash.error = registroAlumnoTutor
      else
        flash.success = registroAlumnoTutor.values()
      render(view : "inscripcion" , model:[usuario: springSecurityService.currentUser])
    }

    def parsearDependiente(){
      def historial = historialAcademicoService.obtenerhistorialAcademicoPorDependiente(params.idDependiente)
      render template:'seccionAlumno', model:[action:historial]
    }

    def parsearTutor(){
      def usuario = Usuario.withCriteria{
        eq('id', params.idTutor.toLong())
        perfil{
          join('telefono')
        }
      }
      render template:'seccionTutor', model:[user: usuario.first()]
    }
}