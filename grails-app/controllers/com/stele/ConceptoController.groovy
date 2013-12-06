package com.stele

import com.payable.*
import grails.converters.JSON

class ConceptoController {

  def scaffold = Concepto

  def springSecurityService
  def conceptoService

  static allowedMethods = [obtenerListaConceptos : 'GET']

  def nuevo(ConceptoCommand cmd) {
    if(cmd.hasErrors()) {
      render cmd.errors
      return 
    }

    Concepto concepto = new Concepto(cmd.params)
    concepto.organizacion = springSecurityService.currentUser.instituciones?.first()
    concepto.save(flush:true)
    concepto
  }

  def obtenerListaConceptos() {
    def contactList = conceptoService.buscarConceptosDeUnaInstitucion(springSecurityService.currentUser.instituciones.first(),params.query )
    JSON.use('stele') {
      render contactList as JSON
    }
  }

}


class ConceptoCommand {

  String descripcion

  static constraints = {
    descripcion nullable:false
  }

}
