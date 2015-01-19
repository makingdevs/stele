package com.stele

import com.payable.*

class ReporteAlumnosCobrosService {
	
	def obtenerPagosDeAlumnos(Date fechaInicial, Date fechaFinal, String concepto, String tipo, List<Dependiente> listaAlumnos) {
		def lista = []
		listaAlumnos.each { alumno ->
			try {
				def pagos = PaymentLink.findByPaymentRef(alumno.id).payments
				if(pagos != null) {
					pagos.each {pago ->
						lista.add([alumno:alumno, pago:pago])
					}
				}
			} catch(Exception e) {
			}
		}
		return lista;
	}
	
	def obtenerPagosDeAlumnosPorEstatus(Date fechaInicial, Date fechaFinal, String concepto, String tipo, List<Dependiente> listaAlumnos, PaymentStatus estatus) {
		def lista = []
		listaAlumnos.each { alumno ->
			try {
				def pagos = PaymentLink.findByPaymentRef(alumno.id).payments.findAll {payment -> payment.paymentStatus == estatus }
				if(pagos != null) {
					pagos.each {pago ->
						lista.add([alumno:alumno, pago:pago])
					}
				}
			} catch(Exception e) {
			}
		}
		return lista;
	}
	
}

