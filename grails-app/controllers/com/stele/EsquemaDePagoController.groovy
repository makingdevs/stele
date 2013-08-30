package com.stele

import grails.converters.JSON

class EsquemaDePagoController {

  def springSecurityService
  def generacionDePagoService

  def scaffold = EsquemaDePago
 
  def paraCamada() {
    [camada:params?.camada]
  }

  def generarPagoParaLaCamada(CamadaPagoCommand cpc) {
    if(cpc.hasErrors()) {
      render cpc.errors
      return
    } 

    generacionDePagoService.paraCamadaPagoCommand(cpc)
    flash.success = "Bien Hecho"
    redirect action:"muestraPagosDeCamada",params: params + [camada:cpc.camada,fechaDeVencimiento:cpc.fechaDeVencimiento.format('yyyy-MM-dd')]
  }

  def muestraPagosDeCamada(){
    def dependientes = Dependiente.findAllByCamada(params.camada)
    def criteria = Pago.createCriteria()
    def pagos = criteria.list(max:params.max?:10, offset: params.offset?:0) {
      eq("fechaDeVencimiento", new Date().parse('yyyy-MM-dd', params.fechaDeVencimiento))
      historialAcademico {
        dependiente {
          'in'('id',dependientes*.id)
        }
      }
    }
    render(view: "generarPagosParaLaCamada", model: [pagos: pagos, pagosCount: dependientes])
  }

}
