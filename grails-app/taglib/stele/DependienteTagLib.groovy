package stele

import com.payable.Payment
import com.stele.Dependiente
import com.stele.HistorialAcademico

class DependienteTagLib {

  def dependienteService

  def nombreDependiente = { attrs, body ->

    def dependiente = dependienteService.findDependienteFromPaymentId(attrs.idPago)
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
    out << ' '
    out << historialAcademico.distribucionInstitucional.nivelDeEstudio
  }

  def turnoDependiente = { attrs, body ->
    def dependiente = Dependiente.findById(attrs.idDependiente)
    def historialAcademico = HistorialAcademico.findByDependiente(dependiente)
    out << historialAcademico.distribucionInstitucional.turno
  }
}
