package com.stele

import com.payable.Payment

class PagoVentanillaController {

  def efectivo() {
    [payment: Payment.get(params.id)]
  }
}
