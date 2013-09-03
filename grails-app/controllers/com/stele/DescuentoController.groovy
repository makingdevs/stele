package com.stele

import com.stele.Descuento
import grails.converters.JSON

class DescuentoController {

  def scaffold = Descuento

  def descuentoService
  def springSecurityService

  static allowedMethods = [obtenerDescuentosInstitucion : 'GET']

  def nuevo() {
    log.debug "descuentos : $params"
    Descuento descuento = findOrSaveDescuentoWithParams(params)

    def descuentosIds = [descuento.id]
    if(params.descuentosIds) {
      def listaDescuentos = params.descuentosIds?.replace('[','')?.replace(']','')?.split(',') ?: []
      descuentosIds += listaDescuentos.collect{ s -> Long.valueOf(s) }
    }
    log.debug "descuentosIds : $descuentosIds"
    render template:"/descuento/list", model:[descuentos:Descuento.getAll(descuentosIds), descuentosIds:descuentosIds]
  }

  def obtenerDescuentosInstitucion() {
    def descuentosList = descuentoService.buscarDescuentosDeUnaInstitucion(springSecurityService.currentUser,params.query)
    JSON.use('stele') {
      render descuentosList as JSON
    }
  }

  private Descuento findOrSaveDescuentoWithParams(params) {
    Descuento descuento = Descuento.findByNombreDeDescuento(params.nombreDeDescuento)
    if(!descuento) {
      descuento = new Descuento(params)
      descuento.institucion = springSecurityService.currentUser.instituciones?.first()  
      descuento.save(flush:true)
    }
    descuento
  }

}
