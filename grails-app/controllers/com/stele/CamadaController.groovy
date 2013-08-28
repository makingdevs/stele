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
    log.debug "dependientes : $dependientes"
    log.debug "camada : $params.camada  "
    [dependientes:dependientes,camada:params.camada]
  }
}
