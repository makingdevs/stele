package com.stele

import grails.converters.JSON
import com.payable.*


class EsquemaDePagoController {

  def springSecurityService
  def generationOfPaymentService 
  def wrapperCommandService
  def paymentSchemeService 
  def applicableDiscountService
  def dependienteService
  def notificacionService
  def conceptService

  def scaffold = EsquemaDePago

  static allowedMethods = [obtenerEsquemaDePagoPorConcepto : 'GET']

  def nuevo(){
    def organizacion = springSecurityService.currentUser.instituciones.first()
    def paymentSchemes = PaymentScheme.withCriteria{
      concept{
        eq('organization',organizacion)
        order('description',"asc")
      } 
    }

    [paymentSchemes:paymentSchemes] 
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

    def pagos = generationOfPaymentService.generatePaymentsForGroup(grupoPagoCommand)
    def esquemaDePago = paymentSchemeService.savePaymentScheme(grupoPagoCommand)
    pagos = verificarExistenciaDeFechaDeVencimientoEnDescuentoParaObtenerPagosConDescuentosAplicables(grupoPagoCommand, esquemaDePago, pagos) ?: pagos
    if (pagos)
      notificarCreacionDePago(pagos)
    flash.pago = pagos
    redirect action:"muestraPagosDeCamada",params: params + [camada:cpc.camada,message:params.message]
  }

  def muestraPagosDeCamada(){
    def listaPagos = flash.pago 
    flash.success = "Los cobros han sido registrados"
    flash.message = params.message
    render(view: "generarPagosParaLaCamada", model: [pagos: listaPagos])
  }

  def eliminarEsquemaDePago(){
    def paymentScheme = PaymentScheme.get(params.id)
    paymentScheme.delete()
    redirect(action:'nuevo')
  }

  private def verificarExistenciaDeFechaDeVencimientoEnDescuentoParaObtenerPagosConDescuentosAplicables(PaymentGroupCommand paymentGroupCommand,PaymentScheme paymentScheme, List pagos) {
    def listaDePagos = []
    pagos.each{ pago -> 
      def descuentosAplicables = applicableDiscountService.generateApplicableDiscountsForPaymentWithPaymentSchemeAndReferenceDate(paymentScheme.id, pago.dueDate, paymentGroupCommand.expirationDatesForDiscounts)
      listaDePagos +=  asignarDescuntosAplicablesAlosPagos(descuentosAplicables,pago)
    }
    listaDePagos
  }

  private def asignarDescuntosAplicablesAlosPagos(def applicableDiscount, Payment payment) {
    def paymentsList = []
    if (applicableDiscount instanceof ApplicableDiscount)
      paymentsList << applicableDiscountService.addApplicableDiscountToAPayment(applicableDiscount, payment.id)
    else if (applicableDiscount instanceof List<ApplicableDiscount>) {
      applicableDiscount.each { aDiscount ->
        paymentsList << applicableDiscountService.addApplicableDiscountToAPayment(aDiscount, payment.id)
      }
    }
    paymentsList
  }

  private def notificarCreacionDePago(def listaDePagos) {
    def dependientes = dependienteService.obtenerDependientesPorPagos(listaDePagos)
    notificacionService.notificarPagosCreados(dependientes)

  }

}
