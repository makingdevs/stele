package com.stele

import com.stele.Recargo

class RecargoController {

  def scaffold = Recargo

  def springSecurityService

  def nuevo(){
    log.debug "params : $params"

    Recargo recargo = new Recargo(params)
    recargo.institucion = springSecurityService.currentUser.instituciones?.first()  
    recargo.save(flush:true)
    log.debug "recargos : $recargo.id"
    render template:"/recargo/list", model:[recargos:recargo, recargoId:recargo.id]
  }
  
}