package com.stele

import org.hibernate.FetchMode

class CamadaController {

  def show(){
    String camada = params.camada
    if(!camada || camada == 'NaC'){
      flash.message = "No hemos identificado el grupo de alumnos!!!"
      redirect uri:"/"
      return
    }
    def dependientes = Dependiente.findAllByCamada(camada,[fetch:[perfil:'eager',usuario:'eager']])
    def dependientesWithCriteria = Dependiente.withCriteria {
      'in'('camada', camada)
      fetchMode 'perfil', FetchMode.EAGER
      fetchMode 'usuario', FetchMode.EAGER
    }
    println "dependientes : $dependientes"
    println "dependientesWithCriteria : $dependientesWithCriteria"
    [dependientes:dependientes,camada:params.camada]
  }
}