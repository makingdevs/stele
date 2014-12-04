package com.stele

import java.text.SimpleDateFormat

class ReporteEstadisticasAlumnosService {
	def sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES"))
	
	def obtenerEstadisticasAlumnosPorNivel(def alumnos, def niveles) {
		def estadisticas = [titulo:"Poblacion de Estudiantes Inscritos:", fecha:sdf.format(new Date()), totalAlumno:alumnos.size(), niveles:[]]
		clasificarPorNivelDeAlumnos(alumnos, estadisticas, niveles, [])
	}
	
	def clasificarPorNivelDeAlumnos(def alumnos, def estadisticas, def niveles, def grupos) {
		niveles.each {nivel ->
			estadisticas.niveles.add([nivel:nivel, totalNivel:0, porcentaje:0, listaGrupos:grupos, grupos:[], listaGrados:[]])
		}
		alumnos.each {alumno ->
			estadisticas.niveles.each {nivel ->
				if(alumno.nivel == nivel.nivel) {
					nivel.totalNivel++
					nivel.listaGrupos << alumno.grupo
				}
				nivel.porcentaje = ((nivel.totalNivel / estadisticas.totalAlumno) * 100) as int
			}
		}
		return estadisticas
	}
	
	def obtenerEstadisticasAlumnosPorGradoYNivel(def alumnos, def grados, def niveles) {
		def estadisticas = [titulo:"Poblacion Estudiantil Por Nivel", fecha:sdf.format(new Date()), totalAlumno:alumnos.size(), grados:[]]
		clasificarPorNivelDeGradoDeAlumnos(alumnos, clasificarPorGradoDeAlumnos(alumnos, estadisticas, grados, niveles))
	}
	
	def clasificarPorGradoDeAlumnos(def alumnos, def estadisticas, def grados, def niveles) {
		grados.each {grado ->
			estadisticas.grados.add([grado:grado, totalGrados:0, porcentaje:0, listaNiveles:niveles, niveles:[]])
		}
		alumnos.each {alumno ->
			estadisticas.grados.each {grado ->
				if(alumno.grado == grado.grado) {
					grado.totalGrados++
				}
				grado.porcentaje = ((grado.totalGrados / estadisticas.totalAlumno) * 100) as int
			}
		}
		return estadisticas
	}
	
	def clasificarPorNivelDeGradoDeAlumnos(def alumnos, def estadisticas) {
		estadisticas.grados.each {grado ->
			grado.listaNiveles.unique()
			grado.listaNiveles.each { nivel ->
				grado.niveles += [nivel:nivel, total:0, porcentaje:0]
			}
		}
		alumnos.each {alumno ->
			estadisticas.grados.each { grado ->
				grado.niveles.each { nivel ->
					if(alumno.grado == grado.grado && alumno.nivel == nivel.nivel) {
						nivel.total++
					}
					nivel.porcentaje = ((nivel.total / grado.totalGrados) * 100) as int
				}
			}
		}
		return estadisticas
	}
	
	def obtenerEstadisticasAlumnosPorNivelGrupoYGrado(def alumnos, def niveles, def grupos, def grados) {
		def estadisticas = [titulo:"Poblacion Estudiantil: ", fecha:sdf.format(new Date()), totalAlumno:alumnos.size(), niveles:[]]
		clasificarPorGradoDeGrupoDeAlumnos(alumnos, 
			clasificarPorGrupoDeNivelDeAlumnos(alumnos,
				clasificarPorNivelDeAlumnos(alumnos, estadisticas, niveles, grupos), grados))
	}
	
	def clasificarPorGrupoDeNivelDeAlumnos(def alumnos, def estadisticas, def grados) {
		estadisticas.niveles.each {nivel ->
			nivel.listaGrupos.unique()
			nivel.listaGrupos.each { grupo ->
				nivel.grupos += [grupo:grupo, total:0, porcentaje:0, listaGrados:grados, grados:[]]
			}
		}
		alumnos.each {alumno ->
			estadisticas.niveles.each { nivel ->
				nivel.grupos.each { grupo ->
					if(alumno.nivel == nivel.nivel && alumno.grupo == grupo.grupo) {
						grupo.total++
						grupo.listaGrados << alumno.grado
					}
				}
			}
		}
		return estadisticas
	}
	
	def clasificarPorGradoDeGrupoDeAlumnos(def alumnos, def estadisticas) {
		estadisticas.niveles.each {nivel ->
			nivel.grupos.each { grupo ->
				grupo.listaGrados.unique()
				grupo.listaGrados.each { grado ->
					grupo.grados += [grado:grado, total:0, porcentaje:0]
				}
				nivel.listaGrados += grupo.listaGrados
			}
			nivel.listaGrados.unique()
		}
		alumnos.each {alumno ->
			estadisticas.niveles.each { nivel ->
				nivel.grupos.each { grupo ->
					grupo.grados.each { grado ->
						if(alumno.nivel == nivel.nivel && alumno.grupo == grupo.grupo && alumno.grado == grado.grado) {
							grado.total++
						}
					}
				}
			}
		}
		return estadisticas
	}
}
