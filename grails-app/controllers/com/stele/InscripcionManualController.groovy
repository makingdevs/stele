package com.stele

class InscripcionManualController {

	  def springSecurityService
    def inscripcionManualService

		def inscripcion() {
    	def user = springSecurityService.currentUser
    	[usuario:user]
		}

		def crearUsuarioCondependiente(InscripcionCommand insc ) {
      
      def institucion = springSecurityService.currentUser.instituciones?.first()
      def registroAlumnoTutor = inscripcionManualService.generarRegistroDeAlumnoYTutor(insc, inscripcion)
      flash.success = "Se ha creado correctamente el Estudiante $dependienteCargado.perfil.nombre $dependienteCargado.perfil.apellidoPaterno $dependienteCargado.perfil.apellidoMaterno" 
      render(view : "inscripcion" , model:[usuario: springSecurityService.currentUser])
    }

   
}