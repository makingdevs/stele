package com.stele

import com.payable.*
import java.text.SimpleDateFormat 


class EstadoDeCuentaController {

  def springSecurityService
  def cuentasBancariasService
  def pagoService

  def show() {
    def dependiente
    def pagosDependiente
    def usuarioActual = springSecurityService.currentUser
    def estatusDeCuenta = pagoService.estadoDeCuentaUsuario(usuarioActual)
    def dependientes = Dependiente.findAllByUsuario(usuarioActual)
    if (dependientes) {
      if (params.idDependiente) 
        dependiente = Dependiente.findById(params.idDependiente)
      else
        dependiente = Dependiente.findById(dependientes.first().id)      
      pagosDependiente = dependiente.pagos
    }    
    def cuentasBancariasExistentes = cuentasBancariasService.obtenerCuentasExistentesPorInstitucion(usuarioActual?.instituciones?.first())
    [
     usuarioActual : usuarioActual,
     listDependiente : dependientes,
     pagosVencido : separarPagosEstadoDeCuenta(estatusDeCuenta.pagosVencidos, pagosDependiente),
     pagosEnTiempo : separarPagosEstadoDeCuenta(estatusDeCuenta.pagosEnTiempo, pagosDependiente),
     pagosPorRealizar : separarPagosPorMeses(separarPagosEstadoDeCuenta(estatusDeCuenta.pagosPorRealizar, pagosDependiente)),
     pagoMensual : separarPagosPorMeses(separarPagosEstadoDeCuenta(estatusDeCuenta.pagoMensual, pagosDependiente)),
     pagosRechazados : separarPagosEstadoDeCuenta(estatusDeCuenta.pagosRechazados, pagosDependiente),
     pagosProcesados : separarPagosEstadoDeCuenta(estatusDeCuenta.pagosProcesados, pagosDependiente),
     pagoCorrectos : separarPagosEstadoDeCuenta(estatusDeCuenta.pagoCorrectos, pagosDependiente),
     electronica : cuentasBancariasExistentes.electronica,
     cheque : cuentasBancariasExistentes.cheque,
     ficha : cuentasBancariasExistentes.ficha
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

  def separarPagosPorMeses(def pagos) {
    def listaPagosMes = [:]
    def listaPagos = pagos
    def mesActual = obtenerNumeroDeMes(new Date()) + 1
    pagos.each{ pago ->
      def pagosList = []
      def month = obtenerNumeroDeMes(pago.fechaDeVencimiento)
        listaPagos.each{ v ->
          def mes = obtenerNumeroDeMes(v.fechaDeVencimiento)
          if (month == mes)
            pagosList.add(v)
        }
      if (mesActual != month)
        listaPagosMes.put(obtenerNombreMesPorFecha(month),pagosList)
    } 
    listaPagosMes
  }

  def obtenerNumeroDeMes(def fecha) {
    Calendar cal = Calendar.getInstance()
    cal.setTime(fecha)
    cal.get(Calendar.MONTH)
  }

  def obtenerNombreMesPorFecha(def month) {
    SimpleDateFormat monthParse = new SimpleDateFormat("MM")
    SimpleDateFormat monthDisplay = new SimpleDateFormat("MMMM")
    monthDisplay.format(monthParse.parse(month.toString()))
  }
  def detalleEstadoDeCuentaMensual(){
    def pagos =  params.ids.replace('[','')?.replace(']','')?.split(',')
    def pagosDelMes = Pago.getAll(pagos*.toLong())
    [pagosDelMes:pagosDelMes, mes: params.mes]
  }

  def obtenerPagosPorDependiente() {
    def dependiente = Dependiente.findById(params.idDependiente,[fetch:['pago':'join']])
    flash.ventanilla = true
    render template:'/pago/contenedor', model:[
              pagosVencido:dependiente.pagos.findAll { pago -> pago.estatusDePago == EstatusDePago.VENCIDO }, 
              pagosRechazados:dependiente.pagos.findAll { pago -> pago.estatusDePago == EstatusDePago.RECHAZADO }, 
              pagosEnTiempo:dependiente.pagos.findAll { pago -> pago.estatusDePago == EstatusDePago.CREADO },
              pagosPorRealizar:[]]
    }


}