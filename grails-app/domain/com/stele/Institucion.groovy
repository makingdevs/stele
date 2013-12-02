package com.stele

import com.stele.seguridad.Usuario
import groovy.transform.ToString
import com.makingdevs.*
import com.payable.*

@ToString
class Institucion extends Organizacion{

  static belongsTo = Usuario
  static hasMany = [direcciones: Direccion, telefonos: Telefono, distribucionesInstitucionales : DistribucionInstitucional, usuarios : Usuario, cuentaBancari : CuentasBancarias]

  static constraints = {
    nombre size:1..100,blank:false
  }

}
