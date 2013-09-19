package com.stele

class InscripcionManualController {

	  def springSecurityService

		def inscripcion() {
    	def user = springSecurityService.currentUser
    	[usuario:user]
		}

		def crearUsuarioCondependiente() {
			println params
		}
}