package com.stele

import com.payable.*

class PagosJob {

  def pagoService
  def dependienteService
  def notificacionService

    static triggers = {
      cron name: 'pagosVencidos', cronExpression: "0 0 1 * * ?"
    }

    def execute() {
      def resultadoRecargosJob = pagoService.exprirarPagosYCalcularRecargo()
      if (!resultadoRecargosJob.isEmpty())
      	notificacion(resultadoRecargosJob)
      log.debug "Ejecucion del job Busqueda recargos : $resultadoRecargosJob"
    }

    private def notificacion(def pagos){
    	def listaDependientes = dependienteService.obtenerDependientesPorPagos(pagos)
    	notificacionService.notificarPagosVencidos(listaDependientes)
    }

}
