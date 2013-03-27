package com.stele

class EstructuraInstitucionalService {

  def obtenerEstructuraDesdeListaDeMapaDeDominios(listaMapaDominios) {
    def estructuraOrganizacional = []
    
    listaMapaDominios.each { filaDominio ->

    def encontrado = estructuraOrganizacional*.find { k, v ->
      k == filaDominio.cicloEscolar.clave
    }

    log.debug encontrado.class
    encontrado.each {
      log.debug it
    }

      def mapa = [
                   "${filaDominio.cicloEscolar.clave}" : [ 
                     "${filaDominio.distribucionInstitucional.nivelDeEstudio.key}" : [
                       "${filaDominio.distribucionInstitucional.grado}" : [
                         "${filaDominio.distribucionInstitucional.turno.key}" : [
                           "${filaDominio.distribucionInstitucional.grupo}" : [
                             "${filaDominio.dependiente}"
                           ]
                         ]
                       ]
                     ]
                   ] 
                 ]

      estructuraOrganizacional << mapa
    }

    estructuraOrganizacional
  }

}
