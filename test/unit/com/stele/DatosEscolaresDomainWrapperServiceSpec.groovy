package com.stele

import grails.test.mixin.*
import org.junit.*

import spock.lang.Specification

@TestFor(DatosEscolaresDomainWrapperService)
class DatosEscolaresDomainWrapperServiceSpec extends Specification {

  def "Convierte una lista de commands a una lista de mapas de objetos dominio"() {
    setup : "Inicializamos los commands"
      def commands = obtenerCommands(params)

    when : "Llamamos al método para convertir los commands a mapas"
      def resultado = service.obtenerListaDeMapasDesdeListaDeCommands(commands)
    then : "Los resultados son"
      assert resultado.size() == commands.size()

    where :
      params << [
        [cicloEscolar:"2012/2013",
         tutorNombre:"Felipe",
         tutorApellidoPaterno:"Juárez",
         tutorApellidoMaterno:"Murillo",
         correoElectronico:"fjuarez@gmail.com",
         telefono:"1234567890",
         matricula:"M123456",
         dependienteApellidoPaterno:"Juárez",
         dependienteApellidoMaterno:"Murrieta",
         dependienteNombre:"Felipe Jr.",
         nivel:"Primaria", grado:"4", grupo:"A",
         turno:"Matutino"
        ]
      ]
  }

  private def obtenerCommands(params) {
    new FilaExcelCommand(cicloEscolar:params.cicloEscolar,
                         tutorNombre:parans.tutorNombre,
                         tutorApellidoPaterno:params.tutorApellidoPaterno,
                         tutorApellidoMaterno:params.tutorApellidoMaterno,
                         correoElectronico:params.correoElectronico,
                         telefono:params.telefono,
                         matricula:params.matricula,
                         dependienteApellidoPaterno:params.dependienteApellidoPaterno,
                         dependienteApellidoMaterno:params.dependienteApellidoMaterno,
                         dependienteNombre:params.dependienteNombre,
                         nivel:params.nivel, 
                         grado:params.grado, 
                         grupo:params.grupo,
                         turno:params.turno)
  }


}
