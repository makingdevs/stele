package com.stele

class InicioController {

  def springSecurityService
  def datosEscolaresWrapperService
  def datosEscolaresDomainWrapperService
  def estructuraInstitucionalService
  def reporteMigracionService

  def index() {
    if (!springSecurityService.isLoggedIn()) {
      redirect controller:'login'
      return
    }
    def user = springSecurityService.currentUser
    def principal = springSecurityService.principal
    [instituciones:user.instituciones]
  }

  def preview(){
    FileInputStream excelParaProcesar = params.datosEscolares.inputStream
    def listaDeCommands = datosEscolaresWrapperService.obtenerFilasExcelCommandsDesdeArchivo(excelParaProcesar)
    def listaDeMapaDeDominios = datosEscolaresDomainWrapperService.obtenerListaDeMapasDesdeListaDeCommands(listaDeCommands)
    flash.listaDeMapaDeDominios = listaDeMapaDeDominios
    def estructuraInstitucional = estructuraInstitucionalService.obtenerEstructuraDesdeListaDeMapaDeDominios(listaDeMapaDeDominios)
    
    [
      alumnosPorNivel:reporteMigracionService.conteoDeDependientesParaElNivel(estructuraInstitucional,NivelInstitucional.NIVEL),
      alumnosPorGrado:reporteMigracionService.conteoDeDependientesParaElNivel(estructuraInstitucional,NivelInstitucional.GRADO),
      alumnosPorTurno:reporteMigracionService.conteoDeDependientesParaElNivel(estructuraInstitucional,NivelInstitucional.TURNO),
      estructuraInstitucional:estructuraInstitucional,
      listaDeMapaDeDominios:listaDeMapaDeDominios,
      institucionId: params.long("institucionId")
    ]
  }

  def upload(){
    log.debug params
  }
}
