package com.stele

import grails.validation.Validateable

@Validateable
class CamadaPagoCommand {

  String camada
  String conceptoDePago
  String conceptoDePagoRecurrente
  BigDecimal cantidadDePago
  BigDecimal cantidadDePagoRecurrente
  Date fechaDeVencimiento
  Integer diasPreviosParaCancelarDescuento
  Integer diasVencimientoPago
  String[] descuentos
  String[] recargoid
  String[] meses
  String[] pagoDoble
  String listaDependientes
  String descuentoConFecha

  static constraints = {
    camada size:1..100, blank:false, nullable:false
    conceptoDePago size:1..150, blank:false, nullable:true
    cantidadDePago  nullable:true
    fechaDeVencimiento nullable: false
    diasPreviosParaCancelarDescuento nullable: true
    descuentos nullable:true
    recargoid nullable:true
    meses nullable:true
    listaDependientes nullable:true
    descuentoConFecha nullable:true
  }

}
