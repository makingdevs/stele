package com.stele

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification
import com.stele.seguridad.Usuario

@TestFor(ReporteMigracionService)
class ReporteMigracionServiceSpec extends Specification {

  def "Obtener conteo de dependientes por nivel escolar" () {
    when : "Llamamos al contador de datos"
      def totalDependientes = service.conteoDeDatosPorDependientes(estructuraInstitucional)

    then : "Los resultados son"
      assert totalDependientes == totalDependientesEsperados

    where :
      estructuraInstitucional                                       || totalDependientesEsperados
      ['20':['NIVEL':['1':['TURNO':['A' : [1,2,3,4,5,6,10]]]]]]     || 7
      ['21':['NIVEL':['1':['TURNO':['A' : [1,2,3,4,5,6,10,11]]]]]]  || 8
      ['22':['NIVEL':['1':['TURNO':['A' : [1,2,3], 'B' :[1,2]]]]]]  || 5
      ['22':['NIVEL':['1':['TURNO1':['A' : [1,2,3], 'B' :[1,2]],
                           'TURNO2':['A' : [1,2,3], 'B' :[1,2]]]]]] || 10
      ['22':['NIVEL':['1':['TURNO1':['A' : [1,2,3]]]],
             'NIVAL':['2':['TURNO2':['A' : [1,2,3], 'B' :[1,2]]]]]] || 8
  }

