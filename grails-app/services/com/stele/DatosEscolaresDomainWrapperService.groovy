package com.stele


class DatosEscolaresDomainWrapperService {

  def usuarioService

  def obtenerListaDeMapasDesdeListaDeCommands(List filaExcelCommand){
    def listaUsuario = []
    def listaDependiente = []
    def listaCicloEscolar = []
    def listaDistribucionInstitucional = []
    filaExcelCommand.each{
      listaUsuario.add( usuarioService.obtenerUsuarioDesdeCommand(it) )
    }
    [usuario:listaUsuario]
  }



}
