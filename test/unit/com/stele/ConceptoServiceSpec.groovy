package com.stele

import grails.test.mixin.*
import spock.lang.Specification
import com.stele.seguridad.Usuario

@TestFor(ConceptoService)
@Mock([Institucion,Usuario,DistribucionInstitucional,Concepto,Perfil])
class ConceptoServiceSpec extends Specification {

    def "Obtener un listado de los conceptos ligados a una Institucion"() {
  given: "Se crearan 2 conceptos asociados a una Institucion deacuerdo al Usuario"
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
    def usuario = new Usuario()
    def perfilUsuario = new Perfil()
    def concepto1 = new Concepto()
    def concepto2 = new Concepto()
    usuario.id = 103123
    usuario.username = "sergio@makingdevs.com"
    usuario.password = UUID.randomUUID().toString().replaceAll('-', '').substring(0,10)
    usuario.enabled = true
    perfilUsuario.nombre = "Jose"
    perfilUsuario.apellidoPaterno = "Hernandez"
    perfilUsuario.apellidoMaterno = "Solis"
    perfilUsuario.save()
    usuario.perfil = perfilUsuario
    usuario.addToInstituciones(institucion)
    usuario.save()
    concepto1.id = 1
    concepto1.concepto = "Colegiatura"
    concepto1.institucion = institucion
    concepto1.save()
    concepto2.id = 2
    concepto2.concepto = "Primera colegiatura"
    concepto2.institucion = institucion
    concepto2.save()
  when: "Se realiza la llamada al metodo buscarConceptosDeUnaInstitucion"
    def query = "gia"
    def conceptoInstitucion = service.buscarConceptosDeUnaInstitucion(usuario, query)
  then: "la cantidad de conceptos debe de ser igual a 2"
    assert conceptoInstitucion.size() == 2

    }

}