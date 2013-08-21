package com.stele

import com.stele.Pago

class EstatusPagoService {

  def cambioEstatusVencidoDeUnPago() {

    def listaDePagosVencidos = Pago.withCriteria {
      ge('fechaDeVencimiento', new Date())
      eq('estatusDePago', EstatusDePago.CREADO)
    }

    li staDePagosVencidos.each { pago ->
      if (pago.estatusDePago == EstatusDePago.CREADO) {
        pago.estatusDePago = EstatusDePago.VENCIDO
        pago.save()
      } 
    }

  }
}