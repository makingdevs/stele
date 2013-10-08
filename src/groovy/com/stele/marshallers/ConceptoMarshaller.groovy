package com.stele.marshallers

import grails.converters.JSON
import com.payable.Concepto
import org.codehaus.groovy.grails.web.converters.marshaller.ObjectMarshaller

public class ConceptoMarshaller implements ObjectMarshaller<JSON> {

  public boolean supports(Object object) {
        return object instanceof Concepto;
  }

  public void marshalObject(Object object, JSON converter) {
    def concepto = object as Concepto
    def conceptoValues = [key:concepto.id,value: concepto.descripcion]
    converter.convertAnother(conceptoValues)
  }

}