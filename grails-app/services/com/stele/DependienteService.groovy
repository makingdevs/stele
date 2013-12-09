package com.stele

import com.stele.Turno
import com.stele.NivelDeEstudio
import com.stele.seguridad.Usuario
import com.makingdevs.*
import com.payable.*

class DependienteService {

  def perfilService
  def notificacionService

  def obtenerDependienteDesdeCommand(FilaExcelCommand filaExcelCommand) {
    def perfil = new Perfil()
    perfil.nombre = filaExcelCommand.dependienteNombre
    perfil.apellidoPaterno = filaExcelCommand.dependienteApellidoPaterno
    perfil.apellidoMaterno = filaExcelCommand.dependienteApellidoMaterno
    def dependiente = new Dependiente()
    dependiente.matricula = filaExcelCommand.matricula
    dependiente.perfil = perfil
    dependiente
  }

  def obtenerDependienteDesdeCommand(InscripcionCommand incs) {
    def perfil = new Perfil()
    def dependiente = new Dependiente()
    perfil.nombre = incs.nombreAlumno
    perfil.apellidoPaterno = incs.apellidoPaternoAlumno
    perfil.apellidoMaterno = incs.apellidoMaternoAlumno
    dependiente.matricula = incs.matricula
    dependiente.perfil = perfil
    dependiente
  }

  Dependiente registrar(Dependiente dependiente, Long usuarioId){
    Usuario usuario = Usuario.get(usuarioId)
    if(usuario){
      def dependienteExistente = Dependiente.findByMatricula(dependiente.matricula)
      if(dependienteExistente){
        return dependienteExistente
      }else{
        dependiente.perfil = perfilService.registrar(dependiente.perfil)
        usuario.addToDependientes(dependiente)
        usuario.save()
        notificacionService.notificarRegistroUsuarioTutor(usuario.username)
        return dependiente
      }
    }else{
      throw RuntimeException("Se intentó persistir un dependiente con un usuario inválido...")
    }
  }

  def agruparDependientesPorTurno(def historialesAcademiscos) {
    def mapa = [:]
    mapa.("matutino") = historialesAcademiscos.findAll { historial -> historial.distribucionInstitucional.turno == Turno.MATUTINO }
    mapa.("vespertino") = historialesAcademiscos.findAll { historial -> historial.distribucionInstitucional.turno == Turno.VESPERTINO }
    mapa
  }

  def agruparDependientesPorNivel(def turno,def dependientesPorTurno, def institucion) {
    def estructuraNiveles = [:]
    def niveles = DistribucionInstitucional.withCriteria{
      eq('institucion', institucion)
      projections {
        groupProperty('nivelDeEstudio')
      }
    }
    niveles.each { nivel ->
      estructuraNiveles.put("$turno" + "$nivel" , dependientesPorTurno.findAll { dependiente -> dependiente.distribucionInstitucional.nivelDeEstudio == nivel})
    }
    estructuraNiveles
  }

  def agruparDependientesPorGrado(def key, def dependientesPorNivel) {
    def estructuraGrados = [:]
    def grados = dependientesPorNivel*.distribucionInstitucional*.grado.unique()
    grados.each { grado ->
      estructuraGrados.put("$key" + "$grado" , dependientesPorNivel.findAll { dependiente -> dependiente.distribucionInstitucional.grado == grado})
    }
    estructuraGrados
  }

  def agruparDependientesPorGrupo(def key, def dependientesPorGrado) {
    def estructuraGrupos = [:]
    def grupos = dependientesPorGrado*.distribucionInstitucional*.grupo.unique()
    grupos.each{ grupo ->
      estructuraGrupos.put("$key" + "$grupo" , dependientesPorGrado.findAll { dependiente -> dependiente.distribucionInstitucional.grupo == grupo})
    }
    estructuraGrupos
  }

  def obtenerDependientesPorPagos(def listaPagos) {
    Dependiente.withCriteria{
      pagos{
        'in'('id', listaPagos.flatten()*.id.toLong())
      }
    }
  }

}