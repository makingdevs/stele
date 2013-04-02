package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll


@TestFor(DependienteService)
class DependienteServiceSpec extends Specification{

    @Unroll("#datosBasicos")
    def "Obtener un dependiente apartir de un command leeido desde un excel"(){

      given:
        def filaExcelCommand = new FilaExcelCommand(datosBasicos) 
      when:
        def dependiente = service.obtenerDependienteDesdeCommand(filaExcelCommand)
      then:
        assert dependiente.matricula == matriculaEsperada
        assert dependiente.perfil.nombre == nombreEsperado
        assert dependiente.perfil.apellidoPaterno == apellidoPaternoEsperado
        assert dependiente.perfil.apellidoMaterno == apellidoMaternoEsperado
      where:
        datosBasicos << [
          [matricula:"1234567",dependienteNombre:"Pedrito",dependienteApellidoPaterno:"López",dependienteApellidoMaterno:"Arellano"],
          [matricula:"LKJHGFDT",dependienteNombre:"Memito",dependienteApellidoPaterno:"López",dependienteApellidoMaterno:"Arellano"]
        ]
        matriculaEsperada << [
          "1234567",
          "LKJHGFDT"
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
