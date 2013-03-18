package com.stele

class HistorialAcademico {

  DistribucionInstitucional distribucionInstitucional
  static belongsTo = [dependiente : Dependiente]

  static constraints = {
  }
}