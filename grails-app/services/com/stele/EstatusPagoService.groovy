package com.stele

import com.stele.Pago

class EstatusPagoService {

  def buscarLdosPagosConFechaDeVencimientoActiva(){
    def listaDePagosConFechaVencida = Pago.withCriteria {
      eq('estatusDePago', EstatusDePago.CREADO)
      ge('fechaDeVencimiento', new Date())
    }
    cambioEstatusVencidoDeUnPago(listaDePagosVencidos)
  }

  def cambioEstatusVencidoDeUnPago(List listaDePagosVencidos) {
    def listaPagosProcesados = []

    listaDePagosVencidos.each { pago ->
      if (pago.estatusDePago == EstatusDePago.CREADO) {
        pago.estatusDePago = EstatusDePago.VENCIDO
        listaPagosProcesados.add( pago.save() )
      } 
    }
    listaPagosProcesados
  }

}