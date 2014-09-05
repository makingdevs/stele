package com.stele

import com.payable.GrupoPagoCommand
import java.text.SimpleDateFormat

class WrapperCommandService {

  GrupoPagoCommand generarParseoDeCamadaPagoCommandAGrupoPagoCommand(CamadaPagoCommand camadaPagoCommand, Institucion institucion) {
    GrupoPagoCommand gcp = new GrupoPagoCommand()
    if (camadaPagoCommand.recargoid){
      if (camadaPagoCommand.recargoid.first() != "")
        gcp.recargoId = camadaPagoCommand.recargoid?.first()?.toLong()
    }
    
    if(camadaPagoCommand.fechasDeExpiracionDescuento){
      def sdf = new SimpleDateFormat("dd/MM/yy")
      def fechasDeExpiracionParaDescuentos = [];

      camadaPagoCommand.fechasDeExpiracionDescuento.each{ fechaDeExpiracion ->
        try{
          fechasDeExpiracionParaDescuentos << sdf.parse(fechaDeExpiracion) 
        }catch(Exception exception){
          log.error "The date has not been converted"
        }
      }
      gcp.fechasDeExpiracionDescuento = fechasDeExpiracionParaDescuentos
    }

    if (!gcp.recargoId)
      gcp.recargoId = camadaPagoCommand?.idRecargo?.toLong()
    gcp.cantidadDePago = camadaPagoCommand.cantidadDePago ?: camadaPagoCommand.cantidadDePagoRecurrente
    gcp.conceptoDePago = camadaPagoCommand.conceptoDePago ?: camadaPagoCommand.conceptoDePagoRecurrente
    if (camadaPagoCommand?.fechaDeVencimiento)  
      gcp.fechaDeVencimiento = new Date().parse("dd/MM/yyyy", camadaPagoCommand?.fechaDeVencimiento)
    if (camadaPagoCommand.descuentos){
      if (camadaPagoCommand.descuentos.first() != "") 
        gcp.descuentoIds = camadaPagoCommand?.descuentos.collect{it.replace('[','').replace(']','')}
    }
    if (!gcp.descuentoIds)
      gcp.descuentoIds = camadaPagoCommand.idsDescuentos?.replace('[','')?.replace(']','')?.split(',')
    gcp.organizacion = institucion
    gcp.diasVencimientoPago = camadaPagoCommand.diasVencimientoPago
    gcp.payables = obtenerListaDePayables(camadaPagoCommand)
    gcp.meses = camadaPagoCommand.meses ?: []
    gcp.pagoDoble = camadaPagoCommand?.pagoDoble ?:[]
    gcp
  }

  private def obtenerListaDePayables(CamadaPagoCommand camadaPagoCommand) {
    def listaDependientesExistentes = []
    def dependientes = Dependiente.findAllByCamada(camadaPagoCommand.camada)
    listaDependientesExistentes << camadaPagoCommand?.listaDependientes?.replace('[','')?.replace(']','')?.split(',')
    listaDependientesExistentes?.removeAll(dependientes*.id)

    if (listaDependientesExistentes){
      dependientes+= Dependiente.withCriteria {
        'in'('id', listaDependientesExistentes.flatten()*.toLong())
      }
    }
    dependientes
  }

}
