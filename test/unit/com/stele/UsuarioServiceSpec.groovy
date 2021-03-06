package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*
import spock.lang.Specification
import com.stele.seguridad.Usuario
import com.stele.seguridad.Rol
import com.stele.seguridad.UsuarioRol
import com.makingdevs.*

@TestFor(UsuarioService)
@Mock([Usuario, Rol, UsuarioRol, Perfil, Telefono, Institucion])
class UsuarioServiceSpec  extends Specification{

    def "Obtener un usuario apartir de un command leído desde un excel y verificando validaciones en telefono"(){
      given:
        def filaExcelCommand = new FilaExcelCommand(datosBasicos) 
      when:
        def usuario = service.obtenerUsuarioDesdeCommand(filaExcelCommand)
      then:
        assert usuario.username == usernameEsperado
        assert usuario.password == passwordEsperado
        assert usuario.enabled
        assert !usuario.accountExpired
        assert !usuario.accountLocked
        assert !usuario.passwordExpired
        assert usuario.perfil.nombre == nombreEsperado
        assert usuario.perfil.apellidoPaterno == apellidoPaternoEsperado
        assert usuario.perfil.apellidoMaterno == apellidoMaternoEsperado
        assert usuario.perfil.telefonos*.numeroTelefonico.flatten() == [numeroTelefonicoEsperado]
      where:
        datosBasicos << [
          [tutorNombre:"Rodrigo",tutorApellidoPaterno:"Martínez",tutorApellidoMaterno:"García",correoElectronico:"rockdrigo.mtz@gmail.com",telefono:"(172) 790-9153"],
          [tutorNombre:"Juan",tutorApellidoPaterno:"Perez",tutorApellidoMaterno:"Perez",correoElectronico:"j.perez@gmail.com",telefono:"987654321"]
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
        numeroTelefonicoEsperado << [
          "1727909153",
          "987654321"
        ]
        passwordEsperado << [
          "roro9153",
          "juj.4321"
        ]
    }

    def "Registrar un usuario verificando que no exista"(){
      given: "Un usuario con datos"
        new Rol(authority:"ROLE_PADRE_TUTOR").save()
        def perfilServiceMock = mockFor(PerfilService)
        perfilServiceMock.demand.registrar(1..1) { Perfil perfil -> new Perfil(id:1) }
        service.perfilService = perfilServiceMock.createMock()
        def usuario = new Usuario()
        def perfil = new Perfil()
        def telefono = new Telefono()
        Usuario.metaClass.isDirty = { true } 
        Usuario.metaClass.encodePassword = { "password" } 
        usuario.username = "pepito@gmail.com"
        usuario.password = "pepe6789"
        usuario.enabled = true
        perfil.nombre = "Pepito"
        perfil.apellidoPaterno = "Juarez"
        perfil.apellidoMaterno = "Juarez"
        telefono.numeroTelefonico = "123456789"
        perfil.addToTelefonos(telefono)
        usuario.perfil = perfil
      and:
        Institucion institucion = new Institucion()
        institucion.save(validate:false)
      when: "Guardamos el usuario con el servicio"
        usuario = service.registrar(usuario, institucion)
      then: "El id debe ser mayor que 0"
        assert usuario.id > 0
    }

    def "No registrar un usuario ya existente"(){
      given:
        Institucion institucion = new Institucion()
        institucion.save(validate:false)
      and: "un usuario ya existente y "
        def perfilServiceMock = mockFor(PerfilService)
        perfilServiceMock.demand.registrar(1..1){ Perfil perfil -> new Perfil(id:1) }
        service.perfilService = perfilServiceMock.createMock()
        Usuario.metaClass.isDirty = { true } 
        Usuario.metaClass.encodePassword = { "password" } 
        def usuarioExistente = new Usuario(username:"pepito@gmail.com",
                                           password:"pepe6789",
                                           enabled:true)
        def perfilExistente = new Perfil(nombre:"Pepito",
                                         apellidoPaterno:"Juarez",
                                         apellidoMaterno:"Juarez").save(validate:false)
        def telefono = new Telefono()
        telefono.numeroTelefonico = "123456789"
        perfilExistente.addToTelefonos(telefono)
        usuarioExistente.addToInstituciones(institucion)
        usuarioExistente.perfil = perfilExistente
        usuarioExistente.save(validate:false)
      and: "un usuario con datos"
        def usuario = new Usuario()
        usuario.username = "pepito@gmail.com"
        usuario.enabled = true
        usuario.password = "pepe6789"
      when: "se intenta guardar el usuario"
        usuario = service.registrar(usuario,institucion)
      then: "el id debe ser igual a 1"
        assert usuario.id == 1
    }

    def "Registrar un usuario verificando que no exista y agregando una institucion"(){
      given: "Un usuario con datos y agregando la institucion"
        new Rol(authority:"ROLE_PADRE_TUTOR").save()
        def perfilServiceMock = mockFor(PerfilService)
        perfilServiceMock.demand.registrar(1..1) { Perfil perfil -> new Perfil(id:1) }
        service.perfilService = perfilServiceMock.createMock()
        def usuario = new Usuario()
        def perfil = new Perfil()
        def telefono = new Telefono()
        def institucion = new Institucion()
        Usuario.metaClass.isDirty = { true } 
        Usuario.metaClass.encodePassword = { "password" }
        usuario.username = "pepito@gmail.com"
        usuario.password = "pepe6789"
        usuario.enabled = true
        perfil.nombre = "Pepito"
        perfil.apellidoPaterno = "Juarez"
        perfil.apellidoMaterno = "Juarez"
        telefono.numeroTelefonico = "123456789"
        perfil.addToTelefonos(telefono)
        institucion.name = "Escuela patito"
        institucion.save(validate:false)
        usuario.addToInstituciones(institucion)
        usuario.perfil = perfil
      when: "Guardamos el usuario y la institucion con el servicio"
        usuario = service.registrar(usuario, institucion)
      then: "El id debe ser mayor que 0"
        assert usuario.id > 0
        usuario.instituciones.each{
          assert it.id > 0
        }
    }

    def "Registrar usuario Director y enviar notificacion"() {
      given:
        def params = [institucion:[nombre:'makingdevs'],
                      usuario:[username:'juan@makingdevs.com', password:12345678],
                      perfil:[apellidoPaterno:'rodriguez', nombre:'sergio', apellidoMaterno:'duran'],
                      numeroTelefonico:55158898]
      and:
        def notificacionServiceMock = mockFor(NotificacionService)
        notificacionServiceMock.demand.notificarRegistroUsuarioAdministrador(1..1){obj -> }
        service.notificacionService = notificacionServiceMock.createMock()
      when:
        def registro = service.registrarUsuarioDirector(params)
      then:
        assert registro.id > 0
        assert registro.username == 'juan@makingdevs.com'
        assert registro.perfil.nombre == 'sergio'
    }
    
}
