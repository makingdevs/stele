package com.stele;

import com.payable.PaymentStatus;

class ReporteAlumnosCobrosController {
	
	def springSecurityService
	def reporteAlumnosCobrosService
	def reporteAlumnosInscritosService

	def index() {
		try {
			def user = springSecurityService.currentUser
			def listaGrupos = reporteAlumnosInscritosService.obtenerGruposPorInstitrucion(user.instituciones[0])
			def listaGrados = reporteAlumnosInscritosService.obtenerGradosPorInstitrucion(user.instituciones[0])
			def listaNiveles = reporteAlumnosInscritosService.obtenerNivelesDeEstudioPorInstitrucion(user.instituciones[0])
			def listaTurnos = reporteAlumnosInscritosService.obtenerTurnosPorInstitrucion(user.instituciones[0])
			if(listaGrupos && listaGrados && listaNiveles && listaTurnos) {
				def dependientes = reporteAlumnosInscritosService.obtenerAlumnosInscritosPorNivelGradoGrupoYTurno(
					params.nivel != null && params.nivel.length() > 0 ? [(NivelDeEstudio)params.nivel] : listaNiveles,
					params.grado != null && params.grado.length() > 0 ? [params.grado.toInteger()] : listaGrados,
					params.grupo != null && params.grupo.length() > 0 ? [params.grupo] : listaGrupos,
					params.turno != null && params.turno.length() > 0 ? [(Turno)params.turno] : listaTurnos,
					user.instituciones[0])
				return[listaCobrosTodos:reporteAlumnosCobrosService.obtenerPagosDeAlumnos(null, null, "", "", dependientes),
					   listaCobrosGenerados:reporteAlumnosCobrosService.obtenerPagosDeAlumnosPorEstatus(null, null, "", "", dependientes, PaymentStatus.CREATED),
					   listaCobrosPorCanciliar:reporteAlumnosCobrosService.obtenerPagosDeAlumnosPorEstatus(null, null, "", "", dependientes, PaymentStatus.PROCESS),
					   listaCobrosConcialiados:reporteAlumnosCobrosService.obtenerPagosDeAlumnosPorEstatus(null, null, "", "", dependientes, PaymentStatus.PAID),
					   listaCobrosRechazados:reporteAlumnosCobrosService.obtenerPagosDeAlumnosPorEstatus(null, null, "", "", dependientes, PaymentStatus.REJECTED),
					   listaCobrosVencidos:reporteAlumnosCobrosService.obtenerPagosDeAlumnosPorEstatus(null, null, "", "", dependientes, PaymentStatus.EXPIRED)]
			} else flash.error = "No se encontraron registros de alumnos."
		} catch(Exception e) {
			e.printStackTrace()
			flash.error = "No se encontraron registros de alumnos."
		}
	}
	
}
