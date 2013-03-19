package com.stele

class Dependiente {

  static hasOne = [perfil: Perfil]
  static hasMany = [historialAcademico : HistorialAcademico, pagos : Pago]

  Date dateCreated
  Date lastUpdated
  
  static constraints = {
  }
}
