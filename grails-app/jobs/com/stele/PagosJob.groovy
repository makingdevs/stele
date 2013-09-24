package com.stele

class PagosJob {

  def pagoService

    static triggers = {
      cron name: 'pagosVencidos', cronExpression: "10 * * * * ?"
    }

    def execute() {
      def resultadoRecargosJob = pagoService.buscarPagosConFechasDeVencimientoCumplida()
      log.debug "Ejecucion del job Busqueda recargos : $resultadoRecargosJob"
      def resultadoDescuentoJob = pagoService.buscarPagosCreadosYEnTiempo()
      log.debug "Ejecucion del job Busqueda descuentos : $resultadoDescuentoJob"
      //def pagosVencidos = pagoService.cambiarEstatusDePagoAVencido(resultadoRecargosJob)
      //log.debug "Ejecucion del job Servicio: $pagosVencidos"
      def pagosConDescuento = pagoService.verificarVigenciaDescuentoYAplicacion(resultadoDescuentoJob)
    }
}
