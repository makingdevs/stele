package com.stele

import com.stele.seguridad.Usuario
import com.stele.Descuento
import com.stele.Institucion

class DescuentoService {

  def buscarDescuentosDeUnaInstitucion(Usuario usuario, def query) {

    def institucion = usuario.instituciones
    Descuento .withCriteria {
      like('nombreDeDescuento', "%${query}%" )
      'in'('institucion', institucion) 
    }
  }

  def esDescuentoActivo(Date fechaVencimientoPago, Descuento descuento) {
    def fechaVencimientoDescuento = (fechaVencimientoPago + descuento.diasPreviosParaCancelarDescuento)
    (new Date().clearTime() == fechaVencimientoDescuento)
  }

  def obtenerMontoTotalDescuentoVencido(Descuento descuento, def cantidadDePago) {
    descuento?.cantidad + ((descuento?.porcentaje / 100) * cantidadDePago)
  }

}