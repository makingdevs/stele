package stele

import com.payable.Pago
import com.stele.Dependiente

class DependienteTagLib {

  def nombreDependiente = { attrs, body ->
    def pago = Pago.findById(attrs.idPago)
    def dependiente = Dependiente.withCriteria{
      pagos{
        eq('id', pago.id)
      }
    }
    out << dependiente.perfil.first().nombre
    out << ' ' 
    out <<  dependiente.perfil.first().apellidoPaterno 
    out << ' ' 
    out <<  dependiente.perfil.first().apellidoMaterno
  }

}
