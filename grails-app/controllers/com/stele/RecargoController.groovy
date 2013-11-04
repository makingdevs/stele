package com.stele

import com.payable.Recargo

class RecargoController {

  def scaffold = Recargo

  def springSecurityService

  def nuevo(){
    Recargo recargo = new Recargo(params)
    recargo.organizacion = springSecurityService.currentUser.instituciones?.first()  
    recargo.save(flush:true)
    render template:"/recargo/list", model:[recargos:recargo, recargoId:recargo.id]
  }
  
}