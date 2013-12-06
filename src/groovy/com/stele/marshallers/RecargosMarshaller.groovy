package com.stele.marshallers

import grails.converters.JSON
import com.payable.Recargo
import org.codehaus.groovy.grails.web.converters.marshaller.ObjectMarshaller

public class RecargosMarshaller implements ObjectMarshaller<JSON> {

  public boolean supports(Object object) {
    return object instanceof Recargo;
  }

  public void marshalObject(Object object,JSON converter) {
    def recargo = object as Recargo
    def recargoValues = [id:recargo.id, porcentaje: recargo.porcentaje, cantidad: recargo.cantidad]
    converter.convertAnother(recargoValues)
  }

}