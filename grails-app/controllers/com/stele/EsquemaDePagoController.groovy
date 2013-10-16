package com.stele

import grails.converters.JSON
import com.payable.*


class EsquemaDePagoController {

  def springSecurityService
  def generacionDePagoService
  def wrapperCommandService
  def esquemaDePagoService
  def descuentoAplicableService

  def scaffold = EsquemaDePago
 
  def paraCamada() {
    [camada:params?.camada]
  }

  def generarPagoParaLaCamada(CamadaPagoCommand cpc) {
    if(cpc.hasErrors()) {
      render cpc.errors
      return
    } 
    def grupoPagoCommand = wrapperCommandService.generarParseoDeCamadaPagoCommandAGrupoPagoCommand(cpc, springSecurityService.currentUser.instituciones?.first())
    def esquemaDePago = esquemaDePagoService.buscarOSalvarEsquemaDePago(grupoPagoCommand)
    def pagosGenerados = generacionDePagoService.generaPagoParaGrupo(grupoPagoCommand)
    def pagos = verificarExistenciaDeFechaDeVencimientoEnDescuentoParaObtenerPagosConDescuentosAplicables(grupoPagoCommand, esquemaDePago, pagosGenerados)
    flash.pago = pagos
    flash.success = "Bien Hecho"
    redirect action:"muestraPagosDeCamada",params: params + [camada:cpc.camada]
  }

  def muestraPagosDeCamada(){
    def listaPagos = Pago.findAllByIdInList(flash.pago*.id)
    render(view: "generarPagosParaLaCamada", model: [pagos: listaPagos])
  }

  private def verificarExistenciaDeFechaDeVencimientoEnDescuentoParaObtenerPagosConDescuentosAplicables(GrupoPagoCommand grupoPagoCommand,EsquemaDePago esquemaDePago, List pagos) {
    def listaDePagos
    grupoPagoCommand.descuentoIds.each { idDescuento ->
      def descuentoAplicable 
      def descuento = Descuento.get(idDescuento)
      if (descuento.fechaDeVencimiento)
        descuentoAplicable = descuentoAplicableService.generarParaPagoConVencimiento(descuento.fechaDeVencimiento, descuento.id)
      else 
        descuentoAplicable = descuentoAplicableService.generarParaPagoConEsquemaDePagoConFechaReferencia(esquemaDePago.id, grupoPagoCommand.fechaDeVencimiento)

      listaDePagos = asignarDescuntosAplicablesAlosPagos(descuentoAplicable, pagos)

    }
    listaDePagos
  }

  private def asignarDescuntosAplicablesAlosPagos(def descuentoAplicable, List pagos) {
    def listadePagos = []
    pagos.each { pago ->
      if (descuentoAplicable instanceof DescuentoAplicable)
        listadePagos << descuentoAplicableService.agregarDescuentoAplicableAUnPago(descuentoAplicable, pago.id)
      else if (descuentoAplicable instanceof List<DescuentoAplicable>) {
        descuentoAplicable.each { descuentoApl ->
          listadePagos << descuentoAplicableService.agregarDescuentoAplicableAUnPago(descuentoApl, pago.id)
        }
      }
    }
    listadePagos
  }

}
