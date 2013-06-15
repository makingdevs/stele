package com.stele

class ProcesamientoMasivoService {

  def usuarioService
  def dependienteService
  def cicloEscolarService
  def distribucionInstitucionalService

  def procesaMapaConDatosDeFilaDeExcelParaPersistir(def filaDeExcelParaPersistir,Long institucionId) {
    def usuario = usuarioService.registrar(filaDeExcelParaPersistir.usuario)
    def dependiente = dependienteService.registrar(filaDeExcelParaPersistir.dependiente, usuario.id)
    def cicloEscolar = cicloEscolarService.registrar(filaDeExcelParaPersistir.cicloEscolar)
    def distribucionInstitucional = distribucionInstitucionalService.registrar(filaDeExcelParaPersistir.distribucionInstitucional, institucionId)
    [usuario: usuario, dependiente: dependiente, cicloEscolar: cicloEscolar, distribucionInstitucional: distribucionInstitucional]
  }
}
