package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll
import spock.lang.Ignore
import com.stele.Dependiente
import com.stele.seguridad.Usuario
import com.makingdevs.*

@TestFor(DependienteService)
@Mock([Usuario,Perfil,Dependiente,Institucion,HistorialAcademico,DistribucionInstitucional])
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

  def "Registro de un dependiente con un usuario previamente registrado que no tiene dependientes aun"(){
    given:"Una institucion y un historial academico"
      def organizacion = new Institucion(nombre:"Escuela Superior De Computo").save(validate:false)
      def distribucionInstitucional = new DistribucionInstitucional(grado:3,
                                                                    grupo:"B",
                                                                    institucion:organizacion)
      distribucionInstitucional.save(validate:false) 
      def historialAcademico = new HistorialAcademico(distribucionInstitucional:distribucionInstitucional)
      historialAcademico.save(validate:false)
    and:"un usuario registrado"
      Usuario.metaClass.isDirty = { true } 
      Usuario.metaClass.encodePassword = { "password" } 
      def usuario = new Usuario(username:"pepito@gmail.com",
                                password:UUID.randomUUID().toString().replaceAll('-', '').substring(0,10),
                                enabled:true)

      def perfil = new Perfil(nombre:"Pepito",
                              apellidoPaterno:"Juarez",
                              apellidoMaterno:"Juarez")
      
      usuario.perfil = perfil
      usuario.addToInstituciones(organizacion)
      usuario.save()
    and: 
      def perfilServiceMock = mockFor(PerfilService)
      perfilServiceMock.demand.registrar { p -> perfil }
      service.perfilService = perfilServiceMock.createMock()
    and:
      def notificacionServiceMock = mockFor(NotificacionService)
      notificacionServiceMock.demand.notificarRegistroUsuarioTutor(1..1){obj -> }
      service.notificacionService = notificacionServiceMock.createMock()
    and:"un dependiente"
      def dependiente = new Dependiente()
      def perfilDependiente = new Perfil()
      dependiente.matricula = "M1234576"
      dependiente.camada= "1234567898"
      perfilDependiente.nombre = "Juanito"
      perfilDependiente.apellidoPaterno = "Perez"
      perfilDependiente.apellidoMaterno = "Perez"
      dependiente.perfil = perfilDependiente
      dependiente.addToHistorialAcademico(historialAcademico)
    when:"Guardo el dependiente en la relacion con el usuario 'service.metodo(dependiente,usuarioId)'"
      def usuarioGuardado = Usuario.findByUsername(usuario.username)
      dependiente = service.registrar(dependiente,usuarioGuardado.id, organizacion)
    then:"el id del dependiente debe ser mayor que 0"
      assert dependiente.id > 0
  }
 
  def "Registro de un dependiente con un usuario previamente registrado que ya tiene por lo menos un dependiente"(){
    given:"crear una institucion"
      def organizacion = new Institucion(nombre:"Escuela Superior De Computo").save(validate:false)
      def distribucionInstitucional = new DistribucionInstitucional(grado:3,
                                                                    grupo:"B",
                                                                    institucion:organizacion)
      distribucionInstitucional.save(validate:false)
      def historialAcademico = new HistorialAcademico(distribucionInstitucional:distribucionInstitucional)
      historialAcademico.save(validate:false)

    and:"Tengo un usuario registrado con un dependiente ya agregado"
      Usuario.metaClass.isDirty = { true } 
      Usuario.metaClass.encodePassword = { "password" } 
      def usuarioExistente = new Usuario()
      def perfilExistente = new Perfil()
      usuarioExistente.username = "pepito@gmail.com"
      usuarioExistente.password = UUID.randomUUID().toString().replaceAll('-', '').substring(0,10)
      usuarioExistente.enabled = true
      perfilExistente.nombre = "Pepito"
      perfilExistente.apellidoPaterno = "Juarez"
      perfilExistente.apellidoMaterno = "Juarez"
      usuarioExistente.perfil = perfilExistente

      usuarioExistente.addToInstituciones(organizacion)
      usuarioExistente.save(validate:false)
      def dependienteAsociado = new Dependiente(matricula:"M1234567",
                                                camada:"1234567898")
      def perfilDependiente = new Perfil(nombre:"Juanito",
                                         apellidoPaterno:"Perez",
                                         apellidoMaterno:"Perez")

      dependienteAsociado.perfil = perfilDependiente
      dependienteAsociado.addToHistorialAcademico(historialAcademico)

    and: "Puedo guardar el perfil"
      def perfilServiceMock = mockFor(PerfilService)
      perfilServiceMock.demand.registrar(1..2) { p -> perfilExistente }
      service.perfilService = perfilServiceMock.createMock()
    and: "enviar notificacion"
      def notificacionServiceMock2 = mockFor(NotificacionService)
      notificacionServiceMock2.demand.notificarRegistroUsuarioTutor(0..0){obj -> }
      service.notificacionService = notificacionServiceMock2.createMock()
    and: "registro un dependiente"
      service.registrar(dependienteAsociado,usuarioExistente.id, organizacion)
    and:"y un dependiente listo para registrar"
      def dependiente = new Dependiente(matricula:"M0987654",
                                        camada:"1234567898")

      def perfil = new Perfil(nombre:"Manolito",
                              apellidoPaterno:"Perez",
                              apellidoMaterno:"Perez")
      dependiente.perfil = perfil
      dependiente.addToHistorialAcademico(historialAcademico)
    and: "enviar notificacion"
      def notificacionServiceMock = mockFor(NotificacionService)
      notificacionServiceMock.demand.notificarRegistroUsuarioTutor(1..1){obj -> }
      service.notificacionService = notificacionServiceMock.createMock()
    when:"Guardo el dependiente en la relación con el usuario"
      dependiente = service.registrar(dependiente, usuarioExistente.id, organizacion)
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
      perfilExistente.nombre = "Pepito"
      perfilExistente.apellidoPaterno = "Juarez"
      perfilExistente.apellidoMaterno = "Juarez"
      usuarioExistente.perfil = perfilExistente
    when:"Se prepara el dependiente a registrar"
      def dependiente = new Dependiente()
      def perfil = new Perfil()
      dependiente.matricula = "M0987654"
      dependiente.camada = "1234567898"
      perfil.nombre = "Manolito"
      perfil.apellidoPaterno = "Perez"
      perfil.apellidoMaterno = "Perez"
      dependiente.perfil = perfil
    then:"Se intenta guardar el dependiente con un usuario inválido y la prueba debe fallar"
      shouldFail(RuntimeException) {
        dependiente = service.registrar(dependiente,usuarioExistente.id)
      }
  }

  def "Valida registro de dependientes, no se persisten duplicados, criterio: Matricula"(){
    given:"crear una institucion"
      def organizacion = new Institucion(nombre:"Escuela Superior de Computo").save(validate:false)
      def distribucionInstitucional = new DistribucionInstitucional(grado:3,
                                                                    grupo:"B")
      distribucionInstitucional.institucion=organizacion
      distribucionInstitucional.save(validate:false)
      def historialAcademico = new HistorialAcademico(distribucionInstitucional:distribucionInstitucional)
      historialAcademico.save(validate:false)

    and:
      def perfilExistente = new Perfil().save(validate:false)
      def dependiente = new Dependiente(matricula:"M1234576",
                                        camada:"1234567898",
                                        perfil:perfilExistente)
      dependiente.addToHistorialAcademico(historialAcademico)
    and:"Tengo un usuario registrado"
      Usuario.metaClass.isDirty = { true } 
      Usuario.metaClass.encodePassword = { "password" } 
      def usuario = new Usuario(username:"pepito@gmail.com",
                                password:UUID.randomUUID().toString().replaceAll('-', '').substring(0,10),
                                enabled:true)
      usuario.addToDependientes(dependiente)
      usuario.addToInstituciones(organizacion)
      usuario.save(validate:false)
    when:"Se intenta registrar un dependiente con la misma matricula del dependiente ya existente"
      def dependienteDuplicado = new Dependiente(matricula:"M1234576",camada:"987654321")
      dependienteDuplicado.addToHistorialAcademico(historialAcademico)
      def dependienteResultado = service.registrar(dependienteDuplicado,usuario.id,organizacion)

    then:"Los dependientes deben ser iguales, es decir, no se persistio el dependiente con la matricula ya existente"
      assert dependiente.matricula == dependienteResultado[0].matricula
      assert dependienteResultado[0].id > 0
      assert dependienteResultado[0].matricula == "M1234576"
      assert dependienteResultado[0].camada == "1234567898"
      assert dependienteResultado[0].usuario.id > 0
  }

}
