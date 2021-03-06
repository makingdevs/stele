package com.stele
import com.makingdevs.*

class CamadaController {

  def show(){
    String camada = params.camada
    def listaUsuario = params.listaDeUsuarios
    if(!camada || camada == 'NaC'){
      flash.message = "No hemos identificado el grupo de alumnos!!!"
      redirect uri:"/"
      return
    }

    def dependientes = Dependiente.findAllByCamada(camada)
    def dependientesExistentes = Dependiente.findAllByIdInList(listaUsuario*.toLong())
    dependientesExistentes.removeAll(dependientes)
    dependientes+= dependientesExistentes
    flash.dependientes = dependientes*.id
    [dependientes:dependientes,camada:params.camada]
  }
}
