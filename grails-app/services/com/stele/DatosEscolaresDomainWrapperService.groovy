package com.stele

import com.stele.seguridad.Usuario


class DatosEscolaresDomainWrapperService {

  def usuarioService
  def dependienteService
  def cicloEscolarService
  def distribucionInstitucionalService

  def obtenerListaDeMapasDesdeListaDeCommands(List filaExcelCommand){ 
    def lista = []

    filaExcelCommand.each{
      def mapa = [usuario:usuarioService.obtenerUsuarioDesdeCommand(it),
                  dependiente:dependienteService.obtenerDependienteDesdeCommand(it),
                  cicloEscolar:cicloEscolarService.obtenerCicloEscolarDesdeCommand(it),
                  distribucionInstitucional:distribucionInstitucionalService.obtenerDistribucionInstitucionalDesdeCommand(it)
                 ]
      lista.add(mapa)
    }

    lista
  }



}
