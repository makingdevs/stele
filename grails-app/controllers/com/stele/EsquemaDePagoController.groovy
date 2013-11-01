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
    def pagos = generacionDePagoService.generaPagoParaGrupo(grupoPagoCommand)
    if (grupoPagoCommand.descuentoIds) {
      def esquemaDePago = esquemaDePagoService.buscarOSalvarEsquemaDePago(grupoPagoCommand)
      pagos = verificarExistenciaDeFechaDeVencimientoEnDescuentoParaObtenerPagosConDescuentosAplicables(grupoPagoCommand, esquemaDePago, pagos)
    }
    flash.pago = pagos
    redirect action:"muestraPagosDeCamada",params: params + [camada:cpc.camada]
  }

  def muestraPagosDeCamada(){
    def listaPagos = Pago.findAllByIdInList(flash.pago*.id)
    render(view: "generarPagosParaLaCamada", model: [pagos: listaPagos])
  }

  private def verificarExistenciaDeFechaDeVencimientoEnDescuentoParaObtenerPagosConDescuentosAplicables(GrupoPagoCommand grupoPagoCommand,EsquemaDePago esquemaDePago, List pagos) {
    def listaDePagos
    def listaDeDescuentos = grupoPagoCommand.descuentoIds.first()
    listaDeDescuentos = listaDeDescuentos.replace('[','')?.replace(']','')?.split(',')
    listaDeDescuentos.each { idDescuento ->
      def descuentoAplicable 
      def fechasReferancia = pagos*.fechaDeVencimiento*.format('yyyy-MM-dd').unique()

      if (grupoPagoCommand.fechaDeVencimiento)
        descuentoAplicable = descuentoAplicableService.generarParaPagoConEsquemaDePagoConFechaReferencia(esquemaDePago.id, grupoPagoCommand.fechaDeVencimiento)
      else {
        fechasReferancia.each { fecha ->
          descuentoAplicable = descuentoAplicableService.generarParaPagoConEsquemaDePagoConFechaReferencia(esquemaDePago.id, Date.parse('yyyy-MM-dd', fecha))
        }
      } 
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
