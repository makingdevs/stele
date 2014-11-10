package com.stele

import com.payable.*
import java.text.SimpleDateFormat 


class EstadoDeCuentaController {

  def springSecurityService
  def cuentasBancariasService
  def paymentService 
  def accountingService
  def pagoService

  def show() {
    def dependiente
    def pagosDependiente
    def usuarioActual = springSecurityService.currentUser
    def dependientes = Dependiente.findAllByUsuario(usuarioActual)
    if (dependientes) {
      
      if (params.idDependiente) 
        dependiente = Dependiente.findById(params.idDependiente)
      else
        dependiente = Dependiente.findById(dependientes.first().id)
      
      pagosDependiente = accountingService.createStatementForInstances([dependiente])

    }    
    def cuentasBancariasExistentes = cuentasBancariasService.obtenerCuentasExistentesPorInstitucion(usuarioActual?.instituciones?.first())
    [
     usuarioActual : usuarioActual,
     listDependiente : dependientes,
     pagosVencido : pagosDependiente.paymentsExpired, 
     pagosEnTiempo : pagosDependiente.paymentsOnTime,
     pagosPorRealizar : separarPagosPorMeses(pagosDependiente.paymentsToBeMade), 
     pagoMensual :  separarPagosPorMeses(pagosDependiente.monthlyPayments), 
     pagosRechazados : pagosDependiente.rejectedPayments,   
     pagosProcesados : pagosDependiente.paymentsInProcess, 
     pagoCorrectos : pagosDependiente.correctPayments, 
     electronica : cuentasBancariasExistentes.electronica,
     cheque : cuentasBancariasExistentes.cheque,
     ficha : cuentasBancariasExistentes.ficha
    ]
  }

  def separarPagosPorMeses(def pagos) {
    def listaPagosMes = [:]
    def listaPagos = pagos
    def mesActual = obtenerNumeroDeMes(new Date()) + 1
    pagos.each{ pago ->
      def pagosList = []
      def month = obtenerNumeroDeMes(pago.dueDate)
        listaPagos.each{ v ->
          def mes = obtenerNumeroDeMes(v.dueDate)
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
    def dependiente = Dependiente.findById(params.idDependiente)
    def payments = PaymentLink.findByPaymentRef(dependiente.id).payments

    flash.ventanilla = true
    render template:'/pago/contenedor', model:[
              pagosVencido:payments.findAll { payment -> payment.paymentStatus == PaymentStatus.EXPIRED }, 
              pagosRechazados:payments.findAll { payment -> payment.paymentStatus == PaymentStatus.REJECTED }, 
              pagosEnTiempo:payments.findAll { payment -> payment.paymentStatus == PaymentStatus.CREATED },
              pagosPorRealizar:[]]
  }


}
