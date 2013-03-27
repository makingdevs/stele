package com.stele

import grails.test.mixin.*
import org.junit.*

import spock.lang.Specification
import com.stele.seguridad.Usuario

@TestFor(DatosEscolaresDomainWrapperService)
class DatosEscolaresDomainWrapperServiceSpec extends Specification {

  def "Convierte una lista de commands a una lista de mapas de objetos dominio"() {
    setup : "Inicializamos los commands"
      def commandList = obtenerCommands()
      def usuarioServiceMock = mockFor(UsuarioService)
      usuarioServiceMock.demand.obtenerUsuarioDesdeCommand(0..3) { new Usuario() }
      service.usuarioService = usuarioServiceMock.createMock()
      def dependienteServiceMock = mockFor(DependienteService)
      dependienteServiceMock.demand.obtenerDependienteDesdeCommand(0..3) { new Dependiente() }
      service.dependienteService = dependienteServiceMock.createMock()
      def cicloEscolarServiceMock = mockFor(CicloEscolarService)
      cicloEscolarServiceMock.demand.obtenerCicloEscolarDesdeCommand(0..3) { new CicloEscolar() }
      service.cicloEscolarService = cicloEscolarServiceMock.createMock()
      def distribucionInstitucionalMock = mockFor(DistribucionInstitucionalService)
      distribucionInstitucionalMock.demand.obtenerDistribucionInstitucionalDesdeCommand(0..3) { new DistribucionInstitucional() }
      service.distribucionInstitucionalService = distribucionInstitucionalMock.createMock()

    when : "Llamamos al método para convertir los commands a mapas"
      def resultado = service.obtenerListaDeMapasDesdeListaDeCommands(commandList)
    then : "Los resultados son"
      assert resultado.size() == 3 
      assert resultado.collect{ r -> r.find {k,v -> v.class == Usuario} }.size() == 3 
      assert resultado.collect{ r -> r.find {k,v -> v.class == Dependiente} }.size() == 3
      assert resultado.collect{ r -> r.find {k,v -> v.class == CicloEscolar} }.size() == 3
      assert resultado.collect{ r -> r.find {k,v -> v.class == DistribucionInstitucional} }.size() == 3
    
  }

  private def obtenerCommands() {
    [ new FilaExcelCommand(cicloEscolar:"",
      tutorNombre:"",
      tutorApellidoPaterno:"",
      tutorApellidoMaterno:"",
      correoElectronico:"",
      telefono:"",
      matricula:"",
      dependienteApellidoPaterno:"", 
      dependienteApellidoMaterno:"", 
      dependienteNombre:"",
      nivel:"",
      grado:"",
      grupo:"",
      turno:""),
      new FilaExcelCommand(cicloEscolar:"",
      tutorNombre:"",
      tutorApellidoPaterno:"",
      tutorApellidoMaterno:"",
      correoElectronico:"",
      telefono:"",
      matricula:"",
      dependienteApellidoPaterno:"", 
      dependienteApellidoMaterno:"", 
      dependienteNombre:"",
      nivel:"",
      grado:"",
      grupo:"",
      turno:""),
      new FilaExcelCommand(cicloEscolar:"",
      tutorNombre:"",
      tutorApellidoPaterno:"",
      tutorApellidoMaterno:"",
      correoElectronico:"",
      telefono:"",
      matricula:"",
      dependienteApellidoPaterno:"", 
      dependienteApellidoMaterno:"", 
      dependienteNombre:"",
      nivel:"",
      grado:"",
      grupo:"",
      turno:"")
     ]
  }


}
