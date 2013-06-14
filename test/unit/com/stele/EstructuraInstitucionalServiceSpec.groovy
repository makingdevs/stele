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
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ]
        ],
        [
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"B", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ]
        ],
        [
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ]
        ],
        [
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.VESPERTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ]
        ],
        [
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:2, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ]
        ],
        [
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.SECUNDARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ]
        ],
        [
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2012-13")
          ]
        ],
        [
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"B", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"C", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ]
        ],
        [
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"B", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"C", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"B", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ]
        ],
        [
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"B", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.VESPERTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"B", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:2, grupo:"A", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"B", turno:Turno.VESPERTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:1, grupo:"A", turno:Turno.VESPERTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:2, grupo:"B", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:2, grupo:"A", turno:Turno.VESPERTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:2, grupo:"B", turno:Turno.VESPERTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:2, grupo:"B", turno:Turno.MATUTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ],
          [ usuario : new Usuario(), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(nivelDeEstudio : NivelDeEstudio.PRIMARIA, grado:2, grupo:"A", turno:Turno.VESPERTINO),
            cicloEscolar : new CicloEscolar(clave:"2011-12")
          ]
        ]
      ]

      estructuraOrganizacionalEsperada << [
        [ "2011-12" : [ PRIMARIA : [ "1" : [ MATUTINO : [ "A" : [ new Dependiente() ] ] ] ] ] ],
        [ "2011-12" : [ PRIMARIA : [ "1" : [ MATUTINO : [ "A" : [ new Dependiente() ],
                                                          "B" : [ new Dependiente() ] ] ] ] ] ],
        [ "2011-12" : [ PRIMARIA : [ "1" : [ MATUTINO : [ "A" : [ new Dependiente(), new Dependiente() ] ] ] ] ] ],
        [ "2011-12" : [ PRIMARIA : [ "1" : [ MATUTINO   : [ "A" : [ new Dependiente() ] ],
                                             VESPERTINO : [ "A" : [ new Dependiente() ] ] ] ] ] ],
        [ "2011-12" : [ PRIMARIA : [ "1" : [ MATUTINO : [ "A" : [ new Dependiente() ] ] ],
                                     "2" : [ MATUTINO : [ "A" : [ new Dependiente() ] ] ] ] ] ],
        [ "2011-12" : [ PRIMARIA   : [ "1" : [ MATUTINO : [ "A" : [ new Dependiente() ] ] ] ],
                        SECUNDARIA : [ "1" : [ MATUTINO : [ "A" : [ new Dependiente() ] ] ] ] ] ],
        [ "2011-12" : [ PRIMARIA : [ "1" : [ MATUTINO : [ "A" : [ new Dependiente() ] ] ] ] ],
          "2012-13" : [ PRIMARIA : [ "1" : [ MATUTINO : [ "A" : [ new Dependiente() ] ] ] ] ] ],
        [ "2011-12" : [ PRIMARIA : [ "1" : [ MATUTINO : [ "A" : [ new Dependiente() ],
                                                          "B" : [ new Dependiente() ],
                                                          "C" : [ new Dependiente() ] ] ] ] ] ],
        [ "2011-12" : [ PRIMARIA : [ "1" : [ MATUTINO : [ "A" : [ new Dependiente() ],
                                                          "B" : [ new Dependiente(), new Dependiente() ],
                                                          "C" : [ new Dependiente() ] ] ] ] ] ],
        [ "2011-12" : [ PRIMARIA : [ "1" : [ MATUTINO   : [ "A" : [ new Dependiente() ],
                                                            "B" : [ new Dependiente(), new Dependiente() ] ],
                                             VESPERTINO : [ "A" : [ new Dependiente(), new Dependiente() ],
                                                            "B" : [ new Dependiente() ] ] ],
                                     "2" : [ MATUTINO   : [ "A" : [ new Dependiente() ],
                                                            "B" : [ new Dependiente(), new Dependiente() ] ],
                                             VESPERTINO : [ "A" : [ new Dependiente(), new Dependiente() ],
                                                            "B" : [ new Dependiente() ] ] ] ] ] ]
      ]
  }
}
