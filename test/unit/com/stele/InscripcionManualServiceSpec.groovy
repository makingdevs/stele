package com.stele

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.*
import com.stele.seguridad.Usuario

@TestFor(InscripcionManualService)
@Mock([Institucion,Usuario,Dependiente,CicloEscolar,DistribucionInstitucional,HistorialAcademico])
class InscripcionManualServiceSpec extends Specification {

  def "registrar un Alumno y un tutor nuevo"() {
    given :
      Institucion institucion = new Institucion(name:"Springfield Elementary school").save(validate:false)
    and : 
      InscripcionCommand command = new InscripcionCommand(cicloEscolar : "2012/2013",
                                                          nombreAlumno : "Sergio",
                                                          apellidoPaternoAlumno : "Rodriguez",
                                                          apellidoMaternoAlumno : "Duran",
                                                          nivelDeEstudio : "SECUNDARIA",
                                                          grado : 3,
                                                          grupo : "B",
                                                          turno : "MATUTINO",
                                                          matricula : "M656565",
                                                          nombrePadre : "Angeles",
                                                          apellidoPaternoPadre : "Duran",
                                                          apellidoMaternoPadre : "Romero",
                                                          telefono : "56565672",
                                                          email : "angeles@m.com")
    and :
      Dependiente dependiente = new Dependiente(matricula:command.matricula)
      Usuario usuario = new Usuario(username:"egjimenezg@gmail.com",
                                    instituciones:[institucion])

      def usuarioServiceMock = mockFor(UsuarioService)
      def dependienteServiceMock = mockFor(DependienteService) 
      def cicloEscolarServiceMock = mockFor(CicloEscolarService) 
      def distribucionInstitucionalServiceMock = mockFor(DistribucionInstitucionalService)
      def historialAcademicoServiceMock = mockFor(HistorialAcademicoService) 

      usuarioServiceMock.demand.obtenerUsuarioDesdeCommand{InscripcionCommand cmd -> usuario} 
      usuarioServiceMock.demand.registrar{ Usuario u, Institucion i -> usuario.save(validate:false)}
      dependienteServiceMock.demand.obtenerDependienteDesdeCommand{InscripcionCommand cmd -> dependiente}
      dependienteServiceMock.demand.registrar{ Dependiente d, Long userId, Institucion i -> return dependiente.save(validate:false) }
      cicloEscolarServiceMock.demand.obtenerCicloEscolarDesdeCommand{obj -> return new CicloEscolar() }
      distribucionInstitucionalServiceMock.demand.obtenerDistribucionInstitucionalDesdeCommand{ InscripcionCommand cmd -> new DistribucionInstitucional() }
      
      cicloEscolarServiceMock.demand.registrar{ new CicloEscolar().save(validate:false) }
      distribucionInstitucionalServiceMock.demand.registrar{DistribucionInstitucional d, Long institucionId -> new DistribucionInstitucional().save(validate:false) }
      historialAcademicoServiceMock.demand.preparaHistoricoAcademicoARegistrar{ Dependiente d, DistribucionInstitucional distribucionInstitucional -> new HistorialAcademico() }
      historialAcademicoServiceMock.demand.registrar{ HistorialAcademico historialAcademico -> new HistorialAcademico()}

      service.usuarioService = usuarioServiceMock.createMock()
      service.dependienteService = dependienteServiceMock.createMock()
      service.cicloEscolarService = cicloEscolarServiceMock.createMock()
      service.distribucionInstitucionalService = distribucionInstitucionalServiceMock.createMock()
      service.historialAcademicoService = historialAcademicoServiceMock.createMock()

    when :
      def registro = service.generarRegistroDeAlumnoYTutor(command, institucion)
      usuarioServiceMock.verify()
      dependienteServiceMock.verify()
      cicloEscolarServiceMock.verify()
      distribucionInstitucionalServiceMock.verify()
      historialAcademicoServiceMock.verify()
    then : 
      assert registro.message == "Se ha inscrito correctamente al dependiente" 
  }


  def "no registrar un alumno con una matrícula que ya ha sido registrada en la misma institucion"() {
    given :
      Institucion institucion = new Institucion(name:"Springfield Elementary school").save(validate:false)
      Dependiente dependienteExistente = new Dependiente(matricula:"M999999").save(validate:false)
    and : 
      InscripcionCommand command = new InscripcionCommand(cicloEscolar : "2014/2015",
                                                          nombreAlumno : "Gamaliel",
                                                          apellidoPaternoAlumno : "Jimenez",
                                                          apellidoMaternoAlumno : "Garcia",
                                                          nivelDeEstudio : "SECUNDARIA",
                                                          grado : 3,
                                                          grupo : "C",
                                                          turno : "VESPERTINO",
                                                          matricula : "M999999",
                                                          nombrePadre : "Salvador",
                                                          apellidoPaternoPadre : "Jiménez",
                                                          apellidoMaternoPadre : "Domínguez",
                                                          telefono : "5548109233",
                                                          email : "gamaliel@makingdevs.com")
    and :
      Dependiente nuevoDependiente = new Dependiente(matricula:command.matricula)
      Usuario usuario = new Usuario(username:"egjimenezg@gmail.com",
                                    instituciones:[institucion])

      def usuarioServiceMock = mockFor(UsuarioService)
      def dependienteServiceMock = mockFor(DependienteService) 

      usuarioServiceMock.demand.obtenerUsuarioDesdeCommand{InscripcionCommand cmd -> usuario} 
      usuarioServiceMock.demand.registrar{ Usuario u, Institucion i -> usuario.save(validate:false)}
      dependienteServiceMock.demand.obtenerDependienteDesdeCommand{InscripcionCommand cmd -> nuevoDependiente}
      dependienteServiceMock.demand.registrar{ Dependiente d, Long userId, Institucion i -> return [dependienteExistente] }

      service.usuarioService = usuarioServiceMock.createMock()
      service.dependienteService = dependienteServiceMock.createMock()

    when :
      def registro = service.generarRegistroDeAlumnoYTutor(command, institucion)
      usuarioServiceMock.verify()
      dependienteServiceMock.verify()
    then : 
      assert registro.error == "Ya existe un dependiente con la misma matricula"
  }
 
}
