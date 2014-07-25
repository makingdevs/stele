package com.stele

import grails.converters.JSON
import com.payable.Descuento
import org.codehaus.groovy.grails.web.converters.marshaller.ObjectMarshaller

public class DescuentoMarshaller implements ObjectMarshaller<JSON> {

  public boolean supports(Object object) {
    return object instanceof Descuento;
  }

  public void marshalObject(Object object, JSON converter) {
    def descuento = object as Descuento
    def decuentoValues = [key:descuento.id,value:descuento.nombreDeDescuento,
                          porcentaje: descuento.porcentaje,
                          cantidad: descuento.cantidad,
                          dias: descuento.diasPreviosParaCancelarDescuento]

    converter.convertAnother(decuentoValues)
  }

}