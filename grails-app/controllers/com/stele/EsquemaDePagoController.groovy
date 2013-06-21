package com.stele

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

    def pagos = generacionDePagoService.paraCamadaPagoCommand(cpc)
    [pagos:pagos]
  }

}
