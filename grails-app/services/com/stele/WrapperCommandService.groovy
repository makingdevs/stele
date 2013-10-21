package com.stele

import com.payable.GrupoPagoCommand

class WrapperCommandService {

  GrupoPagoCommand generarParseoDeCamadaPagoCommandAGrupoPagoCommand(CamadaPagoCommand camadaPagoCommand, Institucion institucion) {
    GrupoPagoCommand gcp = new GrupoPagoCommand()
    gcp.recargoId = camadaPagoCommand.recargoid?.first()?.toLong()
    gcp.cantidadDePago = camadaPagoCommand.cantidadDePago
    gcp.conceptoDePago = camadaPagoCommand.conceptoDePago
    gcp.fechaDeVencimiento = camadaPagoCommand.fechaDeVencimiento
    gcp.descuentoIds = camadaPagoCommand.descuentos
    gcp.organizacion = institucion
    gcp.payables = obtenerListaDePayables(camadaPagoCommand)
    gcp.meses = camadaPagoCommand?.meses
    gcp.pagoDoble = camadaPagoCommand?.pagoDoble
    gcp
  }

  private def obtenerListaDePayables(CamadaPagoCommand camadaPagoCommand) {
    def listaDependientesExistentes = []
    def dependientes = Dependiente.findAllByCamada(camadaPagoCommand.camada)
    camadaPagoCommand?.listaDependientes?.each { it ->
      if ( !(it.equals("[") || it.equals("]") || it.equals(",") || it.equals(" ")) ) 
          listaDependientesExistentes.add(it.toLong())
    }
    listaDependientesExistentes?.removeAll(dependientes*.id)

    if (listaDependientesExistentes){
      dependientes+= Dependiente.withCriteria {
        'in'('id', listaDependientesExistentes)
      }
    }
    dependientes
  }

}