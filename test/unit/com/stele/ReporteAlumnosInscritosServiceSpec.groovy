
package com.stele;

import com.makingdevs.Perfil
import com.stele.seguridad.Usuario;

import grails.test.mixin.*
import spock.lang.Specification;

@TestFor(ReporteAlumnosInscritosService)
@Mock([Institucion,DistribucionInstitucional, Dependiente, HistorialAcademico, Usuario])
class ReporteAlumnosInscritosServiceSpec extends Specification {

	def "Obtener Grados por institucion"() {
		given: "Se crea institucion con distribuciones institucionales"
		def institucion = new Institucion()
		institucion.name = "Escuela primaria"
		def distribucionInstitucional = new DistribucionInstitucional()
		distribucionInstitucional.grado = 4
		distribucionInstitucional.grupo = "B+"
		distribucionInstitucional.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
		distribucionInstitucional.turno = Turno.VESPERTINO
		def distribucionInstitucionalDos = new DistribucionInstitucional()
		distribucionInstitucionalDos.grado = 1
		distribucionInstitucionalDos.grupo = "B+"
		distribucionInstitucionalDos.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
		distribucionInstitucionalDos.turno = Turno.VESPERTINO
		def distribucionInstitucionalTres = new DistribucionInstitucional()
		distribucionInstitucionalTres.grado = 1
		distribucionInstitucionalTres.grupo = "B+"
		distribucionInstitucionalTres.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
		distribucionInstitucionalTres.turno = Turno.VESPERTINO
		institucion.addToDistribucionesInstitucionales(distribucionInstitucional)
		institucion.addToDistribucionesInstitucionales(distribucionInstitucionalDos)
		institucion.addToDistribucionesInstitucionales(distribucionInstitucionalTres)
		institucion.save(flush:true)
		when: "Se realiza la llamada al metodo obtenerGradosPorInstitrucion"
		def listaDeGrados = service.obtenerGradosPorInstitrucion(institucion);
		then: "valida que la cantidad de grados es 2"
		assert listaDeGrados.size() == 2
	}

	def "Obtener Grupos por institucion"() {
		given: "Se crea institucion con distribuciones institucionales"
		def institucion = new Institucion()
		institucion.name = "Escuela primaria"
		def distribucionInstitucional = new DistribucionInstitucional()
		distribucionInstitucional.grado = 4
		distribucionInstitucional.grupo = "B"
		distribucionInstitucional.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
		distribucionInstitucional.turno = Turno.VESPERTINO
		def distribucionInstitucionalDos = new DistribucionInstitucional()
		distribucionInstitucionalDos.grado = 1
		distribucionInstitucionalDos.grupo = "B"
		distribucionInstitucionalDos.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
		distribucionInstitucionalDos.turno = Turno.VESPERTINO
		def distribucionInstitucionalTres = new DistribucionInstitucional()
		distribucionInstitucionalTres.grado = 1
		distribucionInstitucionalTres.grupo = "A"
		distribucionInstitucionalTres.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
		distribucionInstitucionalTres.turno = Turno.VESPERTINO
		institucion.addToDistribucionesInstitucionales(distribucionInstitucional)
		institucion.addToDistribucionesInstitucionales(distribucionInstitucionalDos)
		institucion.addToDistribucionesInstitucionales(distribucionInstitucionalTres)
		institucion.save(flush:true)
		when: "Se realiza la llamada al metodo obtenerGruposPorInstitrucion"
		def listaDeGrupos = service.obtenerGradosPorInstitrucion(institucion);
		then: "valida que la cantidad de grupos es 2"
		assert listaDeGrupos.size() == 2
	}
	
	def "obtener Alumnos inscritos por filtros"() {
		given: "Se crea Usuario con despendientes asigandos"
		
		def institucion = new Institucion()
		institucion.name = "Escuela primaria"
		def distribucionInstitucional = new DistribucionInstitucional()
		distribucionInstitucional.grado = 4
		distribucionInstitucional.grupo = "B"
		distribucionInstitucional.nivelDeEstudio = NivelDeEstudio.PRIMARIA
		distribucionInstitucional.turno = Turno.VESPERTINO
		def distribucionInstitucionalDos = new DistribucionInstitucional()
		distribucionInstitucionalDos.grado = 1
		distribucionInstitucionalDos.grupo = "B"
		distribucionInstitucionalDos.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
		distribucionInstitucionalDos.turno = Turno.VESPERTINO
		def distribucionInstitucionalTres = new DistribucionInstitucional()
		distribucionInstitucionalTres.grado = 1
		distribucionInstitucionalTres.grupo = "A"
		distribucionInstitucionalTres.nivelDeEstudio = NivelDeEstudio.SECUNDARIA
		distribucionInstitucionalTres.turno = Turno.VESPERTINO
		institucion.addToDistribucionesInstitucionales(distribucionInstitucional)
		institucion.addToDistribucionesInstitucionales(distribucionInstitucionalDos)
		institucion.addToDistribucionesInstitucionales(distribucionInstitucionalTres)
		institucion.save(flush:true)
		
		
		def dependienteUno = new Dependiente()
		dependienteUno.matricula = "001"
		dependienteUno.perfil = new Perfil(nombre: "Pedro", apellidoPaterno: "Juarez")
		def historialUno = new HistorialAcademico(distribucionInstitucional: distribucionInstitucional, dependiente: dependienteUno)
		dependienteUno.historialAcademico = [historialUno]
		dependienteUno.save(flush:true)
		
		def dependienteDos = new Dependiente()
		dependienteDos.matricula = "002"
		dependienteDos.perfil = new Perfil(nombre: "Rosa", apellidoPaterno: "Celeste")
		def historialDos = new HistorialAcademico(distribucionInstitucional: distribucionInstitucionalDos, dependiente: dependienteDos)
		dependienteDos.historialAcademico = [historialDos]
		dependienteDos.save(flush:true)
		
		def dependienteTres = new Dependiente()
		dependienteTres.matricula = "002"
		dependienteTres.perfil = new Perfil(nombre: "Juan", apellidoPaterno: "Suarez")
		def historialTres = new HistorialAcademico(distribucionInstitucional: distribucionInstitucionalTres, dependiente: dependienteTres)
		dependienteTres.historialAcademico = [dependienteTres]
		dependienteTres.save(flush:true)
		
		def usuario = new Usuario()
		usuario.username = "pedrito"
		usuario.instituciones = [institucion]
		usuario.dependientes = [dependienteUno, dependienteDos, dependienteTres]
		usuario.save(flush:true)
		
		
		when: "Se realiza la llamada al metodo obtenerAlumnosInscritosPorNivelGradoGrupoYTurno"
		def listaAlumnosInscritos = service.obtenerAlumnosInscritosPorNivelGradoGrupoYTurno(["PRIMARIA", "SECUNDARIA"], [1,2,4], ["A", "B"], ["VESPERTINO"], usuario)
		then: "valida que la cantidad de grupos es 3"
		assert listaAlumnosInscritos.size() == 3
	}
}
