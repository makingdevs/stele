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
    def dependientes = Dependiente.findAllByCamada(camada)
    sessionFactory.settings.sqlStatementLogger.logToStdout = false
    println dependientes


    [dependientes:dependientes,camada:params.camada]
  }
}