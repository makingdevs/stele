package com.stele

import org.grails.s3.S3Asset
import com.stele.Pago

class ComprobanteService {

  def s3AssetService

  def agregarComprobanteAPago(Long pagoId, file) {
    S3Asset receipt = new S3Asset()
    Pago pago = Pago.get(pagoId)
    def tmp = s3AssetService.getNewTmpLocalFile(file.contentType)
    file.transferTo(tmp)
    receipt.newFile(tmp)
    receipt.mimeType = file.contentType
    s3AssetService.put(receipt)
    pago.comprobanteDePago = receipt
    pago.estatusDePago = EstatusDePago.PROCESO
    pago.save()
  }

}
