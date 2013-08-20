package com.stele


class EstadoDeCuentaController {

  def springSecurityService
  def pagoService

  def show() {
    def usuarioActual = springSecurityService.currentUser
    def estadoDeCuentaUsuario = pagoService.estadoDeCuentaUsuario(springSecurityService.currentUser)
    log.debug estadoDeCuentaUsuario
    [usuarioActual : usuarioActual, 
     pagosVencidos:estadoDeCuentaUsuario.pagosVencidos,
     pagosEnTiempo:estadoDeCuentaUsuario.pagosEnTiempo,
     pagosPorRealizar:estadoDeCuentaUsuario.pagosPorRealizar,
     pagosMensuales:estadoDeCuentaUsuario.pagoMensual]
  }

}