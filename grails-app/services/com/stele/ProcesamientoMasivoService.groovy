package com.stele

class ProcesamientoMasivoService {

  def usuarioService
  def dependienteService
  def cicloEscolarService
  def distribucionInstitucionalService
  def historialAcademicoService

  def procesaMapaConDatosDeFilaDeExcelParaPersistir(def filaDeExcelParaPersistir,Long institucionId) {
    def institucion = Institucion.get(institucionId)
    def usuario = usuarioService.registrar(filaDeExcelParaPersistir.usuario, institucion)
    if (usuario){
      def dependiente = dependienteService.registrar(filaDeExcelParaPersistir.dependiente, usuario.id, institucion)
      def cicloEscolar = cicloEscolarService.registrar(filaDeExcelParaPersistir.cicloEscolar)
      def distribucionInstitucional = distribucionInstitucionalService.registrar(filaDeExcelParaPersistir.distribucionInstitucional, institucionId)
      def historialAcademico = historialAcademicoService.registrar(historialAcademicoService.preparaHistoricoAcademicoARegistrar(dependiente,distribucionInstitucional))
      [usuario: usuario, dependiente: dependiente, cicloEscolar: cicloEscolar, distribucionInstitucional: distribucionInstitucional, historialAcademico:historialAcademico]
    } else {
      [usuariosOtraInstitucion:new Date()]
    }
  }
}
