package com.stele

import com.stele.seguridad.Usuario
import com.stele.Descuento
import com.stele.Institucion

class DescuentoService {

  def buscarDescuentosDeUnaInstitucion(Usuario usuario) {
    def institucion = usuario.instituciones
    Descuento .withCriteria {
      'in'('institucion', institucion) 
    }
  }

}