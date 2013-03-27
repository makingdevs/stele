package com.stele

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import com.stele.seguridad.*

@TestFor(EstructuraInstitucionalService)
class EstructuraInstitucionalServiceSpec extends Specification  {

  def "Obtener la estructura institucional"() {
    when : "Llamamos al método para obtener la estructura"
      def estructuraOrganizacional = service.obtenerEstructuraDesdeListaDeMapaDeDominios(listaMapaDominios)
    then : "Los resultados esperados son : "
      assert estructuraOrganizacional.size() == estructuraOrganizacionalEsperada.size()
      assert estructuraOrganizacional.toString() == estructuraOrganizacionalEsperada.toString()

    where : 
      listaMapaDominios << [
        [
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12") ]
        ]
      ]

      estructuraOrganizacionalEsperada << [
        [
          [
            "2011-12" : [
              PRIMARIA : [
                "1" : [
                  MATUTINO : [
                    "A" : [
                      new Dependiente()
                    ],
                    "B" : [
                      new Dependiente()
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
  }

}
