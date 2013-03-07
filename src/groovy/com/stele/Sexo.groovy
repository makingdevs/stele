package com.stele

enum Sexo {
  MASCULINO("Masculino"), FEMENINO("Femenino"), QUIMERA("Quimera")

  final String value
  Sexo(String value){ this.value = value }

  String toString(){ value }
  String getKey(){ name() }
}
