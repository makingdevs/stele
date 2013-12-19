package com.stele

import com.payable.*

class PagoVentanillaController {

    def efectivo() {
      [pago: Pago.get(params.id)]
    }
}