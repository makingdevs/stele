package com.stele

import com.payable.Surcharge

class RecargoController {

  def scaffold = Surcharge

  def springSecurityService

  def nuevo(){
    def message = ""
    def surcharge = Surcharge.get(params.recargoId ?: 0) ?: new Surcharge(amount:params.amount,
                                                                          percentage:params.percentage,
                                                                          organization:springSecurityService.currentUser.instituciones?.first())
    if(surcharge.id)
      message = "Sólo puede agregarse un recargo"
    else
      surcharge.save() 

    render template:"/recargo/list", model:[recargo:surcharge,message:message]
  }
  
  def deleteRecargo(Long id){
    Surcharge recargo = Surcharge.get(params.id)
    recargo.delete()
    render template:"/recargo/list"
  }
  
}
