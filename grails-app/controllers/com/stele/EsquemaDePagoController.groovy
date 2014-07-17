package com.stele

import grails.converters.JSON
import com.payable.*


class EsquemaDePagoController {

  def springSecurityService
  def generacionDePagoService
  def wrapperCommandService
  def esquemaDePagoService
  def descuentoAplicableService
  def dependienteService
  def notificacionService
  def conceptoService

  def scaffold = EsquemaDePago

  static allowedMethods = [obtenerEsquemaDePagoPorConcepto : 'GET']

  def nuevo(){
    def organizacion = springSecurityService.currentUser.instituciones.first()
     def esquemasDePagos = EsquemaDePago.withCriteria {
      concepto {
        eq ('organizacion', organizacion)
      }
    }
    [esquemasDePagos:esquemasDePagos] 
  }

  def crearEsquemaDePago(){
    def institucion = springSecurityService.currentUser.instituciones.first()
    def concepto = conceptoService.buscarOSalvarConceptoDePago(institucion, params.nombreConcepto)
    GrupoPagoCommand gpc = new GrupoPagoCommand()
    if (params.recargoid)
      gpc.recargoId = params.recargoid.toLong()
    gpc.cantidadDePago = params.importeEsquemaDePago.toBigDecimal()
    gpc.conceptoDePago = concepto.descripcion
    if (params.descuentos)
      gpc.descuentoIds = params.descuentos.replace('[','')?.replace(']','')?.split(',') as List
    def esquema = esquemaDePagoService.buscarOSalvarEsquemaDePago(gpc)
    redirect(action:'nuevo')
  }
 
  def paraCamada() {
    if(params.listaDependientes) {
      if (params.listaDependientes instanceof String)
        flash.dependientes = params.listaDependientes
      else
        flash.dependientes = params.listaDependientes.flatten()
      flash.message = params.message
    }
    [camada:params?.camada]
  }

  def obtenerEsquemaDePagoPorConcepto(){
    def organizacion = springSecurityService.currentUser.instituciones.first()
    def esquemasDePagos = EsquemaDePago.withCriteria {
      concepto {
        like('descripcion', "%${params.id}%" )
        eq ('organizacion', organizacion)
      }
    }
    JSON.use('stele') {
      render esquemasDePagos as JSON
    }
  }

  def generarPagoParaLaCamada(CamadaPagoCommand cpc) {
    if(cpc.hasErrors()) {
      render cpc.errors
      return
    } 
    def grupoPagoCommand = wrapperCommandService.generarParseoDeCamadaPagoCommandAGrupoPagoCommand(cpc, springSecurityService.currentUser.instituciones?.first())
    def pagos = generacionDePagoService.generaPagoParaGrupo(grupoPagoCommand)
    def esquemaDePago = esquemaDePagoService.buscarOSalvarEsquemaDePago(grupoPagoCommand)
    pagos = verificarExistenciaDeFechaDeVencimientoEnDescuentoParaObtenerPagosConDescuentosAplicables(grupoPagoCommand, esquemaDePago, pagos)
    if (pagos)
      notificarCreacionDePago(pagos)
    flash.pago = pagos
    redirect action:"muestraPagosDeCamada",params: params + [camada:cpc.camada,message:params.message]
  }

  def muestraPagosDeCamada(){
    def listaPagos = Pago.findAllByIdInList(flash.pago.flatten()*.id)
    flash.success = "Los cobros han sido registrados"
    flash.message = params.message
    render(view: "generarPagosParaLaCamada", model: [pagos: listaPagos])
  }

  def eliminarEsquemaDePago(){
    def esquemaDePago = EsquemaDePago.get(params.id)
    esquemaDePago.delete()
    redirect(action:'nuevo')
  }

  private def verificarExistenciaDeFechaDeVencimientoEnDescuentoParaObtenerPagosConDescuentosAplicables(GrupoPagoCommand grupoPagoCommand,EsquemaDePago esquemaDePago, List pagos) {
    def listaDePagos = []
    def listaDeDescuentos = grupoPagoCommand.descuentoIds?.first() ?: ""
    listaDeDescuentos = listaDeDescuentos?.replace('[','')?.replace(']','')?.split(',') 
    pagos.each{ pago -> 
      listaDeDescuentos.each { idDescuento ->
        def descuentoAplicable = descuentoAplicableService.generarParaPagoConEsquemaDePagoConFechaReferencia(esquemaDePago.id, pago.fechaDeVencimiento)
        listaDePagos << asignarDescuntosAplicablesAlosPagos(descuentoAplicable, pago)
      }
    }
  }

  private def asignarDescuntosAplicablesAlosPagos(def descuentoAplicable, Pago pago) {
    def listadePagos = []
      if (descuentoAplicable instanceof DescuentoAplicable)
        listadePagos << descuentoAplicableService.agregarDescuentoAplicableAUnPago(descuentoAplicable, pago.id)
      else if (descuentoAplicable instanceof List<DescuentoAplicable>) {
        descuentoAplicable.each { descuentoApl ->
          listadePagos << descuentoAplicableService.agregarDescuentoAplicableAUnPago(descuentoApl, pago.id)
        }
      }
    listadePagos
  }

  private def notificarCreacionDePago(def listaDePagos) {
    def dependientes = dependienteService.obtenerDependientesPorPagos(listaDePagos)
    notificacionService.notificarPagosCreados(dependientes)

  }

}
