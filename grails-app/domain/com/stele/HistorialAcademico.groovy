package com.stele

class HistorialAcademico {

  DistribucionInstitucional distribucionInstitucional
  static belongsTo = [dependiente : Dependiente]

  Date dateCreated
  Date lastUpdated

  static constraints = {
  }
}