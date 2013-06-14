package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PerfilService)
@Mock(Perfil)
class PerfilServiceSpec extends Specification{

  def "Resgistro de un nuevo perfil"(){
    given: "Un ciclo escolar con datos"
      def perfil = new Perfil()
      perfil.nombre = "Peter"
      perfil.apellidoPaterno = "Pan"
      perfil.apellidoMaterno = "Jamas"
      perfil.fechaDeNacimiento = new Date()
      perfil.sexo = Sexo.MASCULINO
    when: "Guardamos perfil con el servicio"
      perfil = service.registrar(perfil)
    then: "El id debe ser mayor que 0"
      assert perfil.id > 0
  }
}
