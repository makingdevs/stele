package com.stele

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification

@TestFor(FilaExcelCommandService)
class FilaExcelCommandServiceSpec extends Specification {

  def "Deberia convertir una fila de datos obtenidos en excel a objetos command"() {
    when : "Llamamos al servicio de procesamiento"
      FilaExcelCommand command = service.convertirACommand(filaDeExcel)
    then : "Los resultados deben ser"
      assert command
      assert command.cicloEscolar == "cicloEscolar"
      assert command.tutorNombre == "tutorNombre"
      assert command.tutorApellidoPaterno == "tutorApellidoPaterno"
      assert command.tutorApellidoMaterno == "tutorApellidoMaterno"
      assert command.correoElectronico == "correoElectronico"
      assert command.telefono == "telefono"
      assert command.matricula == "matricula"
      assert command.dependienteApellidoPaterno == "dependienteApellidoPaterno"
      assert command.dependienteApellidoMaterno == "dependienteApellidoMaterno"
      assert command.dependienteNombre == "dependienteNombre"
      assert command.nivel == "nivel"
      assert command.grado == "grado"
      assert command.grupo == "grupo"

    where :
      filaDeExcel << [
        ["cicloEscolar", "tutorNombre", "tutorApellidoPaterno", "tutorApellidoMaterno","correoElectronico", "telefono","matricula","dependienteApellidoPaterno", "dependienteApellidoMaterno", "dependienteNombre", "nivel", "grado", "grupo"]
      ]

      resultado << [
        [new FilaExcelCommand(cicloEscolar:"cicloEscolar",
          tutorNombre:"tutorNombre",
          tutorApellidoPaterno:'tutorApellidoPaterno',
          tutorApellidoMaterno:'tutorApellidoMaterno',
          correoElectronico:'correoElectronico',
          telefono:'telefono',
          matricula:'matricula',
          dependienteApellidoPaterno:'dependienteApellidoPaterno ',
          dependienteApellidoMaterno:'dependienteApellidoMaterno ',
          dependienteNombre:'dependienteNombre',
          nivel:'nivel',
          grado:'grado',
          grupo:'grupo')]
      ]
  }

  def "Deberia convertir una lista de datos en lista de commands"() {
    when : "Llamamos al servicio de obtener lista de commands"
      def listaDeCommands = service.convertirListaACommands(filasDelExcel)
    then : "Los resultados deberian ser : "
      assert listaDeCommands.size() == resultado.size()
      listaDeCommands.each {
        assert it instanceof FilaExcelCommand
      }

      listaDeCommands*.tutorNombre == resultado*.tutorNombre

    where : 
      filasDelExcel << [
        [
          ["1","2","3","4","5","6","7","8","9","10","11","12","13"],
          ["1","2","3","4","5","6","7","8","9","10","11","12","14"]
        ]
      ]

      resultado << [
        [
          new FilaExcelCommand(cicloEscolar:"1", tutorNombre:"2", tutorApellidoPaterno:'3', tutorApellidoMaterno:'4', correoElectronico:'5', telefono:'6', 
                                matricula:'7', dependienteApellidoPaterno:'8', dependienteApellidoMaterno:'9', dependienteNombre:'10', nivel:'11', grado:'12', 
                                grupo:'13'),
          new FilaExcelCommand(cicloEscolar:"1", tutorNombre:"2", tutorApellidoPaterno:'3', tutorApellidoMaterno:'4', correoElectronico:'5', telefono:'6', 
                                matricula:'7', dependienteApellidoPaterno:'8', dependienteApellidoMaterno:'9', dependienteNombre:'10', nivel:'11', grado:'12', 
                                grupo:'14')
        ]
      ]

  }

}
