package com.stele

class InicioController {

  def index() {
    [:]
  }

  def preview(){
    def file = params.datosEscolares
    log.debug file.properties
    log.debug file.dump()
    log.debug params
  }

  def upload(){
    log.debug params
  }
}
