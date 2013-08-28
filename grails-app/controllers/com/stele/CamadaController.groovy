package com.stele

class CamadaController {

  def show(){
    println "controller Show"
    log.info "controller show 1"
    String camada = params.camada
    if(!camada || camada == 'NaC'){
      flash.message = "No hemos identificado el grupo de alumnos!!!"
      redirect uri:"/"
      return
    }
    def dependientes = Dependiente.findAllByCamada(camada,[fetch:[perfil:'eager',usuario:'eager']])
    log.info "dependientes : $dependientes"
    println dependientes
    log.info "camada : $params.camada  "
    [dependientes:dependientes,camada:params.camada]
  }
}
