package com.stele

import groovy.transform.ToString
import com.stele.seguridad.Usuario
import com.makingdevs.*
import com.payable.*

@ToString
class Dependiente extends Payable{

  String matricula
  Perfil perfil
  String camada
  static hasMany = [historialAcademico : HistorialAcademico]
  static belongsTo = [usuario : Usuario]

  Date dateCreated
  Date lastUpdated
  
  static constraints = {
    matricula size:1..100,blank:false
    camada size:1..100,blank:false,nullable:false
  }
}
