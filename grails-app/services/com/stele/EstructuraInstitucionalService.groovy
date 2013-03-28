package com.stele

class EstructuraInstitucionalService {

  def obtenerEstructuraDesdeListaDeMapaDeDominios(listaMapaDominios) {
    def estructuraOrganizacional = []
    
    listaMapaDominios.each { filaDominio ->
      def cicloEscolarEncontrado = estructuraOrganizacional.find {
        it.find { k, v -> k == filaDominio.cicloEscolar.clave }
      }

      if(cicloEscolarEncontrado) {
        log.debug "cicloEscolarEncontrado : $cicloEscolarEncontrado"
        log.debug "clave : ${filaDominio.cicloEscolar.clave}"

        log.debug cicloEscolarEncontrado."2011-12"


        def nivelEstudioEncontrado = cicloEscolarEncontrado."${filaDominio.cicloEscolar.clave}".find { k, v ->
          log.debug "k : $k"
          log.debug "filaDominio.distribucionInstitucional.nivelDeEstudio.key : ${filaDominio.distribucionInstitucional.nivelDeEstudio.key}"
          k == filaDominio.distribucionInstitucional.nivelDeEstudio.key
        }
        log.debug nivelEstudioEncontrado
      }
      
      String clave = filaDominio.cicloEscolar.clave

      def mapa =[ "$clave" : [
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
