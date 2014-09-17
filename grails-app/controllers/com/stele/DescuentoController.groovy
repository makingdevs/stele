package com.stele

import com.payable.*
import grails.converters.JSON

class DescuentoController {

  def scaffold = Discount
  
  def discountService
  def springSecurityService

  static allowedMethods = [obtenerDescuentosInstitucion : 'GET']

  def nuevo() {
    def discounts = []
    def discount

    if(params.list("discount")) 
      discounts = params.list("discount")*.toLong() ?: []
    
    discount = discountService.saveDiscountForPaymentSchemeOfOrganizationWithReferenceDate(springSecurityService.currentUser.instituciones.first(),params)

    discounts << discount.id
    render template:"/descuento/list", model:[discounts:Discount.findAllByIdInList(discounts.unique())]
  }

  def obtenerDescuentosInstitucion() {
    def discountsList = discountService.searchDiscountsOfAnOrganization(springSecurityService.currentUser.instituciones.first(),params.id)
    JSON.use('stele') {
      render discountsList as JSON
    }
  }

  /*
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
    if (params.fechaDeVencimiento){
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
  }*/

}
