package com.stele

enum Turno {
  MATUTINO("Matutino"),
  VESPERTINO("Vespertino"),
  NOCTURNO("Nocturno")

  final String value
  Turno(String value){ this.value = value }

  String toString(){ value }
  String getKey(){ name() }
}
