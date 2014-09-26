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

      usuarioServiceMock.demand.registrar(1..1){ Usuario u, Institucion i -> usuario.save(validate:false) } 
           
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
      service.dependienteService = dependienteServiceMock.createMock() 
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
  
}

