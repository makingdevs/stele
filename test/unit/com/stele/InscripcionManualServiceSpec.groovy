package com.stele

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.*
import com.stele.seguridad.Usuario

@TestFor(InscripcionManualService)
@Mock([Institucion,Usuario,Dependiente,CicloEscolar,DistribucionInstitucional,HistorialAcademico])
class InscripcionManualServiceSpec extends Specification {

  def "Registrar un Alumno y un tutor nuevo"() {
    setup :
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
    then : 
      assert registro.message == "Se ha inscrito correctamente al dependiente" 
  }
 
  @Ignore
  def "Registrar un alumno con una matrícula repetida en la misma institución"() {
    given : "Un dependiente inscrito en la institución"
      Institucion institucion = new Institucion()
      institucion.name = institucionNombre
      institucion.save(validate:false)
    and : 
      InscripcionCommand command = new InscripcionCommand(cicloEscolar : cicloEscolar,
                                                          nombreAlumno : nombreAlumno,
                                                          apellidoPaternoAlumno : apellidoPaternoAlumno,
                                                          apellidoMaternoAlumno : apellidoMaternoAlumno,
                                                          nivelDeEstudio : nivelDeEstudio,
                                                          grado : grado,
                                                          grupo : grupo,
                                                          turno : turno,
                                                          matricula : matricula,
                                                          nombrePadre : nombrePadre,
                                                          apellidoPaternoPadre : apellidoPaternoPadre,
                                                          apellidoMaternoPadre : apellidoMaternoPadre,
                                                          telefono : telefono,
                                                          email : email)
    and :
      Usuario user = new Usuario()
      createMockForUserService()
      
    when :
      def registro = service.generarRegistroDeAlumnoYTutor(command, institucion)
      mocks*.verify()
    then : 
      assert registro instanceof LinkedHashMap

    where :
      cicloEscolar | nombreAlumno | apellidoPaternoAlumno | apellidoMaternoAlumno | nivelDeEstudio | grado | grupo | turno      | matricula | nombrePadre | apellidoPaternoPadre | apellidoMaternoPadre | telefono    | email           | institucionNombre
      "2014/2015"  | "Gamaliel"   | "Jiménez"             | "García"              | "SECUNDARIA"   | 3     | "C"   | "MATUTINO" | "M656565" | "Anegeles"  | "duran"              | "romero"             | "56565672"  | "angeles@m.com" | "Springfield Elementary school"
  }

  
}
