package com.stele

class HistorialAcademicoService {
  def registrar(HistorialAcademico historialAcademico) {
    Dependiente dependienteExistente = Dependiente.get(historialAcademico.dependiente.id)
    DistribucionInstitucional distribucionInstitucionalExistente = DistribucionInstitucional.get(historialAcademico.distribucionInstitucional.id)
    historialAcademico.save()
  }
}
