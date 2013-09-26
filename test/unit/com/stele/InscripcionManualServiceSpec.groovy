package com.stele

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import com.stele.seguridad.Usuario


@TestFor(InscripcionManualService)
@Mock([Institucion,Usuario,Dependiente,CicloEscolar,DistribucionInstitucional,HistorialAcademico])
class InscripcionManualServiceSpec extends Specification {

    def "Registrar un Alumno y un tutor nuevo"() {
      setup :
        Institucion institucion = new Institucion()
        institucion.nombre = institucionNombre
        institucion.save(validate:false)
      and : 
        InscripcionCommand command = new InscripcionCommand(
          cicloEscolar : cicloEscolar,
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
        def mocks = crearColaboradores()
      when :
        def registro = service.generarRegistroDeAlumnoYTutor(command, institucion)
        mocks*.verify()

      then : 
        assert registro.dependiente.camada.contains(institucionNombre.replaceAll(" ","_"))

      where :
        cicloEscolar | nombreAlumno | apellidoPaternoAlumno | apellidoMaternoAlumno | nivelDeEstudio | grado | grupo | turno      | matricula | nombrePadre | apellidoPaternoPadre | apellidoMaternoPadre | telefono    | email           | institucionNombre
         "2012/2013" | "sergio"     | "rodriguez"           | "duran"               | "SECUNDARIA"   | 3     | "b"   | "MATUTINO" | "M656565" | "Anegeles"  | "duran"              | "romero"             | "56565672"  | "angeles@m.com" | "Springfield Elementary school"

    }

    private def crearColaboradores() {
      Usuario user = new Usuario()
      Dependiente dependiente = new Dependiente(camada:"")
      DistribucionInstitucional distribucion = new DistribucionInstitucional()
      CicloEscolar cicloEscolar = new CicloEscolar()
      HistorialAcademico historialAcademico = new HistorialAcademico()

      def usuarioServiceMock = mockFor(UsuarioService)
      usuarioServiceMock.demand.obtenerUsuarioDesdeCommand(1..1){ obj -> return user}
      usuarioServiceMock.demand.registrar(1..1){ obj -> return user}
      service.usuarioService  = usuarioServiceMock.createMock()

      def dependienteServiceMock = mockFor(DependienteService)
      dependienteServiceMock.demand.obtenerDependienteDesdeCommand(1..1){ obj -> return dependiente}
      dependienteServiceMock.demand.registrar(1..1){ obj, obj2 -> return dependiente}
      service.dependienteService = dependienteServiceMock.createMock()

      def cicloEscolarMock = mockFor(CicloEscolarService)
      cicloEscolarMock.demand.obtenerCicloEscolarDesdeCommand(1..1){ obj-> return cicloEscolar}
      cicloEscolarMock.demand.registrar(1..1){-> return cicloEscolar}
      service.cicloEscolarService = cicloEscolarMock.createMock()

      def distribucionMock = mockFor(DistribucionInstitucionalService)
      distribucionMock.demand.obtenerDistribucionInstitucionalDesdeCommand(1..1){obj -> return distribucion}
      distribucionMock.demand.registrar(1..1){ obj, obj2 -> distribucion}
      service.distribucionInstitucionalService = distribucionMock.createMock()    

      def historialAcademicoMock = mockFor(HistorialAcademicoService)
      historialAcademicoMock.demand.preparaHistoricoAcademicoARegistrar(1..1){ obj, obj2 -> return historialAcademico}
      historialAcademicoMock.demand.registrar(1..1){ obj -> return historialAcademico}
      service.historialAcademicoService = historialAcademicoMock.createMock()

      [usuarioServiceMock, dependienteServiceMock, cicloEscolarMock, distribucionMock, historialAcademicoMock]
    }

}