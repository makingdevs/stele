package com.stele
import com.makingdevs.*

class CamadaController {

  def show(){
    String camada = params.camada
    if(!camada || camada == 'NaC'){
      flash.message = "No hemos identificado el grupo de alumnos!!!"
      redirect uri:"/"
      return
    }
    def dependientes = Dependiente.findAllByCamada(camada,[fetch:[perfil:'eager',usuario:'eager']])
    [dependientes:dependientes,camada:params.camada]
  }
}