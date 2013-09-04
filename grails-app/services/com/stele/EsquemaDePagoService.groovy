package com.stele

class EsquemaDePagoService {

  def obtenerEsquemaDePago(Long esquemaDePagoServiceId) {
    EsquemaDePago.get(esquemaDePagoServiceId)
  }

  def obtenerCantidadDeDescuentoAplicable(Long esquemaDePagoServiceId) {
    300
  }
}
