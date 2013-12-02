package com.stele

class CuentasBancariasController {

  def springSecurityService
  def cuentasBancariasService

	def index(){
	}

	def crearCuentaBancariaTransferencia() {
		def organizacion = springSecurityService.currentUser.instituciones?.first()
		cuentasBancariasService.crearNuevaCuentaDePagoElectronico(params, organizacion)
		render template:'/cuentasBancarias/listaTransferenciaElectronica', model:[electronica:CuentasBancarias.findAllByOrganizacionAndTipoTransferencia(organizacion,TipoTransferencia.TRANSFERENCIAELECTRONICA)]
	}

	def crearCuentaBancariaCheque() {
		def organizacion = springSecurityService.currentUser.instituciones?.first()
		cuentasBancariasService.crearNuevaCuentaDePagoCheque(params, organizacion)
		render template: '/cuentasBancarias/listaCheque', model:[cheque:CuentasBancarias.findAllByOrganizacionAndTipoTransferencia(organizacion,TipoTransferencia.CHEQUE) ]
	}

	def crearCuentaBancariaFicha() {
		def organizacion = springSecurityService.currentUser.instituciones?.first()
		def cuenta = cuentasBancariasService.crearNuevaCuentaDePagoFicha(params, organizacion)
		[ficha:cuenta]
	}

}