package com.stele

import grails.converters.JSON

class EsquemaDePagoController {

  def generacionDePagoService

  def paraCamada() {
    [camada:params?.camada]
  }

  def generarPagoParaLaCamada(CamadaPagoCommand cpc) {
    if(cpc.hasErrors()) {
      render cpc.errors
      return
    } 
    
    def pagosGenerados = generacionDePagoService.paraCamadaPagoCommand(cpc)
    flash.success = "Bien Hecho"
    render(view: "generarPagosParaLaCamada", model: [pagosCamada: pagosGenerados])
  }

}
