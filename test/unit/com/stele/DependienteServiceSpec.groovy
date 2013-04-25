package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll
import com.stele.Dependiente
import com.stele.seguridad.Usuario


@TestFor(DependienteService)
@Mock([Usuario,Dependiente])
class DependienteServiceSpec extends Specification{

  @Unroll("#datosBasicos")
  def "Obtener un dependiente apartir de un command leeido desde un excel"(){
    given:
    def filaExcelCommand = new FilaExcelCommand(datosBasicos) 
    when:
    def dependiente = service.obtenerDependienteDesdeCommand(filaExcelCommand)
    then:
    assert dependiente.matricula == matriculaEsperada
    assert dependiente.perfil.nombre == nombreEsperado
    assert dependiente.perfil.apellidoPaterno == apellidoPaternoEsperado
    assert dependiente.perfil.apellidoMaterno == apellidoMaternoEsperado
    where:
    datosBasicos << [
    [matricula:"1234567",dependienteNombre:"Pedrito",dependienteApellidoPaterno:"López",dependienteApellidoMaterno:"Arellano"],
    [matricula:"LKJHGFDT",dependienteNombre:"Memito",dependienteApellidoPaterno:"López",dependienteApellidoMaterno:"Arellano"]
    ]
    matriculaEsperada << [
    "1234567",
    "LKJHGFDT"
    ]
    nombreEsperado << [
    "Pedrito",
    "Memito"
    ]
    apellidoPaternoEsperado << [
    "López",
    "López"
    ]
    apellidoMaternoEsperado << [
    "Arellano",
    "Arellano"
    ]
  }

  def "Registro de un dependiente con un usuario prviamente registrado que no tiene dependientes aun"(){
    given:"Tengo un usuario registrado"
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
    usuarioExistente.save()
    and:"y un dependiente listo para registrar"
    def dependiente = new Dependiente()
    def perfil = new Perfil()
    dependiente.perfil = perfil
    dependiente.matricula = "M1234576"
    dependiente.camada= "1234567898"
    dependiente.perfil.nombre = "Juanito"
    dependiente.perfil.apellidoPaterno = "Perez"
    dependiente.perfil.apellidoMaterno = "Perez"
    when:"Guardo el dependiente en la relacion con el usuario 'service.metodo(dependiente,usuarioId)'"
    def usuarioGuardado = Usuario.findByUsername(usuarioExistente.username)
    dependiente = service.registrar(dependiente,usuarioGuardado.id)
    then:"el id del dependiente debe ser mayor que 0"
    assert dependiente.id > 0
  }

  def "Registro de un dependiente con un usuario previamente registrado que ya tiene por lo menos un depndiente"(){
    given:"Tengo un usuario registrado con un dependiente ya agregado"
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
    usuarioExistente.save()

    def dependienteAsociado = new Dependiente()
    def perfil = new Perfil()
    dependienteAsociado.perfil = perfil
    dependienteAsociado.matricula = "M1234576"
    dependienteAsociado.camada = "1234567898"
    dependienteAsociado.perfil.nombre = "Juanito"
    dependienteAsociado.perfil.apellidoPaterno = "Perez"
    dependienteAsociado.perfil.apellidoMaterno = "Perez"

    service.registrar(dependienteAsociado,usuarioExistente.id)
    and:"y un dependiente listo para registrar"
    def dependiente = new Dependiente()
    perfil = new Perfil()
    dependiente.perfil = perfil
    dependiente.matricula = "M0987654"
    dependiente.camada = "1234567898"
    dependiente.perfil.nombre = "Manolito"
    dependiente.perfil.apellidoPaterno = "Perez"
    dependiente.perfil.apellidoMaterno = "Perez"

    when:"Guardo el dependiente en la relación con el usuario"
    dependiente = service.registrar(dependiente,usuarioExistente.id)
    def usuarioGuardado = Usuario.findByUsername(usuarioExistente.username)
    then:"el id del dependiente debe ser mayor que 0"      
    assert dependiente.id > 0
    assert usuarioGuardado.dependientes.size() == 2
  }

  def "Registro de un dependiente sin usuario (=Error)"(){
    given:"Se tiene un dependiente sin usuario asigando"
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

    def dependiente = new Dependiente()
    def perfil = new Perfil()
    dependiente.perfil = perfil
    dependiente.matricula = "M0987654"
    dependiente.camada = "1234567898"
    dependiente.perfil.nombre = "Manolito"
    dependiente.perfil.apellidoPaterno = "Perez"
    dependiente.perfil.apellidoMaterno = "Perez"
    when:"Se intenta guardar el dependiente"
    dependiente = service.registrar(dependiente,usuarioExistente.id)
    then:"El id del dependiente tiene que ser 0"
    assert dependiente.id == null
  }
}
