package com.stele

import grails.transaction.Transactional
import com.payable.Pago

@Transactional
class ReciboDePagoService {
  
  def dependienteService
  def historialAcademicoService

  def obtenerDatosReciboDePago(paymentId){
    def payment = Payment.get(paymentId)
    def dependiente = dependienteService.obtenerDependientesPorPagos([pago])[0];
    def tutor = dependiente.usuario.perfil    
    def historialAcademico = historialAcademicoService.obtenerhistorialAcademicoPorDependiente(dependiente.id)

    new ComprobantePagoCommand(nombreAlumno:dependiente.perfil.nombre + " " + dependiente.perfil.apellidoPaterno + " " + dependiente.perfil.apellidoMaterno,
                               nombreTutor:tutor.nombre +" "+ tutor.apellidoPaterno + " " + tutor.apellidoMaterno,
                               nivelEstudio:historialAcademico.distribucionInstitucional.nivelDeEstudio,
                               grado:historialAcademico.distribucionInstitucional.grado,
                               grupo:historialAcademico.distribucionInstitucional.grupo,
                               conceptoPago:payment.paymentConcept,
                               cantidadPago:payment.paymentAmount,
                               recargosAcumulados:payment.accumulatedSurcharges,
                               total:pago.cantidadDePago.subtract(payment.accumulatedSurcharges),
                               fechaPago:payment.paymentDate,
                               tipoPago:payment.paymentType,
                               referencia:payment.reference)

  }

}
