package com.stele

import com.payable.GrupoPagoCommand

class WrapperCommandService {

  GrupoPagoCommand generarParseoDeCamadaPagoCommandAGrupoPagoCommand(CamadaPagoCommand camadaPagoCommand, Institucion institucion) {
    GrupoPagoCommand gpc = new GrupoPagoCommand()
    gcp.recargoId = camadaPagoCommand.recargoId
    gcp.cantidadDePago = camadaPagoCommand.cantidadDePago
    gcp.conceptoDePago = camadaPagoCommand.conceptoDePago
    gcp.fechaDeVencimiento = camadaPagoCommand.fechaDeVencimiento
    gcp.descuentoIds = camadaPagoCommand.descuentos
    gcp.organizacion = institucion
    gcp.payables = obtenerListaDePayables(camadaPagoCommand)
    gcp.meses = camadaPagoCommand.meses
    gcp.pagoDoble = camadaPagoCommand.pagoDoble
  }

  

}