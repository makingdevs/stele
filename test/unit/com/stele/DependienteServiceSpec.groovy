package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification


@TestFor(DependienteService)
class DependienteServiceSpec extends Specification{

    def "Obtener un dependiente apartir de un command leeido desde un excel"(){

      given:
        def filaExcelCommand = new FilaExcelCommand(datosBasicos) 
      when:
        def dependiente = service.obtenerDependienteDesdeCommand(filaExcelCommand)
      then:
        assert dependiente.perfil.nombre == nombreEsperado
        assert dependiente.perfil.apellidoPaterno == apellidoPaternoEsperado
        assert dependiente.perfil.apellidoMaterno == apellidoMaternoEsperado
      where:
        datosBasicos << [
          [dependienteNombre:"Pedrito",dependienteApellidoPaterno:"López",dependienteApellidoMaterno:"Arellano"],
          [dependienteNombre:"Memito",dependienteApellidoPaterno:"López",dependienteApellidoMaterno:"Arellano"]
        ]
        nombreEsperado << [
          "Pedrito",
          "Memito"
        ]
        apellidoPaternoEsperado << [
          "López",
          "López"
        ]
        apellidoMaternoEsperado << [
          "Arellano",
          "Arellano"
        ]
    }
}
