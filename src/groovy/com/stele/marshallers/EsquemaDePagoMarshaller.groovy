package com.stele.marshallers

import grails.converters.JSON
import com.payable.EsquemaDePago
import org.codehaus.groovy.grails.web.converters.marshaller.ObjectMarshaller

public class EsquemaDePagoMarshaller implements ObjectMarshaller<JSON> {

  public boolean supports(Object object) {
    return object instanceof EsquemaDePago;
  }

  public void marshalObject(Object object,JSON converter) {
    def esquemaDePago = object as EsquemaDePago
    def esquemaDePagoValues = [key:esquemaDePago.id, value:esquemaDePago.concepto, cantidadDePago:esquemaDePago.cantidadDePago,recargo:esquemaDePago.recargo, descuentos: esquemaDePago.descuentos]
    converter.convertAnother(esquemaDePagoValues)
  }

}