package com.stele

import grails.test.mixin.*
import spock.lang.Specification
import spock.lang.Unroll
import com.stele.seguridad.Usuario
import com.makingdevs.*

@TestFor(PagoService)
@Mock([HistorialAcademico,Dependiente,DistribucionInstitucional,Institucion,Usuario,Perfil,Pago])
class PagoServiceSpec extends Specification {

  @Unroll("Crear un pago con el concepto: '#conceptoDePago', vencimiento: '#fechaDeVencimiento' y la cantidad: '\$ #cantidadDePago'")
  def "Crear un pago con el concepto: '#conceptoDePago', vencimiento: '#fechaDeVencimiento' y la cantidad: '#cantidadDePago'"(){
    when:
      def pago = service.crearPago(conceptoDePago,fechaDeVencimiento, cantidadDePago)
    then:
      pago.id > 0
      pago.transactionId
      pago.conceptoDePago == conceptoDePago
      pago.fechaDeVencimiento.date  == fechaDeVencimiento.date
      pago.fechaDeVencimiento.month  == fechaDeVencimiento.month
      pago.fechaDeVencimiento.year  == fechaDeVencimiento.year
      pago.cantidadDePago == cantidadDePago
      pago.tipoDePago == TipoDePago.TRANSFERENCIA_BANCARIA
      pago.estatusDePago == EstatusDePago.CREADO
      pago.recargosAcumulados == recargosAcumulados
      pago.descuentoAplicable == descuentoAplicable
      pago.descuentos.size() == descuentos
      pago.recargos.size() == recargos
    where:
      conceptoDePago  | fechaDeVencimiento  | cantidadDePago ||  recargosAcumulados  | descuentoAplicable  | descuentos  | recargos
      "Inscripción"   | new Date() + 30     | 1234.45        || 0                    | 0                   | 0           | 0
      "Colegiatura"   | new Date() + 40     | 1345.98        || 0                    | 0                   | 0           | 0
  }

  def "Obtener todos los pagos ligados a un usuario existente"() {
    given: "Se crean dos pagos asociados a un determinado usuario con un dependiente asosiado"
      def institucion = new Institucion()
      institucion.nombre = "Kinder Peques"
      def distribucionInstitucional = new DistribucionInstitucional()
      distribucionInstitucional.grado = 2
      distribucionInstitucional.grupo = "B+"
      distribucionInstitucional.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
      distribucionInstitucional.turno = Turno.VESPERTINO
      institucion.addToDistribucionesInstitucionales(distribucionInstitucional)
      institucion.save(flush:true)
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
      perfilExistente.save()
      usuarioExistente.perfil = perfilExistente
      usuarioExistente.save(flush:true)
      def dependiente = new Dependiente()
      dependiente.matricula = "M0987654"
      dependiente.camada = "1234567898"
      dependiente.perfil = perfilExistente
      dependiente.usuario = usuarioExistente
      dependiente.save()
      HistorialAcademico historialAcademico = new HistorialAcademico()
      historialAcademico.distribucionInstitucional = distribucionInstitucional
      historialAcademico.dependiente = dependiente
      historialAcademico.save(flush:true)
      Pago pagoUno = new Pago()
      Pago pagoDos = new Pago()
      pagoUno.conceptoDePago = "Pago 1"
      pagoDos.conceptoDePago = "Pago 2"
      pagoUno.cantidadDePago = 12345678
      pagoDos.cantidadDePago = 87654321
      pagoUno.fechaDePago = new Date()
      pagoDos.fechaDePago = new Date()
      pagoUno.historialAcademico = historialAcademico
      pagoDos.historialAcademico = historialAcademico
      dependiente.addToPagos(pagoUno)
      dependiente.addToPagos(pagoDos)
      dependiente.save(flush:true)
    when: "Se hace la llamada al metodo obtenerPagosDeUsuario"    
      def pagosDeUusario = service.obtenerPagosDeUsuario(usuarioExistente)
    then: "La cantidad de pagos debe ser igual a 2"
      assert pagosDeUusario.size() > 0
  }

