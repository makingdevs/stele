package com.stele


class EstadoDeCuenta {

  def springSecurityService
  def pagoService

  def show() {
    def usuarioActual = springSecurityService.currentUser
    def estadoDeCuentaUsuario = pagoService.estadoDeCuentaUsuario(springSecurityService.currentUser)
    [usuarioActual : usuarioActual, 
     pagosVencidos:estadoDeCuentaUsuario.pagosVencidos,
     pagosEnTiempo:estadoDeCuentaUsuario.pagosEnTiempo,
     pagosPorRealizar:estadoDeCuentaUsuario.pagosARealizar,
     pagosMensuales:estadoDeCuentaUsuario.pagoMensual]
  }

}