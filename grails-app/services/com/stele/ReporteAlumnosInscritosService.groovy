package com.stele

import org.grails.datastore.gorm.finders.MethodExpression.InList;

import com.stele.seguridad.Usuario

class ReporteAlumnosInscritosService {

	def obtenerGradosPorInstitrucion(Institucion institucion) {
		def lista = []
		def filtro = institucion.distribucionesInstitucionales.findAll() {lista += it.grado}
		lista.unique()
	} 
	
	def obtenerGruposPorInstitrucion(Institucion institucion) {
		def lista = []
		def filtro = institucion.distribucionesInstitucionales.findAll {lista += it.grupo}
		lista.unique()
	}
	
	def obtenerNivelesDeEstudioPorInstitrucion(Institucion institucion) {
		def lista = []
		def filtro = institucion.distribucionesInstitucionales.findAll {lista += it.nivelDeEstudio}
		lista.unique()
	}
	
	def obtenerTurnosPorInstitrucion(Institucion institucion) {
		def lista = []
		def filtro = institucion.distribucionesInstitucionales.findAll {lista += it.turno}
		lista.unique()
	}
	
	def obtenerAlumnosInscritosPorNivelGradoGrupoYTurno(def niveles, def grados, def grupos, def turnos, Institucion institucion) {
		def criteria = Dependiente.createCriteria()
		criteria.list { 
			historialAcademico {
				distribucionInstitucional {
					eq('institucion', institucion)
					'in'('grado', grados)
					'in'('nivelDeEstudio', niveles)
					'in'('turno', turnos)
					'in'('grupo', grupos)
				}
			}
		}
	}
}

