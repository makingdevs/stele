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
    def user = springSecurityService.currentUser
    def principal = springSecurityService.principal
    [instituciones:user.instituciones, usuario:user,inscripcionCobro:params.cobro]
  }
  
  def deleteFile(){    
    flash.excelParaProcesar = null
    render ""
  }

  def upload(){
    FileInputStream excelParaProcesar = params.datosEscolares.inputStream
    flash.excelParaProcesar = excelParaProcesar
    render ""
  }

  def preview(){
    try {      
      def listaDeCommands = datosEscolaresWrapperService.obtenerFilasExcelCommandsDesdeArchivo(flash.excelParaProcesar)      
      def listaDeMapaDeDominios = datosEscolaresDomainWrapperService.obtenerListaDeMapasDesdeListaDeCommands(listaDeCommands)      
      session['listaDeMapaDeDominios'] = listaDeMapaDeDominios
      
      def estructuraInstitucional = estructuraInstitucionalService.obtenerEstructuraDesdeListaDeMapaDeDominios(listaDeMapaDeDominios)
      [
        alumnosPorNivel:reporteMigracionService.conteoDeDependientesParaElNivel(estructuraInstitucional,NivelInstitucional.NIVEL),
        alumnosPorGrado:reporteMigracionService.conteoDeDependientesParaElNivel(estructuraInstitucional,NivelInstitucional.GRADO),
        alumnosPorTurno:reporteMigracionService.conteoDeDependientesParaElNivel(estructuraInstitucional,NivelInstitucional.TURNO),
        estructuraInstitucional:estructuraInstitucional,
        listaDeMapaDeDominios:listaDeMapaDeDominios,
        institucionId: params.long("institucionId"),
        inscripcionCobro:params.cobro
      ]      
    } catch(Exception ex){
      if(!flash.excelParaProcesar)
        flash.error = "No existe un archivo para procesar !!"
      else  
        flash.error = "Por favor validar el archivo que se esta procesando"

      redirect (controller: "inicio", action: "index")
    }
  }

  def procesar(){
    [institucionId: params.long("institucionId"),
     inscripcionCobro:params.cobro]
  }
}
