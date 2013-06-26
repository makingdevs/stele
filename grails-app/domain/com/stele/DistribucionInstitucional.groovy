package com.stele
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class DistribucionInstitucional implements Comparable<DistribucionInstitucional>{

  NivelDeEstudio nivelDeEstudio = NivelDeEstudio.PRIMARIA
  Integer grado
  String grupo
  Turno turno = Turno.MATUTINO

  Date dateCreated
  Date lastUpdated

  static belongsTo = [institucion : Institucion]

  static constraints = {
    grado range:1..15
    grupo size:1..10
  }

  public int compareTo(DistribucionInstitucional other){
    institucion <=> other.institucion ?: nivelDeEstudio <=> other.nivelDeEstudio ?: grado <=> other.grado ?: grupo <=> other.grupo ?: turno <=> other.turno
  }

}
