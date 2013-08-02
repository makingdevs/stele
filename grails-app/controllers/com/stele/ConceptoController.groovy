package com.stele

import com.stele.Concepto
import grails.converters.JSON

class ConceptoController {

  def springSecurityService
  def conceptoService

  static allowedMethods = [obtenerListaconceptos : 'GET']

  def index() { }

  def nuevo(ConceptoCommand cmd) {
    if(cmd.hasErrors()) {
      render cmd.errors
      return 
    }

    Concepto concepto = new Concepto(cmd.params)
    concepto.institucion = springSecurityService.currentUser.instituciones?.first()
    concepto.save(flush:true)
    concepto
  }

  def obtenerListaConceptos() {
    def contactList = conceptoService.buscarConceptosDeUnaInstitucion(springSecurityService.currentUser,params.query )
    JSON.use('stele') {
      render contactList as JSON
    }
  }

}


class ConceptoCommand {

  String concepto

  static constraints = {
    concepto nullable:false
  }

}
