package com.stele

import com.payable.*
import org.codehaus.groovy.grails.plugins.jasper.JasperExportFormat
import org.codehaus.groovy.grails.plugins.jasper.JasperReportDef

class PagoController {

  def springSecurityService
  def pagoService
  def historialAcademicoService
  def comprobanteService
  def reciboDePagoService
  def jasperService

  def index() { 
    def pagosDeUsuario = pagoService.estadoDeCuentaUsuario(springSecurityService.currentUser)
    [pagosDeUsuario: pagosDeUsuario, usuario: springSecurityService.currentUser]
  }

  def mostrarPagosAsociadosALaInstitucionEnBaseAHistorialesAcademicos() {
   def historialesAcademicos = historialAcademicoService.obtenerHistorilesAcademicosDelaInstitucion(springSecurityService.currentUser)
   def pagosAsociadosAInstitucion = historialesAcademicos*.dependiente*.pagos.flatten()
   render (view: "pagosAsociadosAUnaInstitucion", model:[pagosInstitucion:pagosAsociadosAInstitucion, usuario:springSecurityService.currentUser])
  }

  def generarPagoEnVentanilla() {
    render (view:"manual")
  }

  def pagoInmediatoVentanilla() {
    def fecha = new Date().parse("dd/MM/yyyy", params.fechaDePago)
    def pago = comprobanteService.aprobarPago(params.transactionId,fecha, params.tipoDePago,params.folioBanco)
    flash.pagoCorrecto = pago.estatusDePago
    render(template:"/pagoVentanilla/reporte",model:[pagoId:pago.id])
  }

  def generarComprobante(){
    def informacionReciboPago = reciboDePagoService.obtenerDatosReciboDePago(params.pagoId)    
    def report = new JasperReportDef(name:"reciboPago.jasper",fileFormat:JasperExportFormat.PDF_FORMAT,
                                     reportData:[informacionReciboPago],
                                     locale:Locale.getDefault(),
                                     parameters:[nombreEscuela:springSecurityService.currentUser.instituciones?.first().nombre.toUpperCase()])
    response.setContentType("application/pdf")   
    response.setHeader "Content-disposition", "attachment; filename=reciboPago.pdf";
    response.outputStream << jasperService.generateReport(report).toByteArray()
  }

}
