package com.stele

class CuentasBancarias {

	String nombreDeBanco
	BigInteger numeroDeCuenta
	String beneficiario
	BigInteger cuentaInterbancaria
	String referencia
	TipoTransferencia tipoTransferencia

	Date dateCreated
	Date lastUpdated

	static belongsTo = [organizacion : Institucion]

	static constraints = {
		nombreDeBanco size:1..60,blank:false
		numeroDeCuenta nullable:false
		beneficiario size:1..80, nullable:false
		cuentaInterbancaria nullable:true
		referencia size:1..120, nullable:true
	}

}