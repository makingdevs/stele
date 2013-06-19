package com.stele

class EsquemaDePagoController {

  def paraCamada() {
    [camada:params.camada]
  }

  def generarPagoParaLaCamada(EsquemaDePagoCommand edpc) {
    if(edpc.hasErrors()) {
      render edpc.errors
      return
    }
  }

}

class EsquemaDePagoCommand {

  String camada
  String concepto
  BigDecimal monto

  static constraints = {
    camada size:1..100, blank:false, nullable:false
    concepto size:1..150, blank:false, nullable:false
    monto min:1.0, nullable:false
  }

}
