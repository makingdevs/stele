package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*
import spock.lang.Specification

@TestFor(UsuarioService)
class UsuarioServiceSpec  extends Specification{

    def "Obtener un usuario apartir de un command leeido desde un excel"(){
      given:
        def filaExcelCommand = new FilaExcelCommand(datosBasicos) 
      when:
        def usuario = service.obtenerUsuarioDesdeCommand(filaExcelCommand)
      then:
        assert usuario.username == usernameEsperado
        assert usuario.password.size() > 0
        assert usuario.enabled
        assert !usuario.accountExpired
        assert !usuario.accountLocked
        assert !usuario.passwordExpired
        assert usuario.perfil.nombre == nombreEsperado
        assert usuario.perfil.apellidoPaterno == apellidoPaternoEsperado
        assert usuario.perfil.apellidoMaterno == apellidoMaternoEsperado
      where:
        datosBasicos << [
          [tutorNombre:"Rodrigo",tutorApellidoPaterno:"Martínez",tutorApellidoMaterno:"García",correoElectronico:"rockdrigo.mtz@gmail.com"],
          [tutorNombre:"Juan",tutorApellidoPaterno:"Perez",tutorApellidoMaterno:"Perez",correoElectronico:"j.perez@gmail.com"]
        ]
        nombreEsperado << [
          "Rodrigo",
          "Juan"
        ]
        apellidoPaternoEsperado << [
          "Martínez",
          "Perez"
        ]
        apellidoMaternoEsperado << [
          "García",
          "Perez"
        ]
        usernameEsperado << [
          "rockdrigo.mtz@gmail.com",
          "j.perez@gmail.com"
        ]
    }

    def "Registrar un usuario verificando que no exista"(){
      given: "Un usuario con datos"
      when: "Guardamos el usuario con el servicio"
      then: "El id debe ser mayor que 0"
    }

    def "No registrar un usuario ya existente"(){
      given: "Un usuario con datos"
      when: "Se intenta guardar el usuario"
      then: "El id debe ser igual a 1"

    }

}
