package com.stele

class EstructuraInstitucionalService {

  def obtenerEstructuraDesdeListaDeMapaDeDominios(listaMapaDominios) {
    def mapa = [:]
    
    listaMapaDominios.each { filaDominio ->

      if( mapa."$filaDominio.cicloEscolar.clave" ) {
        if( mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key" ) {
          if( mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key"."$filaDominio.distribucionInstitucional.grado" ) {
            if( mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key"."$filaDominio.distribucionInstitucional.grado"."$filaDominio.distribucionInstitucional.turno.key" ) {
              if( mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key"."$filaDominio.distribucionInstitucional.grado"."$filaDominio.distribucionInstitucional.turno.key"."$filaDominio.distribucionInstitucional.grupo" ) {
                mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key"."$filaDominio.distribucionInstitucional.grado"."$filaDominio.distribucionInstitucional.turno.key"."$filaDominio.distribucionInstitucional.grupo" << filaDominio.dependiente
                return mapa
              } else {
                mapa."$filaDominio.cicloEscolar.clave"."$filaDominio.distribucionInstitucional.nivelDeEstudio.key"."$filaDominio.distribucionInstitucional.grado"."$filaDominio.distribucionInstitucional.turno.key" << [(filaDominio.distribucionInstitucional.grupo) : [filaDominio.dependiente]]
                return mapa
              }
            } else {
              mapa.(filaDominio.cicloEscolar.clave).(filaDominio.distribucionInstitucional.nivelDeEstudio.key).(filaDominio.distribucionInstitucional.grado) << [(filaDominio.distribucionInstitucional.turno.key) : [(filaDominio.distribucionInstitucional.grupo) : [filaDominio.dependiente]]]
              return mapa
            }
          } else {
            mapa.(filaDominio.cicloEscolar.clave).(filaDominio.distribucionInstitucional.nivelDeEstudio.key) << [(filaDominio.distribucionInstitucional.grado.toString()) : [(filaDominio.distribucionInstitucional.turno.key) : [(filaDominio.distribucionInstitucional.grupo) : [filaDominio.dependiente]]]]
            return mapa
          }
        } else {
          mapa.(filaDominio.cicloEscolar.clave) << [(filaDominio.distribucionInstitucional.nivelDeEstudio.key) : [(filaDominio.distribucionInstitucional.grado.toString()) : [(filaDominio.distribucionInstitucional.turno.key) : [(filaDominio.distribucionInstitucional.grupo) : [filaDominio.dependiente]]]]]
          return mapa
        }
      }

      log.debug "No existe clave"

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
