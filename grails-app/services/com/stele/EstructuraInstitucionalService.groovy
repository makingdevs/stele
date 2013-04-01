package com.stele

class EstructuraInstitucionalService {

  def obtenerEstructuraDesdeListaDeMapaDeDominios(listaMapaDominios) {
    def mapa = [:]
    
    listaMapaDominios.each { filaDominio ->

      if( mapa."$filaDominio.cicloEscolar.clave" ) {
        log.debug "existe clave"
        if( mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key" ) {
          log.debug "existe nivelDeEstudio"
          if( mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key"."$filaDominio.distribucionInstitucional.grado" ) {
            log.debug "existe grado"
            if( mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key"."$filaDominio.distribucionInstitucional.grado"."$filaDominio.distribucionInstitucional.turno.key" ) {
              log.debug "existe turno"
              if( mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key"."$filaDominio.distribucionInstitucional.grado"."$filaDominio.distribucionInstitucional.turno.key"."$filaDominio.distribucionInstitucional.grupo" ) {
                mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key"."$filaDominio.distribucionInstitucional.grado"."$filaDominio.distribucionInstitucional.turno.key"."$filaDominio.distribucionInstitucional.grupo" << filaDominio.dependiente
                return mapa
              }
              else {
                mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key"."$filaDominio.distribucionInstitucional.grado"."$filaDominio.distribucionInstitucional.turno.key" << [(filaDominio.distribucionInstitucional.grupo) : [filaDominio.dependiente]]
                return mapa
              }
            }
          }
        }
      }

      mapa.(filaDominio.cicloEscolar.clave) = [ 
                    (filaDominio.distribucionInstitucional.nivelDeEstudio.key) : [
                      (filaDominio.distribucionInstitucional.grado.toString()) : [
                        (filaDominio.distribucionInstitucional.turno.key) : [
                          (filaDominio.distribucionInstitucional.grupo) : [
                            "${filaDominio.dependiente}"
                          ]
                        ]
                      ]
                    ]
                  ] 
    }

    mapa
  }
}
