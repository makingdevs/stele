package com.stele

import grails.converters.JSON

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
      flash.success = "Se ha creado correctamente el Estudiante $registroAlumnoTutor.dependiente.perfil.nombre $registroAlumnoTutor.dependiente.perfil.apellidoPaterno $registroAlumnoTutor.dependiente.perfil.apellidoMaterno" 
      render(view : "inscripcion" , model:[usuario: springSecurityService.currentUser])
    }

    def parsearDependiente(){
      def historial = historialAcademicoService.obtenerhistorialAcademicoPorDependiente(params.idDependiente)
      render template:'listaDependientes', model:[action:historial]
    }
}