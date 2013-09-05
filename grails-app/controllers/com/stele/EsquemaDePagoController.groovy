package com.stele

import grails.converters.JSON


class EsquemaDePagoController {

  def springSecurityService
  def generacionDePagoService
 
  def paraCamada() {
    [camada:params?.camada]
  }

  def generarPagoParaLaCamada(CamadaPagoCommand cpc) {
    if(cpc.hasErrors()) {
      render cpc.errors
      return
    } 

    def pagos = generacionDePagoService.paraCamadaPagoCommand(cpc)
    flash.pago = pagos
    flash.success = "Bien Hecho"
    redirect action:"muestraPagosDeCamada",params: params + [camada:cpc.camada]
  }

  def muestraPagosDeCamada(){
    def listaPagos = Pago.findAllByIdInList(flash.pago*.id)
    render(view: "generarPagosParaLaCamada", model: [pagos: listaPagos])
  }

}
