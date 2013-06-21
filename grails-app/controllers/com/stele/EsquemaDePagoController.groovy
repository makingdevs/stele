package com.stele

class EsquemaDePagoController {

  def paraCamada() {
    [camada:params?.camada]
  }

  def generarPagoParaLaCamada(CamadaPagoCommand cpc) {
    if(cpc.hasErrors()) {
      render cpc.errors
      return
    }
  }

}
