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

  Dependiente registrar(Dependiente dependiente, Long usuarioId, def institucion){
    dependiente.save()
    def user = Usuario.withCriteria{
      eq('id', usuarioId)
      instituciones {
        eq('id', institucion.id)
      }
    }
    def usuarios = user.first()
    if(usuarios){
      def dependienteExistente = Dependiente.withCriteria{
        eq('matricula', dependiente.matricula)
        usuario {
          instituciones {
            eq('id', institucion.id)
          }
        }
      }
      if(dependienteExistente){
        return dependienteExistente.first()
      }else{
        dependiente.perfil = perfilService.registrar(dependiente.perfil)
        usuarios.addToDependientes(dependiente)
        usuarios.save()
        notificacionService.notificarRegistroUsuarioTutor(usuarios.username)
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
    def dependienteIds = PaymentLink.withCriteria{
      eq('type',Dependiente.class.simpleName)
      payments{
        'in'('id',listaPagos*.id)
      }
    }*.paymentRef
    Dependiente.findAllByIdInList(dependienteIds)
  }

  def findDependienteFromPaymentId(def idPayment){
    def dependienteId = PaymentLink.withCriteria(uniqueResult:true){
      eq('type',Dependiente.class.simpleName)
      payments{
        eq('id',idPayment)
      }
    }.paymentRef
      
    Dependiente.get(dependienteId)
    
  }

  def findDependientesByNameAndOrganization(name, organization){
    def dependientes = []
    log.error("----")
    def distribucionInstitucionalIds = DistribucionInstitucional.findAllByInstitucion(organization)*.id 
    def historialesAcademicos = HistorialAcademico.withCriteria{
      distribucionInstitucional{
        'in'('id',distribucionInstitucionalIds)
      }       
      and{
        dependiente{
          like('nombre','%${name}%')
          or{ like('apellidoPaterno','%${name}%')}
          or{ like('apellidoMaterno','%${name}%')}
        }
      }
    }

    dependientes = historialesAcademicos*.dependiente
    dependientes
  }

}
