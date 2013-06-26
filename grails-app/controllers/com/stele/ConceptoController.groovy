package com.stele

class ConceptoController {

  def springSecurityService

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

}

class ConceptoCommand {

  String concepto

  static constraints = {
    concepto nullable:false
  }

}
