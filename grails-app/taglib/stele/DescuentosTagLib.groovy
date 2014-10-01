package stele

import com.payable.Discount
import java.text.DecimalFormat

class DescuentosTagLib {

  def mostrarCantidadTotal = { attrs, body ->
    def discounts = Discount.findAllByIdInList(attrs.idsDescuentos)
    def porcentaje = 0
    def cantidad = 0
    discounts.each{ discount ->
      porcentaje += discount.percentage ?: 0
      cantidad += discount.amount ?: 0
    }

    if (porcentaje > 0){
      porcentaje = (porcentaje/100)*attrs.cantidadDePago
      cantidad+=porcentaje
    }

    out << new DecimalFormat("#,###,###").format(cantidad)

  } 

}
