package com.stele

import com.makingdevs.*
import com.payable.*
import com.stele.seguridad.Usuario


class HistorialAcademicoService {
  
  def springSecurityService

  def registrar(HistorialAcademico historialAcademico) {
    Dependiente dependiente = Dependiente.get(historialAcademico.dependiente.id)
    DistribucionInstitucional distribucionInstitucional = DistribucionInstitucional.get(historialAcademico.distribucionInstitucional.id)
    if(dependiente && distribucionInstitucional){
        def criteriaHistorialAcademico = HistorialAcademico.createCriteria()
        def historialAcademicoExistente = criteriaHistorialAcademico.get {
          eq("dependiente",dependiente)
          eq("distribucionInstitucional",distribucionInstitucional)
        }
       return historialAcademicoExistente ?: historialAcademico.save()
      }else{
        throw RuntimeException("Se intentó persistir un historila academico con dependiente o distribucionInstitucional inválida...")
      }
  }

  HistorialAcademico preparaHistoricoAcademicoARegistrar(Dependiente dependiente, DistribucionInstitucional distribucionInstitucional){
    HistorialAcademico historialAcademico = new HistorialAcademico()
    historialAcademico.distribucionInstitucional = distribucionInstitucional
    historialAcademico.dependiente = dependiente
    historialAcademico
  }

  def obtenerHistorilesAcademicosDelaInstitucion(Usuario usuario) {
    def distribucionInstitucional = DistribucionInstitucional.findAllByInstitucion(usuario.instituciones.first())
    def historialAcademico = HistorialAcademico.findAllByDistribucionInstitucionalInList(distribucionInstitucional)
    historialAcademico
  } 

  def obtenerHistorialesAcademicosEnBaseADistribucionInstitucional(def distribucionInstitucional) {
    HistorialAcademico.withCriteria {
      'in'('distribucionInstitucional', distribucionInstitucional)
      dependiente{
        //if(params.matricula)
          //ilike('matricula', params.matricula)
        join('perfil')
      }
    }
  }

  def obtenerhistorialAcademicoPorDependiente (def id) {
    def dependiente = Dependiente.get(id)
    def criteriaHistorialAcademico = HistorialAcademico.createCriteria()
    
    def historialAcademicoExistente = criteriaHistorialAcademico.get {
      eq("dependiente",dependiente)
      distribucionInstitucional{
        eq("institucion",springSecurityService.currentUser.instituciones?.first())
      }      
    }    
    historialAcademicoExistente
  }

}
