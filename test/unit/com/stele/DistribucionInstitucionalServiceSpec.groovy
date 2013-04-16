package com.stele

import static org.junit.Assert.*

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(DistribucionInstitucionalService)
@Mock([Institucion,DistribucionInstitucional])
class DistribucionInstitucionalServiceSpec extends Specification{

    @Unroll("#datosBasicos")
    def "Obtener una distribucion organizacional apartir de un command leeido desde un excel"(){

      given:
        def filaExcelCommand = new FilaExcelCommand(datosBasicos) 
      when:
        def distribucionInstitucional = service.obtenerDistribucionInstitucionalDesdeCommand(filaExcelCommand)
      then:
        assert distribucionInstitucional.grado == gradoEsperado
        assert distribucionInstitucional.grupo == grupoEsperado 
        assert distribucionInstitucional.nivelDeEstudio == nivelDeEstudioEsperado
        assert distribucionInstitucional.turno == turnoEsperado     
      where:
        datosBasicos << [
          [grado:"2",grupo:"C",nivel:"Primaria",turno:"Matutino"],
          [grado:"2",grupo:"C",nivel:"PRI",turno:"Noche"],
          [grado:"2",grupo:"C",nivel:"PRIMARIA",turno:"Mat"],
          [grado:"2",grupo:"C",nivel:"priMaria",turno:"Mañ."],
          [grado:"2",grupo:"C",nivel:"PRImaria",turno:"Vesp"],
          [grado:"2",grupo:"C",nivel:"PrImArIa",turno:"vespertino"],
          [grado:"2",grupo:"C",nivel:"PrI.",turno:"tarde"],
          [grado:"3",grupo:"a",nivel:"Secundaria",turno:"Tard."],
          [grado:"3",grupo:"a",nivel:"Secu",turno:"noc."],
          [grado:"3",grupo:"a",nivel:"SECUNDARIA",turno:"nocturno"],
          [grado:"3",grupo:"a",nivel:"seCU",turno:"v"],
          [grado:"",grupo:"",nivel:"",turno:""],
          [grado:"1",grupo:"f",nivel:"bacho",turno:"t"],
          [grado:"4",grupo:"g+",nivel:"edu sup",turno:"T"]
        ]
        gradoEsperado << [
          2,
          2,
          2,
          2,
          2,
          2,
          2,
          3,
          3,
          3,
          3,
          0,
          1,
          4
        ]
        grupoEsperado << [
          "C",
          "C",
          "C",
          "C",
          "C",
          "C",
          "C",
          "A",
          "A",
          "A",
          "A",
          "",
          "F",
          "G+"
        ]
        nivelDeEstudioEsperado  << [
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.PRIMARIA,
        
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.SECUNDARIA,
          NivelDeEstudio.SECUNDARIA,
          NivelDeEstudio.SECUNDARIA,
          NivelDeEstudio.SECUNDARIA,
          NivelDeEstudio.PRIMARIA,
          NivelDeEstudio.BACHILLERATO,
          NivelDeEstudio.EDUCACION_SUPERIOR

        ]
        turnoEsperado << [
          Turno.MATUTINO,
          Turno.NOCTURNO,
          Turno.MATUTINO,
          Turno.MATUTINO,
          Turno.VESPERTINO,
          Turno.VESPERTINO,
          Turno.VESPERTINO,
          Turno.VESPERTINO,
          Turno.NOCTURNO,
          Turno.NOCTURNO,
          Turno.VESPERTINO,
          Turno.VESPERTINO,
          Turno.VESPERTINO,
          Turno.VESPERTINO
        ]
    }

    def "Crear una distribucion institucional en una institucion"(){
      given: "Una institucion y una distribucion institucional"
        def institucion = new Institucion()
        institucion.nombre = "Kinder Peques"
        institucion = institucion.save()

        def distribucionInstitucional = new DistribucionInstitucional()
        distribucionInstitucional.grado = 2
        distribucionInstitucional.grupo = "B+"
        distribucionInstitucional.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
        distribucionInstitucional.turno = Turno.VESPERTINO
      when: "Intento guardar la distribucion institucional"
        distribucionInstitucional = service.registrar(distribucionInstitucional,institucion.id)
        institucion = Institucion.get(institucion.id)
      then: "El id de distribucion intitucional es > 0 y el tamaño de distribuciones institucionales debe ser mayor en 1" 
        assert distribucionInstitucional.id > 0
        assert institucion.distribucionesInstitucionales.size() == 1
    }

    def "Crear una distribucion institucional en una institucion"(){
      given: "Una institucion y una distribucion institucional"
      when: "Intento guardar la distribucion institucional ya existente"
      then: "El id de distribucion intitucional es 1 y el tamaño de distribuciones institucionales debe ser igual al tamaño inicial"
    }
}
