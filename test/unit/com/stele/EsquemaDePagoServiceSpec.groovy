package com.stele

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import com.payable.*

@TestFor(EsquemaDePagoService)
@Mock([Concepto,Institucion,Recargo,Descuento,EsquemaDePago])
class EsquemaDePagoServiceSpec extends Specification {

  def "Generar un objeto esquema de pago nuevo"() {
    setup:
      Institucion institucion = new Institucion()
      institucion.nombre = "making_devs"
      institucion.save(validate:false)
    and:
      Concepto concepto = new Concepto()
      concepto.descripcion = "concepto"
      concepto.organizacion = institucion
      concepto.save(validate:false)
    and:
      Recargo recargo = new Recargo()
      recargo.cantidad = 350
      recargo.save(validate:false) 
    and:
      Descuento descuento = new Descuento()
      descuento.nombreDeDescuento = "descuento"
      descuento.cantidad = 5000
      descuento.diasPreviosParaCancelarDescuento = 6
      descuento.organizacion = institucion
      descuento.save(validate:false)
    and:
      GrupoPagoCommand gpc = new GrupoPagoCommand()
      gpc.cantidadDePago = 13000
      gpc.conceptoDePago = "concepto"
      gpc.recargoId = recargo.id
      gpc.descuentoIds = ["[${descuento.id}]"]
    when:
      def esquemaDePago = service.buscarOSalvarEsquemaDePago(gpc)
    then:
      assert esquemaDePago.id > 0
      assert esquemaDePago.recargo.id >0
      assert esquemaDePago.cantidadDePago == 13000
  }


}