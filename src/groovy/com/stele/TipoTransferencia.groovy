package com.stele

enum TipoTransferencia {
	TRANSFERENCIAELECTRONICA("Transferencia Electronica"),
	CHEQUE("Cheque"),
	FICHADEPAGO("Ficha De Pago")

	final String value
	TipoTransferencia(String value){ this.value = value }

	String toString(){ value }
	String getKey(){ name() }

}