package com.stele

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll
import com.stele.seguridad.Usuario
import com.makingdevs.Perfil

@TestFor(ProcesamientoMasivoService)
@Mock([Institucion,Usuario,Dependiente,CicloEscolar,DistribucionInstitucional,HistorialAcademico,Institucion])
class ProcesamientoMasivoServiceSpec extends Specification {

  @Unroll("Guardar la información de un dependiente y de un tutor que no haya sido registrado anteriormente")
  def "Guardar la información de un tutor y su dependiente"(){
    given:"la información un usuario y su dependiente proveniente de una fila del archivo Excel"
      def institucion = new Institucion(name:'Escuela Superior de Cómputo').save(validate:false)
      Usuario usuario = new Usuario(username:'egjimenezg@gmail.com',
                                    instituciones: [institucion])

      Perfil perfil = new Perfil(nombre:"Gamaliel",apellidoPaterno:"Jiménez",apellidoMaterno:"García")

      Dependiente dependiente = new Dependiente(matricula:"M986350",
                                                perfil:perfil) 

      CicloEscolar cicloEscolar = new CicloEscolar(clave:'2014/2015')

      DistribucionInstitucional distribucion = new DistribucionInstitucional(
                                                   grado:"4",
                                                   grupo:"A",
                                                   nivelDeEstudio:NivelDeEstudio.BACHILLERATO)


      def filaExcelParaPersistir = [usuario:usuario,
                                    dependiente:dependiente,
                                    cicloEscolar:cicloEscolar,
                                    distribucionInstitucional:distribucion] 
     
      def usuarioServiceMock = mockFor(UsuarioService)
      def dependienteServiceMock = mockFor(DependienteService)
      def cicloEscolarServiceMock = mockFor(CicloEscolarService)
      def distribucionInstitucionalServiceMock = mockFor(DistribucionInstitucionalService)
      def historialAcademicoServiceMock = mockFor(HistorialAcademicoService)

      usuarioServiceMock.demand.registrar(1..1){ Usuario u, Institucion i -> return usuario.save(validate:false) } 
            
      dependienteServiceMock.demand.registrar(1..1){ Dependiente d,Long userId, Institucion i -> return dependiente.save(validate:false)} 

      cicloEscolarServiceMock.demand.registrar(1..1){ CicloEscolar ce -> return cicloEscolar.save(validate:false) }
            
      distribucionInstitucionalServiceMock.demand.registrar(1..1){ DistribucionInstitucional distribucionInstitucional,institucionId ->
        distribucion.save(validate:false) 
      }

      def historialAcademicoMock = new HistorialAcademico()

      historialAcademicoServiceMock.demand.preparaHistoricoAcademicoARegistrar(1..1){ Dependiente dependiente_, DistribucionInstitucional distribucion_institucional ->
        historialAcademicoMock 
      }
      historialAcademicoServiceMock.demand.registrar(1..1){ HistorialAcademico historialAcademico ->
        historialAcademicoMock.save(validate:false) 
      }

      service.usuarioService = usuarioServiceMock.createMock()
      service.dependienteService = dependienteServiceMock 
      service.cicloEscolarService = cicloEscolarServiceMock.createMock() 
      service.distribucionInstitucionalService = distribucionInstitucionalServiceMock.createMock() 
      service.historialAcademicoService = historialAcademicoServiceMock.createMock()
    when:

      def registrosPersistidos = service.procesaMapaConDatosDeFilaDeExcelParaPersistir(filaExcelParaPersistir,institucion.id)

      usuarioServiceMock.verify()
      dependienteServiceMock.verify()
      cicloEscolarServiceMock.verify()
      distribucionInstitucionalServiceMock.verify() 
      historialAcademicoServiceMock.verify() 
    then:
      registrosPersistidos.usuario.id > 0
      registrosPersistidos.dependiente.id > 0
      registrosPersistidos.cicloEscolar.id > 0 
      registrosPersistidos.distribucionInstitucional.id > 0
      registrosPersistidos.historialAcademico.id > 0
  }
  

    def "Procesa una fila de datos unica"(){
      setup:
        Usuario user = new Usuario()
        def usuarioServiceMock = mockFor(UsuarioService)
        usuarioServiceMock.demand.registrar(1..1) { obj, obj2 -> return user.save(validate:false) }
        service.usuarioService = usuarioServiceMock.createMock()
        def dependienteServiceMock = mockFor(DependienteService)
        dependienteServiceMock.demand.registrar(1..1) { Dependiente dependiente, Long id -> new Dependiente().save(validate:false) }
        service.dependienteService = dependienteServiceMock.createMock()
        def cicloEscolarServiceMock = mockFor(CicloEscolarService)
        cicloEscolarServiceMock.demand.registrar(1..1) { CicloEscolar cicloEscolar -> new CicloEscolar().save(validate:false) }
        service.cicloEscolarService = cicloEscolarServiceMock.createMock()
        def distribucionInstitucionalServiceMock = mockFor(DistribucionInstitucionalService)
        distribucionInstitucionalServiceMock.demand.registrar(1..1) { DistribucionInstitucional distribucionInstitucional, Long id -> new DistribucionInstitucional().save(validate:false) }
        service.distribucionInstitucionalService = distribucionInstitucionalServiceMock.createMock()
        def historialAcademicoServiceMock = mockFor(HistorialAcademicoService)
        def historialAcademicoMock = new HistorialAcademico()
        historialAcademicoServiceMock.demand.preparaHistoricoAcademicoARegistrar(1..1) { Dependiente dependiente, DistribucionInstitucional distribucionInstitucional -> historialAcademicoMock }
        historialAcademicoServiceMock.demand.registrar(1..1) { HistorialAcademico historialAcademico -> historialAcademicoMock.save(validate:false) }
        service.historialAcademicoService = historialAcademicoServiceMock.createMock()
      and:
        Institucion institucion = new Institucion()
        institucion.save(validate:false)
      when:
        def filaDeExcelParaPersistir = [usuario: new Usuario(),
                                        dependiente: new Dependiente(),
                                        cicloEscolar: new CicloEscolar(),
                                        distribucionInstitucional: new DistribucionInstitucional()]
        def mapaDeObjetosPersistidos = service.procesaMapaConDatosDeFilaDeExcelParaPersistir(filaDeExcelParaPersistir, institucion.id)
        println mapaDeObjetosPersistidos
      then:
        assert mapaDeObjetosPersistidos.usuario.id > 0
        assert mapaDeObjetosPersistidos.cicloEscolar.id > 0
        assert mapaDeObjetosPersistidos.distribucionInstitucional.id > 0
    }

}

