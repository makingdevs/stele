package com.stele

class ProcesamientoMasivoController {

  def index() {
    def listaDeMapaDeDominios = flash.listaDeMapaDeDominios
    listaDeMapaDeDominios.each { l ->
      procesamientoMasivoService.procesaMapaConDatosDeFilaDeExcelParaPersistir(l)     
    }
  }
}
