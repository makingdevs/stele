package com.stele

import org.grails.s3.S3Asset

class ReciboPagoController {

  def s3AssetService

  def index() { 
    [pago: Pago.get(params.id)]
  }

  def subirArchivo() {
    def file = params.file
    log.debug "params : $params"
    def receipt = new S3Asset()
    def tmp = s3AssetService.getNewTmpLocalFile(file.contentType)
    // Transferimos el archivo
    file.transferTo(tmp)
    // Usamos el método del asset para crear un archivo nuevo
    receipt.newFile(tmp);
    // El tipo del archivo es...
    receipt.mimeType = file.contentType;
    // Subimos el archivo
    s3AssetService.put(receipt)
    //Obtener el pago
    // Crear el s3asset
    // asignarle los bytes
    // persistir el s3
    // asignar s3 a el pago
    render "chido"
  }

  def muestra(){
    S3Asset s3 = S3Asset.get(params.id)
    [s3:s3]
  }

}
