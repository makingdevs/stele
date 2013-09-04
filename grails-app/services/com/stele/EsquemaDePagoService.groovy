package com.stele

class EsquemaDePagoService {

  def obtenerEsquemaDePago(Long esquemaDePagoServiceId) {
    EsquemaDePago.get(esquemaDePagoServiceId)
  }

  def obtenerCantidadDeDescuentoAplicable(Long esquemaDePagoServiceId) {
    log.debug "Obteniendo descuentos"
    EsquemaDePago.get(esquemaDePagoServiceId).descuentos.collect { d ->
      d.cantidad
    }.sum()
  }
}
