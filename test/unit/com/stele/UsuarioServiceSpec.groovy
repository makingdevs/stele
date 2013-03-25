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
        def filaExcelCommand = new FilaExcelCommand(
          cicloEscolar: "2021089",
          tutorNombre: "Rodrigo",
          tutorApellidoPaterno: "Martínez",
          tutorApellidoMaterno: "García",
          correoElectronico: "rockdrigo.mtz@gmail.com",
          telefono: "1234567",
          matricula: "765434567",
          dependienteApellidoPaterno: "Juan",
          dependienteApellidoMaterno: "Perez",
          dependienteNombre: "Perez",
          nivel: "Primaria",
          grado: "1",
          grupo: "A") 
      when:
        def usuario = service.obtenerUsuarioDesdeCommand(filaExcelCommand)
      then:
        assert usuario.username == "rockdrigo.mtz@gmail.com"
        assert usuario.password.size() > 0
        assert usuario.enabled
        assert !usuario.accountExpired
        assert !usuario.accountLocked
        assert !usuario.passwordExpired
        assert usuario.perfil.nombre == "Rodrigo"
        assert usuario.perfil.apellidoPaterno == "Martínez"
        assert usuario.perfil.apellidoMaterno == "García"

    }

}
