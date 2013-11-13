package com.stele


class EstadoDeCuentaController {

  def springSecurityService
  def pagoService
  def dependienteService

  def show() {
    def usuarioActual = springSecurityService.currentUser
    def estadoDeCuentaUsuario = pagoService.estadoDeCuentaUsuario(springSecurityService.currentUser)
    def dependientes = dependienteService.obnerDependientesPorUsuario(usuarioActual)
    separarPagosPorDependiente(estadoDeCuentaUsuario, dependientes.dependientes)
    [usuarioActual : usuarioActual, 
     pagosVencidos:estadoDeCuentaUsuario.pagosVencidos,
     pagosEnTiempo:estadoDeCuentaUsuario.pagosEnTiempo,
     pagosPorRealizar:estadoDeCuentaUsuario.pagosPorRealizar,
     pagosMensuales:estadoDeCuentaUsuario.pagoMensual,
     dependiente: dependientes.dependientes,
     perfil: dependientes.perfiles]
  }

  def separarPagosPorDependiente(def estadoDeCuentaUsuario, def dependientes) {
    dependientes.each{ dependiente ->
      println dependiente.pagos*.id
    }

  } 

}