package com.stele

class ProcesamientoMasivoController {

  def procesamientoMasivoService

  def index() {
    def listaDeMapaDeDominios = flash.listaDeMapaDeDominios
    listaDeMapaDeDominios.each { l ->
      procesamientoMasivoService.procesaMapaConDatosDeFilaDeExcelParaPersistir(l,params.long("institucionId") )
    }
  }
}
