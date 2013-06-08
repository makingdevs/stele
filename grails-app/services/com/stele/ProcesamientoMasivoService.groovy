package com.stele

class ProcesamientoMasivoService {

  def usuarioService
  def dependienteService
  def cicloEscolarService
  def distribucionInstitucionalService

  def procesaMapaConDatosDeFilaDeExcelParaPersistir(def filaDeExcelParaPersistir) {
    def usuario = usuarioService.registrar(filaDeExcelParaPersistir.usuario)
    def dependiente = dependienteService.registrar(filaDeExcelParaPersistir.dependiente)
    def cicloEscolar = cicloEscolarService.registrar(filaDeExcelParaPersistir.cicloEscolar)
    def distribucionInstitucional = distribucionInstitucionalService.registrar(filaDeExcelParaPersistir.distribucionInstitucional)
    [usuario: usuario, dependiente: dependiente, cicloEscolar: cicloEscolar, distribucionInstitucional: distribucionInstitucional]
  }
}
