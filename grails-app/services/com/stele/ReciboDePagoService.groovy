package com.stele

import grails.transaction.Transactional
import com.payable.Pago

@Transactional
class ReciboDePagoService {
  
  def dependienteService
  def historialAcademicoService
  def perfilService

  def obtenerDatosReciboDePago(pagoId){
    def pago = Pago.get(pagoId)
    def dependiente = dependienteService.obtenerDependientesPorPagos([pago])[0];
    def tutor = perfilService.obtenerPerfilDesdeUsuario(dependiente.usuario.id)
    def historialAcademico = historialAcademicoService.obtenerhistorialAcademicoPorDependiente(dependiente.id)

    new ComprobantePagoCommand(nombreAlumno:dependiente.perfil.nombre,
                               apellidoPaternoAlumno:dependiente.perfil.apellidoPaterno,
                               apellidoMaternoAlumno:dependiente.perfil.apellidoMaterno,
                               apellidoPaternoTutor:tutor.apellidoPaterno,
                               apellidoMaternoTutor:tutor.apellidoMaterno,
                               nombreTutor:tutor.nombre,
                               nivelEstudio:historialAcademico.distribucionInstitucional.nivelDeEstudio,
                               grado:historialAcademico.distribucionInstitucional.grado,
                               grupo:historialAcademico.distribucionInstitucional.grupo,
                               conceptoPago:pago.conceptoDePago,
                               cantidadPago:pago.cantidadDePago,
                               recargosAcumulados:pago.recargosAcumulados,
                               fechaPago:pago.fechaDePago,
                               tipoPago:pago.tipoDePago)

  }

}
