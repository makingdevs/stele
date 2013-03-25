package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

@TestFor(UsuarioService)
class UsuarioServiceSpec {

    def "Obtener un usuario apartir de un command leeido desde un excel"(){
      given:
        def filaExcelCommand = new FilaExcelCommand() 
      when:
        def usuario = Service.obtenerUsuarioDesdeCommand(filaExcelCommand)
      then:
        assert usuario.username == "rockdrigo.mtz@gmail.com"
        assert usuario.password.size() > 0
        assert usuario.enabled
        assert !usuario.accountExpired
        assert !usuario.accountLocked
        assert !usuario.passwordExpired
        assert usuario.perfil.nombre == "Rodirgo"
        assert usuario.perfil.apellidoPaterno == "Martínez"
        assert usuario.perfil.apellidoMaterno == "García"

    }

}
