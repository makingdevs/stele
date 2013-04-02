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

      def llaves = [clave, nivelDeEstudio, grado, turno, grupo, filaDominio.dependiente]

      return iterarEstructuraInstitucional(mapa, llaves)
    }

    mapa
  }
  
  def iterarEstructuraInstitucional(mapa, llaves, indice = 0){
    if( indice == llaves.size() - 1 ) {
      mapa << llaves[indice]
      return mapa
    }

    if(!mapa.containsKey(llaves[indice])) {
      mapa << crearEstructuraFaltanteDeLaInstitucion( llaves[ indice .. llaves.size() - 1] )
      return mapa
    }    

    iterarEstructuraInstitucional(mapa."${llaves[indice]}", llaves, indice+1)
    return mapa
  }

  def crearEstructuraFaltanteDeLaInstitucion(estructura, indice = 0, mapa = [:]) {
    if( indice == estructura.size() - 1 )
      return [estructura[indice]]

    mapa."${estructura[indice]}" = crearEstructuraFaltanteDeLaInstitucion(estructura, indice + 1)
    mapa
  }
}
