package com.stele

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import com.stele.seguridad.Usuario

@TestFor(ProcesamientoMasivoService)
@Mock([Usuario,Dependiente,CicloEscolar,DistribucionInstitucional,HistorialAcademico,Institucion])
class ProcesamientoMasivoServiceSpec extends Specification {

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
      then:
        assert mapaDeObjetosPersistidos.usuario.id > 0
        assert mapaDeObjetosPersistidos.dependiente.id > 0
        assert mapaDeObjetosPersistidos.cicloEscolar.id > 0
        assert mapaDeObjetosPersistidos.distribucionInstitucional.id > 0
    }

}

