package com.stele

class PagosJob {

  def pagoService

    static triggers = {
      cron name: 'pagosVencidos', cronExpression: "0 0 1 * * ?"
    }

    def execute() {
      def resultadoJob = pagoService.buscarPagosConFechasDeVencimientoCumplida()
      log.debug "Ejecucion del job : $resultadoJob"
    }
}
