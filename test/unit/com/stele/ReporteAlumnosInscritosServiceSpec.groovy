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
	
	def "Obtener Niveles por institucion"() {
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
		when: "Se realiza la llamada al metodo obtenerNivelesDeEstudioPorInstitrucion"
		def listaDeGrupos = service.obtenerNivelesDeEstudioPorInstitrucion(institucion);
		then: "valida que la cantidad de niveles es 1"
		assert listaDeGrupos.size() == 1
	}
	
	def "Obtener Turnos por institucion"() {
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
		when: "Se realiza la llamada al metodo obtenerTurnosPorInstitrucion"
		def listaDeGrupos = service.obtenerTurnosPorInstitrucion(institucion);
		then: "valida que la cantidad de turnos es 1"
		assert listaDeGrupos.size() == 1
	}
}
