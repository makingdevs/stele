package com.stele

class InicioController {

  def datosEscolaresWrapperService
  def datosEscolaresDomainWrapperService
  //def estructuraInstitucionalService

  def index() {
    [:]
  }

  def preview(){
    FileInputStream excelParaProcesar = params.datosEscolares.inputStream
    def listaDeCommands = datosEscolaresWrapperService.obtenerFilasExcelCommandsDesdeArchivo(excelParaProcesar)
    def listaDeMapaDeDominios = datosEscolaresDomainWrapperService.obtenerListaDeMapasDesdeListaDeCommands(listaDeCommands)
    //def estructuraInstitucional = estructuraInstitucionalService.obtenerEstructuraDesdeListaDeMapaDeDominios(listaDeMapaDeDominios)
    //[estructuraInstitucional:estructuraInstitucional,listaDeMapaDeDominios:listaDeMapaDeDominios]
    [listaDeMapaDeDominios:listaDeMapaDeDominios]
  }

  def upload(){
    log.debug params
  }
}
