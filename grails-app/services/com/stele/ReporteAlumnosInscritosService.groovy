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
	
	def obtenerAlumnosInscritosPorNivelGradoGrupoYTurno(def niveles, def grados, def grupos, def turnos, Usuario usuario) {
		usuario.dependientes.findAll()
	}
}
