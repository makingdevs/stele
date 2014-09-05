package com.stele

import com.payable.Recargo

class RecargoController {

  def scaffold = Recargo

  def springSecurityService

  def nuevo(){
    def recargo
    def message = ""

    if((recargo = Recargo.get(params.recargoId ?: 0)))
      message = "No se puede agregar más de un recargo." 
    else
      recargo = new Recargo(cantidad:params.cantidad,
                            porcentaje:params.porcentaje,
                            organizacion:springSecurityService.currentUser.instituciones?.first()).save(flush:true)

    render template:"/recargo/list", model:[recargo:recargo,message:message]
  }
  
  def delete(){
    Recargo recargo = Recargo.get(params.id)
    recargo.delete()
    redirect(action:'nuevo')
  }
  
}
