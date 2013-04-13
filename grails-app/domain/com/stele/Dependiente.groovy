package com.stele

import com.stele.seguridad.Usuario

class Dependiente {

  String matricula
  Perfil perfil
  static hasMany = [historialAcademico : HistorialAcademico, pagos : Pago]
  static belongsTo = [usuario : Usuario]

  Date dateCreated
  Date lastUpdated
  
  //TODO:Definir criterios para validar dependientes duplicados
  static constraints = {
    matricula size:1..100,blank:false
  }
}
