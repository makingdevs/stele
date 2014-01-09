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
    def errorTutor
    def errorDependiente
    def usuarioExistente = Usuario.withCriteria{
      eq('username', insc.email)
      instituciones {
        eq('id', institucion.id)
      }
      perfil{
        eq('nombre',insc.nombrePadre)
        eq('apellidoPaterno', insc.apellidoPaternoPadre)
        eq('apellidoMaterno', insc.apellidoMaternoPadre)
      }
    } 
    def dependienteExistente = Dependiente.withCriteria{
      eq('matricula', insc.matricula)
      usuario{
        instituciones{
          eq('id', institucion.id)
        }
      }
      perfil{
        eq('nombre',insc.nombreAlumno)
        eq('apellidoPaterno',insc.apellidoPaternoAlumno)
        eq('apellidoMaterno',insc.apellidoMaternoAlumno)
      }
    }
    if (!usuarioExistente.isEmpty()){
      return errorTutor = "El email del tutor ya esta registrados para otro usuario"
    }
    if (!dependienteExistente.isEmpty()){
      return errorDependiente = "la Matricula  ya existe para otro usuario, los datos no coinciden"
    }
    
    def mapaDomains = [ usuario: usuarioService.obtenerUsuarioDesdeCommand(insc),
                        dependiente:dependienteService.obtenerDependienteDesdeCommand(insc),
                        cicloEscolar:cicloEscolarService.obtenerCicloEscolarDesdeCommand(insc),
                        distribucionInstitucional:distribucionInstitucionalService.obtenerDistribucionInstitucionalDesdeCommand(insc)
                      ]
    mapaDomains.dependiente.camada = generarNombreCamada(institucion)
    def usuarioCargado = usuarioService.registrar(mapaDomains.usuario, institucion)
    def dependienteCargado = dependienteService.registrar(mapaDomains.dependiente, usuarioCargado.id,institucion)
    def cicloEscolarCargado = cicloEscolarService.registrar(mapaDomains.cicloEscolar)
    def distribucionInstitucionalCargado = distribucionInstitucionalService.registrar(mapaDomains.distribucionInstitucional, institucion.id)
    def historialAcademicoCargado = historialAcademicoService.registrar(historialAcademicoService.preparaHistoricoAcademicoARegistrar(dependienteCargado,distribucionInstitucionalCargado))
    [success:"Se a Inscrito Correctamen el padre y su dependiente"]
    
  }

  def generarNombreCamada(Institucion institucion) {
      def nombreDeInstitucion = institucion.nombre.size() > 100 ? institucion.nombre.substring(0,80) : institucion.nombre
      def camadaGenerada = nombreDeInstitucion.replaceAll(" ","_") + "_" + new Date().format("dd_MM_yy_HH_mm")
      camadaGenerada
  }
}


