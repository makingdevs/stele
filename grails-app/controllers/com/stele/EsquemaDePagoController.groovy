
package com.stele

import grails.converters.JSON
import com.payable.*
import java.text.DateFormatSymbols

class EsquemaDePagoController {

  def springSecurityService
  def generationOfPaymentService 
  def wrapperCommandService
  def paymentSchemeService 
  def applicableDiscountService
  def dependienteService
  def notificacionService
  def conceptService
  def cobroParaCamadaService

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

    if (params.recargoId)
      pgc.surchargeId = params.long("recargoId")

    pgc.paymentAmount = params.importeEsquemaDePago.toBigDecimal()
    pgc.paymentConcept = concept.description
    pgc.organization = institucion
    if (params.list("discount"))
      pgc.discountIds = params.list("discount")*.toLong()

    def scheme = paymentSchemeService.savePaymentScheme(pgc)
    redirect(action:'nuevo')
  }
 
  def paraCamada() {
    def listaDependientes = params.list("dependientes")
    def c = Calendar.instance
    c.setTime(new Date())
    
    def months = (0..11).collect{new DateFormatSymbols().months[ (it+7) % 12 ].capitalize()}    
    [camada:params?.camada,listaDependientes:listaDependientes.join(','),
                           months:months,
                           lastDayOfTheMonth:c.getActualMaximum(Calendar.DAY_OF_MONTH)]
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

    def pagos = generationOfPaymentService.generatePaymentsForGroup(grupoPagoCommand) ?: []
    def esquemaDePago = paymentSchemeService.savePaymentScheme(grupoPagoCommand)
    def paymentsWithOrWithoutApplicableDiscounts = []
    if(cpc.diasVencimientoDescuento){
      paymentsWithOrWithoutApplicableDiscounts = cobroParaCamadaService.obtenerPagosRecurrentesConDescuentosAplicables(esquemaDePago,cpc,pagos,grupoPagoCommand.instances.size()) 
    }else
      paymentsWithOrWithoutApplicableDiscounts = cobroParaCamadaService.obtenerPagosConDescuentosAplicablesSiTienenFechaDeVencimiento(grupoPagoCommand,esquemaDePago,pagos) ?: pagos 

    if (paymentsWithOrWithoutApplicableDiscounts)
      notificarCreacionDePago(paymentsWithOrWithoutApplicableDiscounts)
    flash.pago = paymentsWithOrWithoutApplicableDiscounts 

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
  
  private def notificarCreacionDePago(def listaDePagos){
    def dependientes = dependienteService.obtenerDependientesPorPagos(listaDePagos)
    notificacionService.notificarPagosCreados(dependientes)
  }

}
