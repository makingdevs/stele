package com.stele

import grails.converters.JSON
import com.stele.Descuento
import org.codehaus.groovy.grails.web.converters.marshaller.ObjectMarshaller

public class DescuentoMarshaller implements ObjectMarshaller<JSON> {

  public boolean supports(Object object) {
    return object instanceof Descuento;
  }

  public void marshalObject(Object object, JSON converter) {
    def descuento = object as Descuento
    def decuentoValues = [descuento.id, descuento.nombreDeDescuento]
  }

}