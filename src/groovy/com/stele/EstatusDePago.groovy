package com.stele

enum EstatusDePago {
  CREADO("Creado"),
  PROCESO("Validando"),
  PAGADO("Pagado"),
  RECHAZADO("Rechazado"),
  CANCELADO("Cancelado")

  final String value
  EstatusDePago(String value){ this.value = value }

  String toString(){ value }
  String getKey(){ name() }
}