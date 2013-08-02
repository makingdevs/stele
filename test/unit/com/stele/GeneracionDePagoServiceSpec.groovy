package com.stele

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import com.stele.seguridad.Usuario

@TestFor(GeneracionDePagoService)
@Mock([Pago, Dependiente, HistorialAcademico, Perfil, Institucion,Usuario,DistribucionInstitucional,ConceptoService, Concepto])
class GeneracionDePagoServiceSpec extends Specification {

  void "Generacion de pago para una camada"() {
    setup:
      Dependiente dependiente = new Dependiente(camada:camada)
      dependiente.addToHistorialAcademico(new HistorialAcademico())
      dependiente.save(validate:false)
      def institucion = new Institucion()
      institucion.nombre = "Escuela primaria de Springfild"
      def distribucionInstitucional = new DistribucionInstitucional()
      distribucionInstitucional.grado = 4
      distribucionInstitucional.grupo = "B+"
      distribucionInstitucional.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
      distribucionInstitucional.turno = Turno.VESPERTINO
      institucion.addToDistribucionesInstitucionales(distribucionInstitucional)
      institucion.save(flush:true)
      Usuario.metaClass.isDirty = { true }
      Usuario.metaClass.encodePassword = {"password"}
      Usuario usuario = new Usuario()
      def perfilUsuario = new Perfil()
      def concepto1 = new Concepto()
      usuario.id = 1033
      usuario.username = "sergio@makingdevs.com"
      usuario.password = UUID.randomUUID().toString().replaceAll('-', '').substring(0,10)
      usuario.enabled = true
      perfilUsuario.nombre = "Jose"
      perfilUsuario.apellidoPaterno = "Hernandez"
      perfilUsuario.apellidoMaterno = "Solis"
      usuario.perfil = perfilUsuario
      usuario.addToInstituciones(institucion)
      usuario.save()
      

    and :
      CamadaPagoCommand cmd = new CamadaPagoCommand(camada:camada,
        conceptoDePago:concepto,
        cantidadDePago:monto,
        fechaDeVencimiento:fechaDeVencimiento)

    when :
      def pagos = service.paraCamadaPagoCommand(cmd, usuario)

    then :
      assert pagos.size() == 1
      assert pagos.first().id > 0
      assert pagos.first().conceptoDePago == concepto
      
    where :
      camada | concepto   | monto | fechaDeVencimiento
      "123"  | "concepto" | 1.00  | new Date() + 7
  }

}
