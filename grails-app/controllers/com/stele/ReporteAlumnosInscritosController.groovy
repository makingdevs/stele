package com.stele;

import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.plugins.jasper.JasperReportDef
import org.codehaus.groovy.grails.plugins.jasper.JasperExportFormat

import com.sun.org.apache.xalan.internal.xsltc.compiler.ForEach;

class ReporteAlumnosInscritosController {
	
	def springSecurityService
	def reporteAlumnosInscritosService
	def jasperService
	def sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES"))

	def index() {
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
		
			return [params:params, listaGrupos:listaGrupos, listaGrados:listaGrados, dependientes:dependientes, listaNiveles:listaNiveles, listaTurnos:listaTurnos]
		} else flash.error = "No se encontraron registros de alumnos."
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
                              turno:it.historialAcademico.distribucionInstitucional.turno[0]])
		}
		def report = new JasperReportDef(name:"reporteAlumnosInscritos.jasper",fileFormat:JasperExportFormat.CSV_FORMAT,
										 reportData:listaAlumnos,
										 locale:Locale.getDefault())
		response.setContentType("application/csv")
		response.setHeader "Content-disposition", "attachment; filename=" + user.instituciones[0].name.replaceAll(" ", "_") + "_alumnosInscritos.csv";
		response.outputStream << jasperService.generateReport(report).toByteArray()
	}
	
	def generaReportePdf() {
		def listaDependientes = [];
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
		if(params.nivel != null && params.nivel.length() > 0) {
			def listaAlumnos = [];
			def num = 1
			dependientes.each {
				listaAlumnos.add([no:num++,
								  nombrePadreOTutor:it.usuario.perfil.nombre + it.usuario.perfil.apellidoPaterno + it.usuario.perfil.apellidoMaterno,
								  correo:it.usuario.username,
								  telefono:it.usuario.perfil.telefonos.numeroTelefonico[0],
								  matricula:it.matricula,
								  nombreAlumno:it.perfil.nombre + it.perfil.apellidoPaterno + it.perfil.apellidoMaterno,
								  grado:it.historialAcademico.distribucionInstitucional.grado[0],
								  grupo:it.historialAcademico.distribucionInstitucional.grupo[0],
								  turno:it.historialAcademico.distribucionInstitucional.turno[0]])
			}
			listaDependientes.add([nivel: (NivelDeEstudio)params.nivel,
								  totalNivel: listaAlumnos.size(),
								  listaAlumnos:listaAlumnos])
		} else {
			listaNiveles.each {nivel ->
				def listaAlumnos = [];
				def num = 1
				dependientes.each {
					if(it.historialAcademico.distribucionInstitucional.nivelDeEstudio[0] == nivel) {
						listaAlumnos.add([no:num++,
										  nombrePadreOTutor:it.usuario.perfil.nombre + it.usuario.perfil.apellidoPaterno + it.usuario.perfil.apellidoMaterno,
										  correo:it.usuario.username,
										  telefono:it.usuario.perfil.telefonos.numeroTelefonico[0],
										  matricula:it.matricula,
										  nombreAlumno:it.perfil.nombre + it.perfil.apellidoPaterno + it.perfil.apellidoMaterno,
										  grado:it.historialAcademico.distribucionInstitucional.grado[0],
										  grupo:it.historialAcademico.distribucionInstitucional.grupo[0],
										  turno:it.historialAcademico.distribucionInstitucional.turno[0]])
					}
				}
				listaDependientes.add([nivel: nivel,
									  totalNivel: listaAlumnos.size(),
									  listaAlumnos:listaAlumnos])
			}
		}
		def report = new JasperReportDef(name:"reporteAlumnosInscritosPdf.jasper",fileFormat:JasperExportFormat.PDF_FORMAT,
										 reportData:listaDependientes,
										 locale:Locale.getDefault(), 
										 parameters:[nombreInstitucion:user.instituciones[0].name, 
											 		 fechaEmision:sdf.format(new Date()), 
													 totalAlumnos:dependientes.size(), 
													 SUBREPORT_DIR:"${servletContext.getRealPath('/reports')}/"])
		response.setContentType("application/pdf")
		response.setHeader "Content-disposition", "attachment; filename=" + user.instituciones[0].name.replaceAll(" ", "_") + "_alumnosInscritos.pdf";
		response.outputStream << jasperService.generateReport(report).toByteArray()
	}
}
