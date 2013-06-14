package com.stele

import com.stele.seguridad.Usuario


class DatosEscolaresDomainWrapperService {

  def usuarioService
  def dependienteService
  def cicloEscolarService
  def distribucionInstitucionalService

  def obtenerListaDeMapasDesdeListaDeCommands(List filaExcelCommand){ 
    def listaDeMapasDomain = []

    filaExcelCommand.each{
      def mapaDomains = [usuario:usuarioService.obtenerUsuarioDesdeCommand(it),
                         dependiente:dependienteService.obtenerDependienteDesdeCommand(it),
                         cicloEscolar:cicloEscolarService.obtenerCicloEscolarDesdeCommand(it),
                         distribucionInstitucional:distribucionInstitucionalService.obtenerDistribucionInstitucionalDesdeCommand(it)
                        ]
      listaDeMapasDomain.add(mapaDomains)
    }
    listaDeMapasDomain
  }



}
