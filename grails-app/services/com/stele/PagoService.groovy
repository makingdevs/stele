package com.stele

import com.stele.seguridad.Usuario
import com.stele.DistribucionInstitucional

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
      distribucionInstitucional
    }


}
