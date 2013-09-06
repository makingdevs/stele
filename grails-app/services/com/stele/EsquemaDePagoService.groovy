package com.stele

class EsquemaDePagoService {

  def obtenerEsquemaDePago(Long esquemaDePagoServiceId) {
    EsquemaDePago.get(esquemaDePagoServiceId)
  }

  def obtenerCantidadDeDescuentoAplicable(Long esquemaDePagoServiceId) {
    def esquemaDePago = EsquemaDePago.get(esquemaDePagoServiceId)
    esquemaDePago.descuentos.collect { d ->
      if(d.cantidad)
        d.cantidad
      else
        esquemaDePago.cantidadDePago * d.porcentaje/100
    }.sum()
  }
}
