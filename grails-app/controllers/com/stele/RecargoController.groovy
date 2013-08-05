package com.stele

import com.stele.Recargo

class RecargoController {

  def springSecurityService

  def nuevo(){
    log.debug "params : $params"

    Recargo recargo = new Recargo(params)
    recargo.institucion = springSecurityService.currentUser.instituciones?.first()  
    recargo.save(flush:true)
    log.debug "recargo : $recargo"
    recargo
  }
  
}