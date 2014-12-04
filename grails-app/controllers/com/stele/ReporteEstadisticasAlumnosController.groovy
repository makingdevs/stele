package com.stele;

import com.sun.org.apache.xalan.internal.xsltc.compiler.ForEach;

class ReporteEstadisticasAlumnosController {
	
	def springSecurityService
	def reporteAlumnosInscritosService
	def reporteEstadisticasAlumnosService
	
	def index() {
		def listaAlumnos = [];
		def user = springSecurityService.currentUser
		def listaGrupos = reporteAlumnosInscritosService.obtenerGruposPorInstitrucion(user.instituciones[0]).sort()
		def listaGrados = reporteAlumnosInscritosService.obtenerGradosPorInstitrucion(user.instituciones[0]).sort()
		def listaNiveles = reporteAlumnosInscritosService.obtenerNivelesDeEstudioPorInstitrucion(user.instituciones[0]).sort()
		def listaTurnos = reporteAlumnosInscritosService.obtenerTurnosPorInstitrucion(user.instituciones[0]).sort()
		def dependientes = reporteAlumnosInscritosService.obtenerAlumnosInscritosPorNivelGradoGrupoYTurno(listaNiveles, listaGrados, listaGrupos, listaTurnos, user.instituciones[0])
		dependientes.each {
			listaAlumnos.add([nombrePadreOTutor:it.usuario.perfil.nombre + it.usuario.perfil.apellidoPaterno + it.usuario.perfil.apellidoMaterno,
                              correo:it.usuario.username,
                              telefono:it.usuario.perfil.telefonos.numeroTelefonico[0],
                              matricula:it.matricula,
                              nombreAlumno:it.perfil.nombre + it.perfil.apellidoPaterno + it.perfil.apellidoMaterno,
                              nivel:it.historialAcademico.distribucionInstitucional.nivelDeEstudio[0],
                              grado:it.historialAcademico.distribucionInstitucional.grado[0],
                              grupo:it.historialAcademico.distribucionInstitucional.grupo[0],
                              turno:it.historialAcademico.distribucionInstitucional.turno[0]])
		}
		def estadisticasPorNivel = reporteEstadisticasAlumnosService.obtenerEstadisticasAlumnosPorNivel(listaAlumnos, listaNiveles)
		def estadisticasPorGradoYNivel = reporteEstadisticasAlumnosService.obtenerEstadisticasAlumnosPorGradoYNivel(listaAlumnos, listaGrados.sort({ a, b -> b.value <=> a.value }), listaNiveles)
		def estadisticasPorNivelGradoYGrupo = reporteEstadisticasAlumnosService.obtenerEstadisticasAlumnosPorNivelGrupoYGrado(listaAlumnos, listaNiveles, listaGrupos, listaGrados.sort())
		return [estadisticas:estadisticasPorNivel, estadisticasPorGradoYNivel:estadisticasPorGradoYNivel, 
			listaNiveles:listaNiveles, estadisticasPorNivelGradoYGrupo:estadisticasPorNivelGradoYGrupo]
	}
}
