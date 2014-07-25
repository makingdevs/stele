package com.stele

import com.payable.Descuento
import grails.converters.JSON

class DescuentoController {

  def scaffold = Descuento

  def descuentoService
  def springSecurityService

  static allowedMethods = [obtenerDescuentosInstitucion : 'GET']

  def nuevo() {
    def descuentosIds = []
    def descuento
    if(params.descuentosIds)
      descuentosIds = (params.descuentosIds?.replace('[','')?.replace(']','')?.split(','))*.toLong() ?: []
    
    if((descuento = Descuento.findByNombreDeDescuento(params.nombreDeDescuento)))
      flash.message = "El descuento ya ha sido registrado"
    else
      descuento = saveDescuentoWithParams(params)

    descuentosIds << descuento.id

    render template:"/descuento/list", model:[descuentos:Descuento.findAllByIdInList(descuentosIds),descuentosIds:descuentosIds]
  }

  def obtenerDescuentosInstitucion() {
    def descuentosList = descuentoService.buscarDescuentosDeUnaOrganizacion(springSecurityService.currentUser.instituciones.first(),params.id)
    JSON.use('stele') {
      render descuentosList as JSON
    }
  }

  private Descuento findOrSaveDescuentoWithParams(params) {
    Descuento descuento = Descuento.findByNombreDeDescuento(params.nombreDeDescuento)
    if(!descuento) {
      descuento = new Descuento(params)
      descuento.organizacion = springSecurityService.currentUser.instituciones?.first()
      if (!params.diasPreviosParaCancelarDescuento){
        def diasAntes = getLastDayOfMothByDate(new Date().parse("dd/MM/yyyy",params.fechaDeVencimiento))
        descuento.diasPreviosParaCancelarDescuento = diasAntes 
      }
      descuento.save(flush:true)
    }
    descuento
  }

  private Descuento saveDescuentoWithParams(params){
    def descuento = new Descuento(params)
    descuento.organizacion = springSecurityService.currentUser.instituciones?.first()
    if (!params.diasPreviosParaCancelarDescuento){
      def diasAntes = getLastDayOfMothByDate(new Date().parse("dd/MM/yyyy",params.fechaDeVencimiento))
      descuento.diasPreviosParaCancelarDescuento = diasAntes
    }
    descuento.save(flush:true)
    descuento
  }

  private Integer getLastDayOfMothByDate(Date fechaDeVencimiento){
    Calendar cala = Calendar.getInstance()
    cala.setTime(fechaDeVencimiento)
    def year = cala.get(Calendar.YEAR)
    def month = cala.get(Calendar.MONTH)
    def day = cala.get(Calendar.DAY_OF_MONTH)
    Calendar calendario = GregorianCalendar.instance
    calendario.set(year,month,day)  
    def lastDay = calendario.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)
    def dias = lastDay - day
    if(dias == 0)
      return 1
    return dias
  }

}
