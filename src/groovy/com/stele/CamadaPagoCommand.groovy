package com.stele

import grails.validation.Validateable

@Validateable
class CamadaPagoCommand {

  String camada
  String conceptoDePago
  BigDecimal cantidadDePago
  Date fechaDeVencimiento
  String[] descuentos
  String[] recargoid
  String[] meses

  static constraints = {
    camada size:1..100, blank:false, nullable:false
    conceptoDePago size:1..150, blank:false, nullable:false
    cantidadDePago min:1.0, nullable:false
    fechaDeVencimiento nullable: false
    descuentos nullable:true
    recargoid nullable:true
    meses nullable:true
  }

}
