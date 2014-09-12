package com.stele

import grails.converters.JSON
import com.payable.*


class EsquemaDePagoController {

  def springSecurityService
  def generacionDePagoService
  def wrapperCommandService
  def paymentSchemeService 
  def descuentoAplicableService
  def dependienteService
  def notificacionService
  def conceptService

  def scaffold = EsquemaDePago

  static allowedMethods = [obtenerEsquemaDePagoPorConcepto : 'GET']

  def nuevo(){
    def organizacion = springSecurityService.currentUser.instituciones.first()
     def esquemasDePagos = EsquemaDePago.withCriteria {
      concepto {
        eq ('organizacion', organizacion)
        order("descripcion","asc")
      }

    }
    [esquemasDePagos:esquemasDePagos] 
  }

  def crearEsquemaDePago(){
    def institucion = springSecurityService.currentUser.instituciones.first()
    def concept = conceptService.savePaymentConcept(institucion, params.nombreConcepto)
    PaymentGroupCommand pgc = new PaymentGroupCommand()

    if (params.recargoid)
      pgc.surchargeId = params.recargoid.toLong()
    pgc.paymentAmount = params.importeEsquemaDePago.toBigDecimal()
    pgc.paymentConcept = concept.description
    pgc.organization = institucion
    if (params.descuentos)
      pgc.discountIds = params.descuentos.replace('[','')?.replace(']','')?.split(',') as List
    def scheme = paymentSchemeService.savePaymentScheme(pgc)
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
    def paymentSchemes = []
    def concepts = []
    def organization = springSecurityService.currentUser.instituciones.first()

    concepts = Concept.withCriteria{
      like("description","${params.id}%")
      eq("organization",organization)
    }

    paymentSchemes = PaymentScheme.findAllByConceptInList(concepts)

    JSON.use('stele') { render paymentSchemes as JSON }
  }

  def generarPagoParaLaCamada(CamadaPagoCommand cpc) {
    if(cpc.hasErrors()) {
      render cpc.errors
      return
    } 

    def grupoPagoCommand = wrapperCommandService.generarParseoDeCamadaPagoCommandAGrupoPagoCommand(cpc, springSecurityService.currentUser.instituciones?.first())

    def pagos = generacionDePagoService.generaPagoParaGrupo(grupoPagoCommand)
    def esquemaDePago = esquemaDePagoService.buscarOSalvarEsquemaDePago(grupoPagoCommand)
    pagos = verificarExistenciaDeFechaDeVencimientoEnDescuentoParaObtenerPagosConDescuentosAplicables(grupoPagoCommand, esquemaDePago, pagos) ?: pagos
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
    pagos.each{ pago -> 
      def descuentosAplicables = descuentoAplicableService.generarParaPagoConEsquemaDePagoConFechaReferencia(esquemaDePago.id, pago.fechaDeVencimiento, grupoPagoCommand.fechasDeExpiracionDescuento)
      listaDePagos +=  asignarDescuntosAplicablesAlosPagos(descuentosAplicables,pago)
    }
    listaDePagos
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
