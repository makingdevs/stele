package com.stele

import com.payable.Payment
import com.payable.PaymentType

class PagoVentanillaController {

  def efectivo() {
	def listTipoPagos = []
	PaymentType.values().each {
		if(it == PaymentType.WIRE_TRANSFER)
			listTipoPagos.add([key:it.key, pago:'Transferencia Bancaria'])
		if(it == PaymentType.REFERENCED_DEPOSIT)
			listTipoPagos.add([key:it.key, pago:'Pago Referenciado'])
		if(it == PaymentType.CHECK)
			listTipoPagos.add([key:it.key, pago:'Cheque'])
		if(it == PaymentType.CASH)
			listTipoPagos.add([key:it.key, pago:'Efectivo'])
		if(it == PaymentType.TERMINAL)
			listTipoPagos.add([key:it.key, pago:'Terminal'])
	}
    [payment: Payment.get(params.id), listTipoPagos:listTipoPagos]
  }
}