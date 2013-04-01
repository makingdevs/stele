package com.stele

class Dependiente {

  String matricula
  Perfil perfil
  static hasMany = [historialAcademico : HistorialAcademico, pagos : Pago]

  Date dateCreated
  Date lastUpdated
  
  static constraints = {
    matricula size:1..100,blank:false
  }
}
