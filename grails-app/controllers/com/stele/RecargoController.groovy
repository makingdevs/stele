package com.stele

import com.payable.Recargo

class RecargoController {

  def scaffold = Recargo

  def springSecurityService

  def nuevo(){
    Recargo recargo = Recargo.get(params.recargoId ?: 0) ?: new Recargo(cantidad:params.cantidad,
                                                                       porcentaje:params.porcentaje,
                                                                       organizacion:springSecurityService.currentUser.instituciones?.first()).save(flush:true)

    render template:"/recargo/list", model:[recargos:recargo, recargoId:recargo.id]
  }
  
}
