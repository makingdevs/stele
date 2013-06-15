package com.stele

class CamadaController {

  def show(){
    String camada = params.camada
    if(!camada || camada == 'NaC'){
      flash.message = "No hemos identificado el grupo de alumnos!!!"
      redirect uri:"/"
      return
    }
    def dependientes = Dependiente.findByCamada(camada)
    [dependientes:dependientes]
  }
}
