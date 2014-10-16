package com.stele;

import org.codehaus.groovy.grails.plugins.jasper.JasperReportDef
import org.codehaus.groovy.grails.plugins.jasper.JasperExportFormat

class ReporteAlumnosInscritosController {
	
	def springSecurityService
	def reporteAlumnosInscritosService
	def jasperService

	def index() {
		def user = springSecurityService.currentUser
		def listaGrupos = reporteAlumnosInscritosService.obtenerGruposPorInstitrucion(user.instituciones[0])
		def listaGrados = reporteAlumnosInscritosService.obtenerGradosPorInstitrucion(user.instituciones[0])
		def listaNiveles = reporteAlumnosInscritosService.obtenerNivelesDeEstudioPorInstitrucion(user.instituciones[0])
		def listaTurnos = reporteAlumnosInscritosService.obtenerTurnosPorInstitrucion(user.instituciones[0])
		def dependientes = reporteAlumnosInscritosService.obtenerAlumnosInscritosPorNivelGradoGrupoYTurno(
			params.nivel != null && params.nivel.length() > 0 ? [(NivelDeEstudio)params.nivel] : listaNiveles, 
			params.grado != null && params.grado.length() > 0 ? [params.grado.toInteger()] : listaGrados, 
			params.grupo != null && params.grupo.length() > 0 ? [params.grupo] : listaGrupos,
			params.turno != null && params.turno.length() > 0 ? [(Turno)params.turno] : listaTurnos,
			user.instituciones[0])
		return [params:params, listaGrupos:listaGrupos, listaGrados:listaGrados, dependientes:dependientes, listaNiveles:listaNiveles, listaTurnos:listaTurnos]
	}
	
	def generaReporte() {
		def listaAlumnos = [];
		def user = springSecurityService.currentUser
		def listaGrupos = reporteAlumnosInscritosService.obtenerGruposPorInstitrucion(user.instituciones[0])
		def listaGrados = reporteAlumnosInscritosService.obtenerGradosPorInstitrucion(user.instituciones[0])
		def listaNiveles = reporteAlumnosInscritosService.obtenerNivelesDeEstudioPorInstitrucion(user.instituciones[0])
		def listaTurnos = reporteAlumnosInscritosService.obtenerTurnosPorInstitrucion(user.instituciones[0])
		def dependientes = reporteAlumnosInscritosService.obtenerAlumnosInscritosPorNivelGradoGrupoYTurno(
			params.nivel != null && params.nivel.length() > 0 ? [(NivelDeEstudio)params.nivel] : listaNiveles,
			params.grado != null && params.grado.length() > 0 ? [params.grado.toInteger()] : listaGrados,
			params.grupo != null && params.grupo.length() > 0 ? [params.grupo] : listaGrupos,
			params.turno != null && params.turno.length() > 0 ? [(Turno)params.turno] : listaTurnos,
			user.instituciones[0])
		dependientes.each {
			listaAlumnos.add([nombrePadreOTutor:it.usuario.perfil.nombre + it.usuario.perfil.apellidoPaterno + it.usuario.perfil.apellidoMaterno,
                              correo:it.usuario.username,
                              telefono:it.usuario.perfil.telefonos.numeroTelefonico[0],
                              matricula:it.matricula,
                              nombreAlumno:it.perfil.nombre + it.perfil.apellidoPaterno + it.perfil.apellidoMaterno,
                              nivel:it.historialAcademico.distribucionInstitucional.nivelDeEstudio[0],
                              grado:it.historialAcademico.distribucionInstitucional.grado[0],
                              grupo:it.historialAcademico.distribucionInstitucional.grupo[0],
                              turno:it.historialAcademico.distribucionInstitucional.turno[0],
                              cobros:"2,000.00",
                              pagos:"2,000.00",
                              saldo:"0.00"])
		}
		def report = new JasperReportDef(name:"reporteAlumnosInscritos.jasper",fileFormat:JasperExportFormat.CSV_FORMAT,
										 reportData:listaAlumnos,
										 locale:Locale.getDefault())
		response.setContentType("application/csv")
		response.setHeader "Content-disposition", "attachment; filename=" + user.instituciones[0].name.replaceAll(" ", "_") + "_alumnosInscritos.csv";
		response.outputStream << jasperService.generateReport(report).toByteArray()
	}
}
