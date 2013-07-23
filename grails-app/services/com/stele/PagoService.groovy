package com.stele

import com.stele.seguridad.Usuario;
import com.stele.DistribucionInstitucional;
import com.stele.HistorialAcademico;
import com.stele.Pago;

class PagoService {

  def obtenerPagosDeUsuario(Usuario usuario) {
    def criteriaDependiente = Dependiente.createCriteria()
    def pagosDeUsuario = [] as Set 
    List<Dependiente> dependientesDeUsuario = criteriaDependiente.list {
        eq("usuario", usuario)
    }
    dependientesDeUsuario.each{ dependiente ->
      Dependiente dependienteExistente = dependiente.get(dependiente.id)
      pagosDeUsuario.addAll(dependienteExistente.pagos)
    }
    pagosDeUsuario
  }

  def obtenerPagosXInstitucion(Usuario usuario) {
    def institucionUsuario = usuario.instituciones
    def distribucionInstitucional = DistribucionInstitucional.withCriteria {
      'in'('institucion', institucionUsuario)
    }
    def historialAcademico = HistorialAcademico.withCriteria {
      'in'('distribucionInstitucional', distribucionInstitucional)
    }
    def pagos = Pago.withCriteria {
      'in'('historialAcademico', historialAcademico)
    }
    pagos
  }

  Pago obtenerPagoParaValidarComprobante(Long pagoId) {
    Pago.findById(pagoId,[fetch:['comprobanteDePago':'join']])
  }

}
