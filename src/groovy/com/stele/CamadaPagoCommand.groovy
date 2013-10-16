package com.stele

import grails.validation.Validateable

@Validateable
class CamadaPagoCommand {

  String camada
  String conceptoDePago
  BigDecimal cantidadDePago
  Date fechaDeVencimiento
  Integer diasPreviosParaCancelarDescuento
  String[] descuentos
  String[] recargoid
  String[] meses
  String[] pagoDoble
  String listaDependientes
  String descuentoConFecha

  static constraints = {
    camada size:1..100, blank:false, nullable:false
    conceptoDePago size:1..150, blank:false, nullable:false
    cantidadDePago min:1.0, nullable:false
    fechaDeVencimiento nullable: false
    diasPreviosParaCancelarDescuento nullable: true
    descuentos nullable:true
    recargoid nullable:true
    meses nullable:true
    listaDependientes nullable:true
    descuentoConFecha nullable:true
  }

}
