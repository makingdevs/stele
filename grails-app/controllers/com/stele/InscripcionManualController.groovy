package com.stele

import grails.converters.JSON
import com.stele.seguridad.Usuario
import com.stele.Institucion
import com.stele.Dependiente

class InscripcionManualController {

  def springSecurityService
  def inscripcionManualService
  def historialAcademicoService
  
  def inscripcion() {
    def user = springSecurityService.currentUser
    def cicloEscolar = inscripcionManualService.obtenerCicloEscolarActual()   
    [usuario:user,cicloEscolar:cicloEscolar]
  }

		def crearUsuarioCondependiente(InscripcionCommand insc ) {
      def institucion = springSecurityService.currentUser.instituciones?.first()
      def registroAlumnoTutor = inscripcionManualService.generarRegistroDeAlumnoYTutor(insc, institucion)
      flash.success = registroAlumnoTutor.values()
      render(view : "inscripcion" , model:[usuario: springSecurityService.currentUser,cicloEscolar:inscripcionManualService.obtenerCicloEscolarActual()])
    }
      
    def validarUsuarioExistente() {
      def institucion = springSecurityService.currentUser.instituciones?.first()
      def usuario = Usuario.withCriteria(uniqueResult:true){
        eq('username', params.username)
        instituciones{
          eq('id', institucion.id)
        }
      }
      JSON.use('stele'){ 
        render usuario as JSON
      }
    }

    def validarDependienteExistente() {
      def institucion = springSecurityService.currentUser.instituciones?.first()
      def dependiente = Dependiente.findByMatricula(params.matricula)
      def usuarioDependiente = Usuario.withCriteria(uniqueResult: true){
        dependientes{
          eq('id', dependiente?.id)
        }
        instituciones{
          eq('id', institucion.id)
        }
      }
      JSON.use('stele'){
        render usuarioDependiente as JSON
      }
    } 
}