  def "Obtener conteo de dependientes por ciclo escolar" () {
    when : "Llamamos al contador de datos"
      def totalDependientes = service.conteoDeDependientesParaElNivel(estructuraInstitucional, 0)

    then : "Los resultados son"
      assert totalDependientes == totalDependientesEsperados

    where :
      estructuraInstitucional                                       || totalDependientesEsperados
      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3]]]]]]             || ['21': 3]
      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3]]]]],
       '22':['NIVAL':['2':['TURNO2':['A' : [1,2,3], 'B' :[1,2],
                                     'C' : [4,5,6]]]]]]             || ['21' : 3, '22' : 8] 
  }

  def "Obtener conteo de dependientes por nivel" () {
    when : "Llamamos al contador de datos"
      def totalDependientes = service.conteoDeDependientesParaElNivel(estructuraInstitucional, 1)

    then : "Los resultados son"
      assert totalDependientes == totalDependientesEsperados

    where :
      estructuraInstitucional                                       || totalDependientesEsperados
      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3]]]]]]             || ['21' : ['NIVEL': 3]]
      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3]]]]],
       '22':['NIVEL':['1':['TURNO1':['A' : [  6,7]]]]]]             || ['21' : ['NIVEL': 3], '22':['NIVEL':2]]
      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3], 'B' : [1,2]]]],
             'NIVEA':['1':['TURNO1':['A' : [1,2,3,4]]]]],
       '22':['NIVEL':['1':['TURNO1':['A' : [  6,7]]]]]]             || ['21' : ['NIVEL': 5, 'NIVEA':4], '22' : ['NIVEL':2]]
  }

  def "Obtener conteo de dependientes por nivel y grado" () {
    when : "Llamamos al contador de datos"
      def totalDependientes = service.conteoDeDependientesParaElNivel(estructuraInstitucional, 2)

    then : "Los resultados son"
      assert totalDependientes == totalDependientesEsperados

    where :
      estructuraInstitucional                                       || totalDependientesEsperados
      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3]]]]]]             || ['21':['NIVEL':['1': 3]]]

      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3]]]]],
       '22':['NIVEL':['1':['TURNO1':['A' : [  6,7]]]]]]             || ['21':['NIVEL':['1': 3]], '22':['NIVEL':['1':2]]]

      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3], 'B' : [1,2]]],
                      '2':['TURNO1':['A' : [1,2,3,5]]]]],
       '22':['NIVEL':['1':['TURNO1':['A' : [  6,7]]]]]]             || ['21':['NIVEL':['1': 5, '2':4]], '22':['NIVEL':['1':2]]]
  }

  def "Obtener conteo de dependientes por nivel, grado y turno" () {
    when : "Llamamos al contador de datos"
      def totalDependientes = service.conteoDeDependientesParaElNivel(estructuraInstitucional, 3)

    then : "Los resultados son"
      assert totalDependientes == totalDependientesEsperados

    where :
      estructuraInstitucional                                       || totalDependientesEsperados
      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3]]]]]]             || ['21':['NIVEL':['1':['TURNO1': 3]]]]

      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3]]]]],
       '22':['NIVEL':['1':['TURNO1':['A' : [  6,7]]]]]]             || ['21':['NIVEL':['1':['TURNO1': 3]]], '22':['NIVEL':['1':['TURNO1':2]]]]

      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3], 'B' : [1,2]]],
                      '2':['TURNO1':['A' : [1,2,3,5]],
                           'TURNO2':['A' : [1,2,3,5]]]]],
       '22':['NIVEL':['1':['TURNO1':['A' : [  6,7]]]]]]             || ['21':['NIVEL':['1':['TURNO1': 5], '2':['TURNO1':4, 'TURNO2':4]]], '22':['NIVEL':['1':['TURNO1':2]]]]
  }

  def "Obtener conteo de dependientes por nivel, grado, turno y grupo" () {
    when : "Llamamos al contador de datos"
      def totalDependientes = service.conteoDeDependientesParaElNivel(estructuraInstitucional, 4)

    then : "Los resultados son"
      assert totalDependientes == totalDependientesEsperados

    where :
      estructuraInstitucional                                       || totalDependientesEsperados
      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3]]]]]]             || ['21':['NIVEL':['1':['TURNO1':['A': 3]]]]]
      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3]]]]],
       '22':['NIVEL':['1':['TURNO1':['A' : [  6,7]]]]]]             || ['21':['NIVEL':['1':['TURNO1':['A': 3]]]], '22':['NIVEL':['1':['TURNO1':['A':2]]]]]

      ['21':['NIVEL':['1':['TURNO1':['A' : [1,2,3], 'B' : [1,2]]],
                      '2':['TURNO1':['A' : [1,2,3,5]],
                           'TURNO2':['A' : [1,2,3,5], 'B' : [1]]]]],
       '22':['NIVEL':['1':['TURNO1':['A' : [  6,7]]]]]]             || ['21':['NIVEL':['1':['TURNO1':['A': 3,'B':2]], 
                                                                                       '2':['TURNO1':['A':4],
                                                                                            'TURNO2':['A':4,'B':1]]]],
                                                                        '22':['NIVEL':['1':['TURNO1':['A':2]]]]]
  }

  def "Obtener conteo de usuarios" () {
    when : "Llamamos al contador de datos"
      def totalUsuarios = service.conteoDeUsuariosUnicosDeLaListaDeMapas(listaDeMapas)

    then : "Los resultados son"
      assert totalUsuarios == totalUsuariosEsperados

    where :
      totalUsuariosEsperados << [
        3, 1
      ]
      listaDeMapas << [
        [
          [ usuario : new Usuario(username:'a@b.com'), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(),
            cicloEscolar : new CicloEscolar()
          ],
          [ usuario : new Usuario(username:'a@b.com'), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(),
            cicloEscolar : new CicloEscolar()
          ],
          [ usuario : new Usuario(username:'b@q.com'), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(),
            cicloEscolar : new CicloEscolar()
          ],
          [ usuario : new Usuario(username:'l@l.com'), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(),
            cicloEscolar : new CicloEscolar()
          ]
        ],
        [
          [ usuario : new Usuario(username:'a@b.com'), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(),
            cicloEscolar : new CicloEscolar()
          ],
          [ usuario : new Usuario(username:'a@b.com'), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(),
            cicloEscolar : new CicloEscolar()
          ],
          [ usuario : new Usuario(username:'a@b.com'), 
            dependiente : new Dependiente(),
            distribucionInstitucional : new DistribucionInstitucional(),
            cicloEscolar : new CicloEscolar()
          ]
        ]
      ]
  }
}
