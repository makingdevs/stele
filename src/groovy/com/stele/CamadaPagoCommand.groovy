package com.stele

import grails.validation.Validateable

@Validateable
class CamadaPagoCommand {

  String camada
  String conceptoDePago
  String conceptoDePagoRecurrente
  BigDecimal cantidadDePago
  BigDecimal cantidadDePagoRecurrente
  String fechaDeVencimiento
  Integer diasPreviosParaCancelarDescuento
  Integer diasVencimientoPago
  String[] descuentos
  String[] recargoid
  List<Integer> meses
  List<Integer> pagoDoble
  List<String> fechasDeExpiracionDescuento 
  List<Integer> diaVencimientoDescuento
  List<Integer> discount
  String listaDependientes
  String descuentoConFecha
  String idRecargo

  static constraints = {
    camada size:1..100, blank:false, nullable:false
    conceptoDePago size:1..150, blank:false, nullable:true
    cantidadDePago  nullable:true
    fechaDeVencimiento nullable: true
    diasPreviosParaCancelarDescuento nullable: true
    descuentos nullable:true
    recargoid nullable:true
    meses nullable:true
    listaDependientes nullable:true
    descuentoConFecha nullable:true
    idRecargo nullable:true
    discount nullable:true
  }

}
