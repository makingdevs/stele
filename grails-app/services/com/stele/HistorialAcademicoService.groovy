package com.stele

import com.makingdevs.*
import com.payable.*
import com.stele.seguridad.Usuario


class HistorialAcademicoService {
  def registrar(HistorialAcademico historialAcademico) {
    Dependiente dependiente = Dependiente.get(historialAcademico.dependiente.id)
    DistribucionInstitucional distribucionInstitucional = DistribucionInstitucional.get(historialAcademico.distribucionInstitucional.id)
    if(dependiente && distribucionInstitucional){
        def criteriaHistorialAcademico = HistorialAcademico.createCriteria()
        def historialAcademicoExistente = criteriaHistorialAcademico.get {
          eq("dependiente",dependiente)
          eq("distribucionInstitucional",distribucionInstitucional)
        }
        historialAcademicoExistente ?: historialAcademico.save()
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


}
