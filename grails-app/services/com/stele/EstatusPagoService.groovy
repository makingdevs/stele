package com.stele

import com.stele.Pago

class EstatusPagoService {

  def obtenerPagosVencidos(){
    def listaDePagosVencidos = Pago.withCriteria {
      ge('fechaDeVencimiento', new Date())
      eq('estatusDePago', EstatusDePago.CREADO)
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