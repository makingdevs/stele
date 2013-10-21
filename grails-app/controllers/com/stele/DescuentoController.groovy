package com.stele

import com.payable.Descuento
import grails.converters.JSON

class DescuentoController {

  def scaffold = Descuento

  def descuentoService
  def springSecurityService

  static allowedMethods = [obtenerDescuentosInstitucion : 'GET']

  def nuevo() {
    Descuento descuento = findOrSaveDescuentoWithParams(params)
    def descuentosIds = [descuento.id]
    def descuentoConFechaDeVencimiento = params.descuentoConFecha?.replace('[','')?.replace(']','')?.split(',') ?: ""
    if(params.descuentosIds) {
      def listaDescuentos = params.descuentosIds?.replace('[','')?.replace(']','')?.split(',') ?: []
      descuentosIds += listaDescuentos.collect{ s -> Long.valueOf(s) }
    }
    println descuentoConFechaDeVencimiento
    if (params.diasPreviosParaCancelarDescuento.equals("1")){
      descuentoConFechaDeVencimiento += descuento?.id + ":" + params.fechaDeVencimiento 
    }
    render template:"/descuento/list", model:[descuentos:Descuento.getAll(descuentosIds), descuentosIds:descuentosIds,descuentosVencimiento:descuentoConFechaDeVencimiento]
  }

  def obtenerDescuentosInstitucion() {
    def descuentosList = descuentoService.buscarDescuentosDeUnaOrganizacion(springSecurityService.currentUser.instituciones.first(),params.query)
    JSON.use('stele') {
      render descuentosList as JSON
    }
  }

  private Descuento findOrSaveDescuentoWithParams(params) {
    Descuento descuento = Descuento.findByNombreDeDescuento(params.nombreDeDescuento)
    if(!descuento) {
      descuento = new Descuento(params)
      descuento.organizacion = springSecurityService.currentUser.instituciones?.first()  
      descuento.save(flush:true)
    }
    descuento
  }

}
