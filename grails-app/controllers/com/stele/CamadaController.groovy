package com.stele
import com.makingdevs.*

import org.hibernate.FetchMode

class CamadaController {

  def sessionFactory

  def show(){
    String camada = params.camada
    if(!camada || camada == 'NaC'){
      flash.message = "No hemos identificado el grupo de alumnos!!!"
      redirect uri:"/"
      return
    }

    sessionFactory.settings.sqlStatementLogger.logToStdout = true
    def dependientes = Dependiente.findAllByCamada(camada,[fetch:[perfil:'join',usuario:'join']])
    sessionFactory.settings.sqlStatementLogger.logToStdout = false


    [dependientes:dependientes,camada:params.camada]
  }
}