package com.stele

import com.payable.GrupoPagoCommand

class WrapperCommandService {

  GrupoPagoCommand generarParseoDeCamadaPagoCommandAGrupoPagoCommand(CamadaPagoCommand camadaPagoCommand) {
    GrupoPagoCommand gpc = new GrupoPagoCommand(camadaPagoCommand.propertie)
    gpc
  }

}