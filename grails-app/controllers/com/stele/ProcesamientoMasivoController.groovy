package com.stele

class ProcesamientoMasivoController {

  def procesamientoMasivoService

  def index() {
    def listaDeMapaDeDominios = flash.listaDeMapaDeDominios
    listaDeMapaDeDominios*.dependiente*.camada = Institucion.get(params?.long("institucionId")).nombre.replaceAll(" ","_") + new Date().format("dd_MM_yy_HH_mm")
    listaDeMapaDeDominios.each { l ->
      procesamientoMasivoService.procesaMapaConDatosDeFilaDeExcelParaPersistir(l,params.long("institucionId") )
    }
  }
}
