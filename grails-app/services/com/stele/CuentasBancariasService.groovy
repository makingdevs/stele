package com.stele

class CuentasBancariasService {

	def crearNuevaCuentaDePagoElectronico(def params, Institucion organizacion) {
		def cuenta = new CuentasBancarias(params)
		cuenta.organizacion = springSecurityService.currentUser.instituciones?.first()
		cuenta.save()
	}

	def crearNuevaCuentaDePagoCheque(def params, Institucion organizacion) {
		def cuenta = new CuentasBancarias(params)
		cuenta.organizacion = springSecurityService.currentUser.instituciones?.first()
		cuenta.save()
	}

	def crearNuevaCuentaDePagoFicha(def params, Institucion organizacion) {
		def cuenta = new CuentasBancarias(params)
		cuenta.organizacion = springSecurityService.currentUser.instituciones?.first()
		cuenta.save()
	}

	def obtenerCuentasExistentesPorInstitucion(def organizacion) {
		def cuentas = CuentasBancarias.findByOrganizacion(organizacion)
		[
			electronica : cuentas.findAll { cuenta -> cuenta.tipoTransferencia == TipoTransferencia.TRANSFERENCIAELECTRONICA }
			cheque 			: cuentas.findAll { cuenta -> cuenta.tipoTransferencia == TipoTransferencia.CHEQUE }
			ficha 			: cuentas.findAll { cuenta -> cuenta.tipoTransferencia == TipoTransferencia.FICHADEPAGO }
		]
	}

}