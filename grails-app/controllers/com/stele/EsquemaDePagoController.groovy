package com.stele

import grails.converters.JSON
import com.payable.*


class EsquemaDePagoController {

  def springSecurityService
  def generacionDePagoService
  def wrapperCommandService

  def scaffold = EsquemaDePago
 
  def paraCamada() {
    [camada:params?.camada]
  }

  def generarPagoParaLaCamada(CamadaPagoCommand cpc) {
    if(cpc.hasErrors()) {
      render cpc.errors
      return
    } 
    def grupoPagoCommand = wrapperCommandService.generarParseoDeCamadaPagoCommandAGrupoPagoCommand(cpc, springSecurityService.currentUser.instituciones?.first())
    def pagos = generacionDePagoService.generaPagoParaGrupo(grupoPagoCommand)
    flash.pago = pagos
    flash.success = "Bien Hecho"
    redirect action:"muestraPagosDeCamada",params: params + [camada:cpc.camada]
  }

  def muestraPagosDeCamada(){
    def listaPagos = Pago.findAllByIdInList(flash.pago*.id)
    render(view: "generarPagosParaLaCamada", model: [pagos: listaPagos])
  }

}
