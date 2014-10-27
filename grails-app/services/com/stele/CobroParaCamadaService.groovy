package com.stele

import grails.transaction.Transactional
import com.payable.*

@Transactional
class CobroParaCamadaService {

  def applicableDiscountService 
  
  def obtenerPagosConDescuentosAplicablesSiTienenFechaDeVencimiento(PaymentGroupCommand pgc,PaymentScheme paymentScheme, def pagos){
    def listaDePagos = []
    pagos.each{ pago -> 
    
    } 
    listaDePagos << pagos[0] 
  }

}
