package com.stele

import com.stele.seguridad.Usuario
import com.stele.Concepto
import com.stele.Institucion

class ConceptoService {

  def buscarConceptosDeUnaInstitucion(Usuario usuario, def query) {
      def institucion = usuario.instituciones
      Concepto.withCriteria {
        like('concepto', "%${query}%" )
        'in'('institucion', institucion)
      }
  }

}