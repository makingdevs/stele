package stele

import com.payable.Descuento

class DescuentosTagLib {

  def mostrarCantidadTotal = { attrs, body ->
    def descuentos = Descuento.findAllByIdInList(attrs.idsDescuentos)
    def porcentaje = 0
    def cantidad = 0
    descuentos.each{ descuento ->
      porcentaje += descuento.porcentaje ?: 0
      cantidad += descuento.cantidad ?: 0
    }
    if (porcentaje > 0)
      porcentaje = porcentaje/100*attrs.cantidadDePago
    out << cantidad + porcentaje
  } 

}
