package stele

import com.payable.Pago
import com.stele.Dependiente
import com.stele.HistorialAcademico

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

  def ubicacionDependiente = { attrs, body ->
    def dependiente = Dependiente.findById(attrs.idDependiente)
    def historialAcademico = HistorialAcademico.findByDependiente(dependiente)
    out << historialAcademico.distribucionInstitucional.grado
    out << ' '
    out << historialAcademico.distribucionInstitucional.grupo
  }

  def turnoDependiente = { attrs, body ->
    def dependiente = Dependiente.findById(attrs.idDependiente)
    def historialAcademico = HistorialAcademico.findByDependiente(dependiente)
    out << historialAcademico.distribucionInstitucional.turno
  }
}
