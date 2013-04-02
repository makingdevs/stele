package com.stele

class EstructuraInstitucionalService {

  def obtenerEstructuraDesdeListaDeMapaDeDominios(listaMapaDominios) {
    def mapa = [:]
    
    listaMapaDominios.each { filaDominio ->

      String clave = filaDominio.cicloEscolar.clave
      String nivelDeEstudio = filaDominio.distribucionInstitucional.nivelDeEstudio.toString().toUpperCase()
      String grado = filaDominio.distribucionInstitucional.grado.toString()
      String turno = filaDominio.distribucionInstitucional.turno.toString().toUpperCase()
      String grupo = filaDominio.distribucionInstitucional.grupo

      if( mapa."$clave" ) {
        if( mapa."$clave"."$nivelDeEstudio" ) {
          if( mapa."$clave"."$nivelDeEstudio"."$grado" ) {
            if( mapa."$clave"."$nivelDeEstudio"."$grado"."$turno" ) {
              if( mapa."$clave"."$nivelDeEstudio"."$grado"."$turno"."$grupo" ) {
                mapa."$clave"."$nivelDeEstudio"."$grado"."$turno"."$grupo" << filaDominio.dependiente
                return mapa
              } else {
                mapa."$clave"."$nivelDeEstudio"."$grado"."$turno" << [(grupo) : [filaDominio.dependiente]]
                return mapa
              }
            } else {
              mapa."$clave"."$nivelDeEstudio"."$grado" << [(turno) : [(grupo) : [filaDominio.dependiente]]]
              return mapa
            }
          } else {
            mapa."$clave"."$nivelDeEstudio" << [(grado) : [(turno) : [(grupo) : [filaDominio.dependiente]]]]
            return mapa
          }
        } else {
          mapa."$clave" << [(nivelDeEstudio) : [(grado) : [(turno) : [(grupo) : [filaDominio.dependiente]]]]]
          return mapa
        }
      }

      mapa."$clave" = [
        (nivelDeEstudio) : [
          (grado) : [
            (turno) : [
              (grupo) : [
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
