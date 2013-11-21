package com.stele

import com.payable.*


class EstadoDeCuentaController {

  def springSecurityService
  def pagoService

  def show() {
    def dependiente
    def usuarioActual = springSecurityService.currentUser
    def estatusDeCuenta = pagoService.estadoDeCuentaUsuario(usuarioActual)
    def dependientes = Dependiente.findAllByUsuario(usuarioActual)
    if (params.idDependiente) 
      dependiente = Dependiente.findById(params.idDependiente)
    else
      dependiente = Dependiente.findById(dependientes.first().id)
    def pagosDependiente = dependiente.pagos
    [
     usuarioActual : usuarioActual,
     listDependiente : dependientes,
     pagosVencido : separarPagosEstadoDeCuenta(estatusDeCuenta.pagosVencidos, pagosDependiente),
     pagosEnTiempo : separarPagosEstadoDeCuenta(estatusDeCuenta.pagosEnTiempo, pagosDependiente),
     pagosPorRealizar : separarPagosEstadoDeCuenta(estatusDeCuenta.pagosPorRealizar, pagosDependiente),
     pagoMensual : separarPagosEstadoDeCuenta(estatusDeCuenta.pagoMensual, pagosDependiente),
     pagosRechazados : separarPagosEstadoDeCuenta(estatusDeCuenta.pagosRechazados, pagosDependiente),
     pagosProcesados : separarPagosEstadoDeCuenta(estatusDeCuenta.pagosProcesados, pagosDependiente),
     pagoCorrectos : separarPagosEstadoDeCuenta(estatusDeCuenta.pagoCorrectos, pagosDependiente)
    ]
  }

  def separarPagosEstadoDeCuenta(def estadodeCuenta, def pagosDependiente) {
    def pagosSeparados = []
    estadodeCuenta.each{ pago -> 
      if (pagosDependiente.contains(pago))
        pagosSeparados.add(pago) 
    }
    pagosSeparados
  }

}