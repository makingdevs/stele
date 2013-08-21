package com.stele

import grails.test.mixin.*
import spock.lang.Specification
import com.stele.seguridad.Usuario
import com.makingdevs.*

@TestFor(EstatusPagoService)
@Mock([Institucion, Usuario,Dependiente,HistorialAcademico,DistribucionInstitucional,Institucion, Perfil, Pago])
class EstatusPagoServiceSpec extends Specification {
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
      def pagosVencidos = service.cambioEstatusVencidoDeUnPago(listaPagos)
    then: "solo voy a mostrar"
      assert pagosVencidos.size() == 2
      assert pagosVencidos.first().estatusDePago == EstatusDePago.VENCIDO
    }

}