package com.stele

class InicioController {

  def springSecurityService
  def datosEscolaresWrapperService
  def datosEscolaresDomainWrapperService
  def estructuraInstitucionalService
  def reporteMigracionService

  static allowedMethods = [deleteFile:"POST"]

  def index() {
    if (!springSecurityService.isLoggedIn()) {
      redirect controller:'login'
      return
    }
    flash.inscripcionCobro = params.cobro
    def user = springSecurityService.currentUser
    def principal = springSecurityService.principal
    [instituciones:user.instituciones, usuario:user]
  }
  
  def deleteFile(){    
    session.removeAttribute('excelParaProcesar')
    render ""
  }

  def upload(){
    FileInputStream excelParaProcesar = params.datosEscolares.inputStream
    session.excelParaProcesar = excelParaProcesar    
    render ""
  }

  def preview(){
    try {      
      def listaDeCommands = datosEscolaresWrapperService.obtenerFilasExcelCommandsDesdeArchivo(session.excelParaProcesar)
      session.removeAttribute('excelParaProcesar')
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
    } catch(Exception ex){
      if(!session.excelParaProcesar)
        flash.error = "No existe un archivo para procesar !!"
      else  
        flash.error = "Por favor validar el archivo que se esta procesando"

      redirect (controller: "inicio", action: "index")
    }
  }

  def procesar(){
    flash.inscripcionCobro = params.cobro
    def lista = flash.listaDeMapaDeDominios
    flash.listaDeMapaDeDominios = lista
    [institucionId: params.long("institucionId")]
  }
}
