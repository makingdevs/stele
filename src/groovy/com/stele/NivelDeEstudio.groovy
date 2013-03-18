package com.stele

enum NivelDeEstudio {
  PREESCOLAR("Preescolar"),
  PRIMARIA("Primaria"),
  SECUNADARIA("Secunadaria"),
  BACHILLERATO("Bachillerato"),
  EDUCACION_SUPERIOR("Educación_Superior")

  final String value
  NivelDeEstudio(String value){ this.value = value }

  String toString(){ value }
  String getKey(){ name() }  
}
