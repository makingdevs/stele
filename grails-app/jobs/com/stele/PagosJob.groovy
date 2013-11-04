package com.stele

import com.payable.*

class PagosJob {

  def pagoService

    static triggers = {
      cron name: 'pagosVencidos', cronExpression: "0 0 1 * * ?"
    }

    def execute() {
      def resultadoRecargosJob = pagoService.exprirarPagosYCalcularRecargo()
      log.debug "Ejecucion del job Busqueda recargos : $resultadoRecargosJob"
    }
}
