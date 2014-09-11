package com.stele

class CuentasBancarias {

	String nombreDeBanco
	BigInteger numeroDeCuenta
	String beneficiario
	String cuentaInterbancaria
	String referencia
	TipoTransferencia tipoTransferencia

	Date dateCreated
	Date lastUpdated

	static belongsTo = [organization : Institucion]

	static constraints = {
		nombreDeBanco size:1..60,blank:false
		numeroDeCuenta size:1..10, nullable:false
		beneficiario size:1..80, nullable:false
		cuentaInterbancaria size:1..18, nullable:true
		referencia size:1..120, nullable:true
	}

}