  def "Obtener todos los pagos ligados a la institucion del usuario"() {
    given: "Se crean dos pagos asociados a un determinado usuario con un dependiente asosiado"
      def institucion = new Institucion()
      institucion.nombre = "Kinder Peques"
      def distribucionInstitucional = new DistribucionInstitucional()
      distribucionInstitucional.grado = 2
      distribucionInstitucional.grupo = "B+"
      distribucionInstitucional.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
      distribucionInstitucional.turno = Turno.VESPERTINO
      institucion.addToDistribucionesInstitucionales(distribucionInstitucional)
      institucion.save(flush:true)
      Usuario.metaClass.isDirty = { true } 
      Usuario.metaClass.encodePassword = { "password" } 
      def usuarioExistente = new Usuario()
      def perfilExistente = new Perfil()
      usuarioExistente.id = 1001
      usuarioExistente.username = "pepito@gmail.com"
      usuarioExistente.password = UUID.randomUUID().toString().replaceAll('-', '').substring(0,10)
      usuarioExistente.enabled = true
      usuarioExistente.addToInstituciones(institucion) 
      perfilExistente.nombre = "Pepito"
      perfilExistente.apellidoPaterno = "Juarez"
      perfilExistente.apellidoMaterno = "Juarez"
      perfilExistente.save()
      usuarioExistente.perfil = perfilExistente
      usuarioExistente.save(flush:true)
      def dependiente = new Dependiente()
      dependiente.matricula = "M0987654"  
      dependiente.camada = "1234567898"
      dependiente.perfil = perfilExistente
      dependiente.usuario = usuarioExistente
      dependiente.save()
      HistorialAcademico historialAcademico = new HistorialAcademico()
      historialAcademico.distribucionInstitucional = distribucionInstitucional
      historialAcademico.dependiente = dependiente
      historialAcademico.save(flush:true)
      Pago pagoUno = new Pago()
      Pago pagoDos = new Pago()
      pagoUno.conceptoDePago = "Pago 1"
      pagoDos.conceptoDePago = "Pago 2"
      pagoUno.cantidadDePago = 12345678
      pagoDos.cantidadDePago = 87654321
      pagoUno.fechaDePago = new Date()
      pagoDos.fechaDePago = new Date()
      pagoUno.historialAcademico = historialAcademico
      pagoDos.historialAcademico = historialAcademico
      dependiente.addToPagos(pagoUno)
      dependiente.addToPagos(pagoDos)
      dependiente.save(flush:true)
    when: "Se realiza la llamada al metodo obtenerPagosXInstitucion"
      def pagoInstitucion = service.obtenerPagosDeUnaInstitucion(usuarioExistente)
    then: "la cantidad de pagos debe de ser 2"
      assert pagoInstitucion.size() == 2
  }

  def "Obtener los pagos vencidos en estatus CREADO"() {
    given: "Se crearan 2 pagos en con una fecha vencimiento menor a la fecha actual"
      def institucion = new Institucion()
      institucion.nombre = "Kinder Peques"
      def distribucionInstitucional = new DistribucionInstitucional()
      distribucionInstitucional.grado = 2
      distribucionInstitucional.grupo = "B+"
      distribucionInstitucional.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
      distribucionInstitucional.turno = Turno.VESPERTINO
      institucion.addToDistribucionesInstitucionales(distribucionInstitucional)
      institucion.save(flush:true)
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
      perfilExistente.save(flush:true)
      usuarioExistente.perfil = perfilExistente
      usuarioExistente.save(flush:true)
      def dependiente = new Dependiente()
      dependiente.matricula = "M0987654"
      dependiente.camada = "1234567898"
      dependiente.perfil = perfilExistente
      dependiente.usuario = usuarioExistente
      dependiente.save(flush:true)
      HistorialAcademico historialAcademico = new HistorialAcademico()
      historialAcademico.distribucionInstitucional = distribucionInstitucional
      historialAcademico.dependiente = dependiente
      historialAcademico.save()
      Pago pagoUno = new Pago()
      Pago pagoDos = new Pago()
      pagoUno.conceptoDePago = "Pago 1"
      pagoDos.conceptoDePago = "Pago 2"
      pagoUno.cantidadDePago = 1000
      pagoDos.cantidadDePago = 2000
      pagoUno.fechaDeVencimiento = new Date() - 1
      pagoDos.fechaDeVencimiento = new Date() - 3
      pagoUno.historialAcademico = historialAcademico
      pagoDos.historialAcademico = historialAcademico
      pagoUno.estatusDePago = EstatusDePago.CREADO
      pagoDos.estatusDePago = EstatusDePago.CREADO
      dependiente.addToPagos(pagoUno)
      dependiente.addToPagos(pagoDos)
      dependiente.save() 
      List listaPagos = [pagoUno,pagoDos]
    when: "Se llama al servicio que busca los pagos que esten es estatus creado y con fecha vencimiento pasada"
      def pagosVencidos = service.cambiarEstatusDeUnPagoAVencido  (listaPagos)
    then: "Se verifica que los pagos esten en estatus vencido"
      assert pagosVencidos.size() == 2
      assert pagosVencidos.first().estatusDePago == EstatusDePago.VENCIDO
  }


}
