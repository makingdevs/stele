package com.stele

class EstructuraInstitucionalService {

  def obtenerEstructuraDesdeListaDeMapaDeDominios(listaMapaDominios) {
    def estructuraOrganizacional = []
    
    listaMapaDominios.each { filaDominio ->
      def cicloEscolarEncontrado = estructuraOrganizacional.find {
        it.find { k, v -> k == filaDominio.cicloEscolar.clave }
      }

      if(cicloEscolarEncontrado) {
        log.debug cicloEscolarEncontrado."2011-12"
        def nivelEstudioEncontrado = cicloEscolarEncontrado."${filaDominio.cicloEscolar.clave}".find { k, v ->
          k == filaDominio.distribucionInstitucional.nivelDeEstudio.key
        }
        log.debug nivelEstudioEncontrado
      }

      String clave = filaDominio.cicloEscolar.clave
      String nivelDeEstudio = filaDominio.distribucionInstitucional.nivelDeEstudio.key

      def mapa =[:]
      mapa."$clave" = []
      mapa."$clave" = [ "$nivelDeEstudio" : []]

      estructuraOrganizacional << mapa
    }

    estructuraOrganizacional
  }
}
