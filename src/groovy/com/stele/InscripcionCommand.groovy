package com.stele

import grails.validation.Validateable

@Validateable
class InscripcionCommand {

  String cicloEscolar
  String nombreAlumno
  String apellidoPaternoAlumno
  String apellidoMaternoAlumno
  String nivelDeEstudio
  String grado
  String grupo
  String turno
  String matricula
  String nombrePadre
  String apellidoPaternoPadre
  String apellidoMaternoPadre
  String telefono
  String email


  static constraints = {
    cicloEscolar size:1..100, blank:false, nullable:false
    nombreAlumno size:1..100, blank:false, nullable:false
    apellidoPaternoAlumno size:1..150, blank:false, nullable:false
    apellidoMaternoAlumno size:1..150, blank:false, nullable:false
    nivelDeEstudio size:1..50, blank:false, nullable:false
    grado size:1..10, blank:false, nullable:false
    grupo size:1..10, blank:false, nullable:false
    turno size:1..50, blank:false, nullable:false
    matricula size:1..100, blank:false, nullable:false
    nombrePadre size:1..100, blank:false, nullable:false
    apellidoPaternoPadre size:1..100, blank:false, nullable:false
    apellidoMaternoPadre size:1..100, blank:false, nullable:false
    telefono size:1..20, blank:false, nullable:false
    email size:1..100, blank:false, nullable:false
  }

}