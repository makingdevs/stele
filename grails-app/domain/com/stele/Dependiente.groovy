package com.stele

class Dependiente {

  Perfil perfil
  static hasMany = [historialAcademico : HistorialAcademico, pagos : Pago]

  Date dateCreated
  Date lastUpdated
  
  static constraints = {
  }
}
