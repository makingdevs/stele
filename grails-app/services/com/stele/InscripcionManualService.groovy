package com.stele

import com.stele.seguridad.Usuario
import com.stele.Dependiente

class InscripcionManualService {

  def usuarioService
  def dependienteService
  def cicloEscolarService
  def distribucionInstitucionalService
  def historialAcademicoService

  def generarRegistroDeAlumnoYTutor(InscripcionCommand insc, Institucion institucion) {
    def mapaDomains = [usuario: usuarioService.obtenerUsuarioDesdeCommand(insc),
                       dependiente:dependienteService.obtenerDependienteDesdeCommand(insc)]

    def usuarioCargado = usuarioService.registrar(mapaDomains.usuario, institucion)
    def dependienteCargado = dependienteService.registrar(mapaDomains.dependiente, usuarioCargado.id,institucion)
      
    if(!(dependienteCargado instanceof Dependiente))
      return [error:"Ya existe un dependiente con la misma matricula"] 

    mapaDomains.cicloEscolar = cicloEscolarService.obtenerCicloEscolarDesdeCommand(insc)
    mapaDomains.distribucionInstitucional = distribucionInstitucionalService.obtenerDistribucionInstitucionalDesdeCommand(insc)
    mapaDomains.dependiente.camada = generarNombreCamada(institucion)

    def cicloEscolarCargado = cicloEscolarService.registrar(mapaDomains.cicloEscolar)
    def distribucionInstitucionalCargado = distribucionInstitucionalService.registrar(mapaDomains.distribucionInstitucional, institucion.id)
    def historialAcademico = historialAcademicoService.preparaHistoricoAcademicoARegistrar(dependienteCargado,distribucionInstitucionalCargado)
    def historialAcademicoCargado = historialAcademicoService.registrar(historialAcademico)
    [message:"Se ha inscrito correctamente al dependiente"]
  } 

  def generarNombreCamada(Institucion institucion) {
      def nombreDeInstitucion = institucion.name.size() > 100 ? institucion.name.substring(0,80) : institucion.name
      def camadaGenerada = nombreDeInstitucion.replaceAll(" ","_") + "_" + new Date().format("dd_MM_yy_HH_mm")
      camadaGenerada
  }

  def obtenerCicloEscolarActual(){
    def calendar = Calendar.instance
    def year = calendar[Calendar.YEAR] 
    def month = calendar[Calendar.MONTH] 
    def cicloEscolar = month <= 5 ? "${year-1}/${year}" : "${year}/${year+1}"
  }
}


