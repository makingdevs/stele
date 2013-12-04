package com.stele

class InscripcionManualService {

  def usuarioService
  def dependienteService
  def cicloEscolarService
  def distribucionInstitucionalService
  def historialAcademicoService

  def generarRegistroDeAlumnoYTutor(InscripcionCommand insc, Institucion institucion) {
    def mapaDomains = [ usuario: usuarioService.obtenerUsuarioDesdeCommand(insc),
                        dependiente:dependienteService.obtenerDependienteDesdeCommand(insc),
                        cicloEscolar:cicloEscolarService.obtenerCicloEscolarDesdeCommand(insc),
                        distribucionInstitucional:distribucionInstitucionalService.obtenerDistribucionInstitucionalDesdeCommand(insc)
                      ]
    

    mapaDomains.dependiente.camada = generarNombreCamada(institucion)
    def usuarioCargado = usuarioService.registrar(mapaDomains.usuario, institucion)
    def dependienteCargado = dependienteService.registrar(mapaDomains.dependiente, usuarioCargado.id)
    def cicloEscolarCargado = cicloEscolarService.registrar(mapaDomains.cicloEscolar)
    def distribucionInstitucionalCargado = distribucionInstitucionalService.registrar(mapaDomains.distribucionInstitucional, institucion.id)
    def historialAcademicoCargado = historialAcademicoService.registrar(historialAcademicoService.preparaHistoricoAcademicoARegistrar(dependienteCargado,distribucionInstitucionalCargado))
    [usuario: usuarioCargado, dependiente: dependienteCargado, cicloEscolar: cicloEscolarCargado, distribucionInstitucional: distribucionInstitucionalCargado, historialAcademico: historialAcademicoCargado]
  }

   def generarNombreCamada(Institucion institucion) {
      def nombreDeInstitucion = institucion.nombre.size() > 100 ? institucion.nombre.substring(0,80) : institucion.nombre
      def camadaGenerada = nombreDeInstitucion.replaceAll(" ","_") + "_" + new Date().format("dd_MM_yy_HH_mm")
      camadaGenerada
    }
}