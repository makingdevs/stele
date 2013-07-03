package com.stele

import com.stele.seguridad.Usuario

class Dependiente {

  String matricula
  Perfil perfil
  String camada
  static hasMany = [historialAcademico : HistorialAcademico, pagos : Pago]
  static belongsTo = [usuario : Usuario]

  Date dateCreated
  Date lastUpdated
  
  static constraints = {
    matricula size:1..100,blank:false
    camada size:1..100,blank:false,nullable:false
  }
}
