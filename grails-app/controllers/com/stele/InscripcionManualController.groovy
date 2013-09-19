package com.stele

class InscripcionManualController {

	  def springSecurityService
    def usuarioService
    def dependienteService
    def cicloEscolarService
    def distribucionInstitucionalService
    def historialAcademicoService


		def inscripcion() {
    	def user = springSecurityService.currentUser
    	[usuario:user]
		}

		def crearUsuarioCondependiente(InscripcionCommand insc ) {
      def mapaDomains = [usuario: usuarioService.obtenerUsuarioDesdeCommand(insc),
                         dependiente:dependienteService.obtenerDependienteDesdeCommand(insc),
                         cicloEscolar:cicloEscolarService.obtenerCicloEscolarDesdeCommand(insc),
		                     distribucionInstitucional:distribucionInstitucionalService.obtenerDistribucionInstitucionalDesdeCommand(insc)
                        ]
      def usuarioCargado = usuarioService.registrar(mapaDomains.usuario)
      def dependienteCargado = dependienteService.registrar(mapaDomains.dependiente, usuarioCargado.id)
      def cicloEscolarCargado = cicloEscolarService.registrar(mapaDomains.cicloEscolar)
      println cicloEscolarCargado
      def distribucionInstitucionalCargado = distribucionInstitucionalService.registrar(mapaDomains.distribucionInstitucional, springSecurityService.currentUser.instituciones?.first())
      def historialAcademico = historialAcademicoService.registrar(historialAcademicoService.preparaHistoricoAcademicoARegistrar(dependienteCargado,distribucionInstitucionalCargado))
      flash.success = "Se ha creado correctamente el Estudiante" 
      [usuario: usuarioCargado, dependiente: dependienteCargado, cicloEscolar: cicloEscolarCargado, distribucionInstitucional: distribucionInstitucionalCargado]
    }
}