package com.stele

class DistribucionInstitucional {

  NivelDeEstudio nivelDeEstudio = NivelDeEstudio.PRIMARIA
  Integer grado
  String grupo
  Turno turno = Turno.MATUTINO

  Date dateCreated
  Date lastUpdated

  static constraints = {
    grado range:1..15
    grupo size:1..10
  }
}
