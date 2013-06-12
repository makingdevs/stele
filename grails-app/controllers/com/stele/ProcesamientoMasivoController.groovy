package com.stele

class ProcesamientoMasivoController {

  def procesamientoMasivoService

  def index() {
    log.debug "Persistiendo información de archivo excel..."
    def listaDeMapaDeDominios = flash.listaDeMapaDeDominios
    listaDeMapaDeDominios.each { l ->
      procesamientoMasivoService.procesaMapaConDatosDeFilaDeExcelParaPersistir(l,params.long("institucionId") )
    }
    log.debug "Se persistió archivo excel correctamente..."
  }
}
