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
      def institucion = springSecurityService.currentUser.instituciones?.first()
      mapaDomains.dependiente.camada = generarNombreCamada(institucion)

      def usuarioCargado = usuarioService.registrar(mapaDomains.usuario)
      def dependienteCargado = dependienteService.registrar(mapaDomains.dependiente, usuarioCargado.id)
      def cicloEscolarCargado = cicloEscolarService.registrar(mapaDomains.cicloEscolar)
      def distribucionInstitucionalCargado = distribucionInstitucionalService.registrar(mapaDomains.distribucionInstitucional, institucion.id)
      def historialAcademico = historialAcademicoService.registrar(historialAcademicoService.preparaHistoricoAcademicoARegistrar(dependienteCargado,distribucionInstitucionalCargado))
      flash.success = "Se ha creado correctamente el Estudiante $dependienteCargado.perfil.nombre $dependienteCargado.perfil.apellidoPaterno $dependienteCargado.perfil.apellidoMaterno" 
      render(view : "inscripcion" , model:[usuario: springSecurityService.currentUser])
    }

    def generarNombreCamada(Institucion institucion) {
      def nombreDeInstitucion = institucion.nombre.size() > 100 ? institucion.nombre.substring(0,80) : institucion.nombre
      def camadaGenerada = nombreDeInstitucion.replaceAll(" ","_") + "_" + new Date().format("dd_MM_yy_HH_mm")
      camadaGenerada
    }
}