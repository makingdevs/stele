package com.stele

import grails.transaction.Transactional
import com.payable.Pago

@Transactional
class ReciboDePagoService {
  
  def dependienteService
  def historialAcademicoService

  def obtenerDatosReciboDePago(pagoId){
    def pago = Pago.get(pagoId)
    def dependiente = dependienteService.obtenerDependientesPorPagos([pago])[0];
    def tutor = dependiente.usuario.perfil    
    def historialAcademico = historialAcademicoService.obtenerhistorialAcademicoPorDependiente(dependiente.id)

    new ComprobantePagoCommand(nombreAlumno:dependiente.perfil.nombre + " " + dependiente.perfil.apellidoPaterno + " " + dependiente.perfil.apellidoMaterno,
                               nombreTutor:tutor.nombre +" "+ tutor.apellidoPaterno + " " + tutor.apellidoMaterno,
                               nivelEstudio:historialAcademico.distribucionInstitucional.nivelDeEstudio,
                               grado:historialAcademico.distribucionInstitucional.grado,
                               grupo:historialAcademico.distribucionInstitucional.grupo,
                               conceptoPago:pago.conceptoDePago,
                               cantidadPago:pago.cantidadDePago,
                               recargosAcumulados:pago.recargosAcumulados,
                               total:pago.cantidadDePago.subtract(pago.recargosAcumulados),
                               fechaPago:pago.fechaDePago,
                               tipoPago:pago.tipoDePago,
                               referencia:pago.referencia)

  }

}
