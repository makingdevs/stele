package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*
import spock.lang.Specification
import com.stele.seguridad.Usuario

@TestFor(UsuarioService)
@Mock(Usuario)
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
        def usuario = new Usuario()
        def perfil = new Perfil()
        usuario.username = "pepito@gmail.com"
        usuario.password = UUID.randomUUID().toString().replaceAll('-', '').substring(0,10)
        usuario.enabled = true
        usuario.perfil = perfil
        usuario.perfil.nombre = "Pepito"
        usuario.perfil.apellidoPaterno = "Juarez"
        usuario.perfil.apellidoMaterno = "Juarez"
      when: "Guardamos el usuario con el servicio"
        usuario = service.registrar(usuario)
      then: "El id debe ser mayor que 0"
        assert usuario.id > 0
    }

    def "No registrar un usuario ya existente"(){
      given:
        
        Usuario.metaClass.isDirty = { true } 
        Usuario.metaClass.encodePassword = { "password" } 
        def usuarioExistente = new Usuario()
        def perfilExistente = new Perfil()
        usuarioExistente.id = 1001
        usuarioExistente.username = "pepito@gmail.com"
        usuarioExistente.password = UUID.randomUUID().toString().replaceAll('-', '').substring(0,10)
        usuarioExistente.enabled = true
        usuarioExistente.perfil = perfilExistente
        usuarioExistente.perfil.nombre = "Pepito"
        usuarioExistente.perfil.apellidoPaterno = "Juarez"
        usuarioExistente.perfil.apellidoMaterno = "Juarez"
        service.registrar(usuarioExistente)
        def contador = Usuario.count()
      and: "Un usuario con datos"
        def usuario = new Usuario()
        def perfil = new Perfil()
        usuario.username = "pepito@gmail.com"
        usuario.password = UUID.randomUUID().toString().replaceAll('-', '').substring(0,10)
        usuario.enabled = true
        usuario.perfil = perfil
        usuario.perfil.nombre = "Pepito"
        usuario.perfil.apellidoPaterno = "Juarez"
        usuario.perfil.apellidoMaterno = "Juarez"
      when: "Se intenta guardar el usuario"
        usuario = service.registrar(usuario)
      then: "El id debe ser igual a 1001"
        assert usuario.id == 1001
        assert contador == Usuario.count()
    }
}
