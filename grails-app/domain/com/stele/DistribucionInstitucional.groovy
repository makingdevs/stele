package com.stele

class DistribucionInstitucional {

  NivelDeEstudio nivelDeEstudio
  Integer grado
  String grupo
  Turno turno

  static constraints = {
    grado range:1..15
    grupo size:1..10
  }
}
