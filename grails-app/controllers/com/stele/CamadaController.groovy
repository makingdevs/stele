package com.stele

class CamadaController {

  def show(){
    String camada = params.camada
    if(!camada || camada == 'NaC'){
      flash.message = "No hemos identificado el grupo de alumnos!!!"
      redirect uri:"/"
      return
    }
    def dependientes = Dependiente.findAllByCamada(camada,[fetch:[perfil:'eager',usuario:'eager']])
    def dependientesCreateCriteria = Dependiente.createCriteria().list() {
      'in'('camada', camada)
      fetchMode('perfil', FM.EAGER)
      fetchMode('usuario', FM.EAGER)
    }
    def dependientesWithCriteria = Dependiente.withCriteria {
      'in'(camada, camada)
      fetchMode "perfil", FetchMode.EAGER
      fetchMode "usuario", FetchMode.EAGER
    }
    println "dependientes : $dependientes"
    println "dependientesCreateCriteria : $dependientesCreateCriteria"
    println "dependientesWithCriteria : $dependientesWithCriteria"
    [dependientes:dependientes,camada:params.camada]
  }
}