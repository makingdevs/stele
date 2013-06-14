package com.stele

class ProcesamientoMasivoController {

  def procesamientoMasivoService

  def index() {
    def listaDeMapaDeDominios = flash.listaDeMapaDeDominios
    //TODO: Camada = nombre de institucion, reemplazar espacion por _ + fecha separada por _ (DD_MM_YY_HH_MM)
    Institucion institucion = Institucion.get(params.long("institucionId"))
    listaDeMapaDeDominios*.dependiente*.camada = institucion.nombre
    listaDeMapaDeDominios.each { l ->
      //procesamientoMasivoService.procesaMapaConDatosDeFilaDeExcelParaPersistir(l,params.long("institucionId") )
      log.debug "Camada: " + l.dependiente.camada 
    }
  }
}
