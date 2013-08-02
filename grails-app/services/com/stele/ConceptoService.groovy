package com.stele

import com.stele.seguridad.Usuario
import com.stele.Concepto
import com.stele.Institucion

class ConceptoService {

  static transactional = true

  def buscarConceptosDeUnaInstitucion(Usuario usuario, def query) {
    def institucion = usuario.instituciones
    Concepto.withCriteria {
      like('concepto', "%${query}%" )
      'in'('institucion', institucion)
    }
  }

  def guardarConceptoDePagoGenerado(Usuario usuario, String descripcionDeConcepto) {
  	def conceptoExistente = Concepto.findByConcepto(descripcionDeConcepto)
  	if (!conceptoExistente){
      Concepto concepto = new Concepto()
      concepto.concepto = descripcionDeConcepto
      concepto.institucion = usuario.instituciones?.first()
      concepto.save()
      concepto
    }
  }

}