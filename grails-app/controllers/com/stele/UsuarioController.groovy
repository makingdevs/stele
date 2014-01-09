package com.stele

import com.stele.seguridad.Usuario

class UsuarioController {

  static scaffold = Usuario
  
  def searchableService

  def buscarTutorInscripcion(){
  	def searchResult = searchableService.search(params.nombreTutorBusqueda)
  	def resultados = []
    searchResult.results.each{ row ->
      if (row instanceof Usuario)
        resultados.add(row)
    }
  	render template:'/inscripcionManual/listaTutores', model:[tutor: resultados]
  }

}
