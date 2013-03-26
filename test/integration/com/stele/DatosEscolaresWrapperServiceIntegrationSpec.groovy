package com.stele

import grails.plugin.spock.IntegrationSpec

class DatosEscolaresWrapperServiceIntegrationSpec extends IntegrationSpec {

  def datosEscolaresWrapperService

  def "De acuerdo a una ruta de archivo debe regresar una lista de filas"() {
    when : "Ejecutamos el método de conversión"
      List<FilaExcelCommand> resultados = datosEscolaresWrapperService.convertirACommandsArchivo('test/integration/com/stele/layout.xls')

    then : "Obtenemos : "
      assert resultados.size() == commandsEsperados.size()
      resultados.eachWithIndex { obj, i ->
        assert obj.cicloEscolar == commandsEsperados[i].cicloEscolar
        assert obj.tutorNombre == commandsEsperados[i].tutorNombre
        assert obj.tutorApellidoPaterno == commandsEsperados[i].tutorApellidoPaterno
        assert obj.tutorApellidoMaterno == commandsEsperados[i].tutorApellidoMaterno
        assert obj.correoElectronico == commandsEsperados[i].correoElectronico
        assert obj.telefono == commandsEsperados[i].telefono
        assert obj.matricula == commandsEsperados[i].matricula
        assert obj.dependienteApellidoPaterno == commandsEsperados[i].dependienteApellidoPaterno
        assert obj.dependienteApellidoMaterno == commandsEsperados[i].dependienteApellidoMaterno
        assert obj.dependienteNombre == commandsEsperados[i].dependienteNombre
        assert obj.nivel == commandsEsperados[i].nivel
        assert obj.grado == commandsEsperados[i].grado
        assert obj.grupo == commandsEsperados[i].grupo
        assert obj.turno == commandsEsperados[i].turno
      }

    where :
      commandsEsperados << [
        [
          new FilaExcelCommand(cicloEscolar:"2012/2013",
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
                               turno:"Matutino"),
          new FilaExcelCommand(cicloEscolar:"2012/2013",
                               tutorNombre:"José Juan",
                               tutorApellidoPaterno:"Reyes",
                               tutorApellidoMaterno:"Zuñiga",
                               correoElectronico:"neodevelop@gmail.com",
                               telefono:"3456789012",
                               matricula:"M002344",
                               dependienteApellidoPaterno:"Reyes",
                               dependienteApellidoMaterno:"Bernal",
                               dependienteNombre:"María Fernanda",
                               nivel:"Secundaria", grado:"3", grupo:"C",
                               turno:"Vespertino"),
          new FilaExcelCommand(cicloEscolar:"2012/2013",
                               tutorNombre:"Rockdrigo",
                               tutorApellidoPaterno:"Martínez",
                               tutorApellidoMaterno:"García",
                               correoElectronico:"rockdrogmg@gmail.com",
                               telefono:"6748398792",
                               matricula:"M986350",
                               dependienteApellidoPaterno:"Martínez",
                               dependienteApellidoMaterno:"Carrera",
                               dependienteNombre:"Rockdriguito",
                               nivel:"Primaria",grado:"5",grupo:"A",
                               turno:"Matutino")
        ]
      ]
  }


}
