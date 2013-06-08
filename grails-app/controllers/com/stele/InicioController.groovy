package com.stele

class InicioController {

  def datosEscolaresWrapperService
  def datosEscolaresDomainWrapperService
  def estructuraInstitucionalService
  def reporteMigracionService

  def index() {
    [:]
  }

  def preview(){
    FileInputStream excelParaProcesar = params.datosEscolares.inputStream
    def listaDeCommands = datosEscolaresWrapperService.obtenerFilasExcelCommandsDesdeArchivo(excelParaProcesar)
    def listaDeMapaDeDominios = datosEscolaresDomainWrapperService.obtenerListaDeMapasDesdeListaDeCommands(listaDeCommands)
    flash.listaDeMapaDeDominios = listaDeMapaDeDominios
    def estructuraInstitucional = estructuraInstitucionalService.obtenerEstructuraDesdeListaDeMapaDeDominios(listaDeMapaDeDominios)
    def conteosDeEstructuraInstitucional = reporteMigracionService.conteoDeDependientesParaElNivel(estructuraInstitucional,NivelInstitucional.TURNO)
    
    [
      conteosDeEstructuraInstitucional:conteosDeEstructuraInstitucional,
      estructuraInstitucional:estructuraInstitucional,
      listaDeMapaDeDominios:listaDeMapaDeDominios
    ]
  }

  def upload(){
    log.debug params
  }
}
