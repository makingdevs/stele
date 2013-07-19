package com.stele

import com.stele.Descuento
import grails.converters.JSON

class DescuentoController {

  def descuentoService
  def springSecurityService

  static allowedMethods = [obtenerDescuentosInstitucion : 'GET']

  def index() { }

  def obtenerDescuentosInstitucion() {
    def descuentosList = descuentoService.buscarDescuentosDeUnaInstitucion(springSecurityService.currentUser)
    JSON.use('stele') {
      render descuentosList as JSON
    }
  }

}
