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

   // def pagosGenerados = generacionDePagoService.paraCamadaPagoCommand(cpc)
    //render template:"listaDePagosGenerados", model:[pagosGenerados : pagosGenerados]
    render "Hola Mundo"
  }

}
