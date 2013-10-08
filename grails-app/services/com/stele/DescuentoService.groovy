package com.stele

import com.stele.seguridad.Usuario
import com.payable.*

class DescuentoService {

  def buscarDescuentosDeUnaInstitucion(Usuario usuario, def query) {

    def institucion = usuario.instituciones
    Descuento .withCriteria {
      like('nombreDeDescuento', "%${query}%" )
      'in'('institucion', institucion) 
    }
  }

}