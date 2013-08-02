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

  def guardarConceptoDePagoGenerado(Usuario usuario, String conc) {
  	def conceptoExistente = Concepto.findByConcepto(conc)
  	if (!conceptoExistente){
	  	Concepto concepto = new Concepto()
	  	concepto.concepto = conc
	    concepto.institucion = usuario.instituciones?.first()
	    concepto.save(flush:true)
	    concepto
	}
  }

}