package com.stele

enum EstatusDePago {
  PROCESO("Proceso"),
  PAGADO("Pagado"),
  RECHAZADO("Rechazado"),
  CANCELADO("Cancelado")

  final String value
  EstatusDePago(String value){ this.value = value }

  String toString(){ value }
  String getKey(){ name() }
}