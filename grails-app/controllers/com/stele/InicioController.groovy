package com.stele

class InicioController {

  def excelService

  def index() {
    [:]
  }

  def preview(){
    FileInputStream excelParaProcesar = params.datosEscolares.inputStream
    def filas = excelService.procesarFilas(excelParaProcesar)
    log.debug filas
  }

  def upload(){
    log.debug params
  }
}
