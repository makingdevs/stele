package com.stele

enum NivelDeEstudio {
  PREESCOLAR("Preescolar"),
  PRIMARIA("Primaria"),
  SECUNDARIA("Secundaria"),
  BACHILLERATO("Bachillerato"),
  EDUCACION_SUPERIOR("Educación_Superior")

  final String value
  NivelDeEstudio(String value){ this.value = value }

  String toString(){ value }
  String getKey(){ name() }  
}
