package com.stele

class CuentasBancariasController {

  def springSecurityService
  def cuentasBancariasService

	def index(){
	}

	def crearCuentaBancariaTransferencia() {
		def organizacion = springSecurityService.currentUser.instituciones?.first()
		def cuenta = cuentasBancariasService.crearNuevaCuentaDePagoElectronico(params, organizacion)
		[electronica:cuenta]
	}

	def crearCuentaBancariaCheque() {
		def organizacion = springSecurityService.currentUser.instituciones?.first()
		def cuenta = cuentasBancariasService.crearNuevaCuentaDePago(params, organizacion)
		[cheque:cuenta]		
	}

	def crearCuentaBancariaFicha() {
		def organizacion = springSecurityService.currentUser.instituciones?.first()
		def cuenta = cuentasBancariasService.crearNuevaCuentaDePago(params, organizacion)
		[ficha:cuenta]
	}

}