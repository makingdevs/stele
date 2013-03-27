package com.stele

import grails.test.mixin.*
import org.junit.*

import spock.lang.Specification

@TestFor(DatosEscolaresDomainWrapperService)
class DatosEscolaresDomainWrapperServiceSpec extends Specification {

  def "Convierte una lista de commands a una lista de mapas de objetos dominio"() {
    setup : "Inicializamos los commands"
      def commandList = obtenerCommands()

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
    [ new FilaExcelCommand(
      cicloEscolar:"",
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
      new FilaExcelCommand(cicloEscolar:""
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
      new FilaExcelCommand(cicloEscolar:""
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
