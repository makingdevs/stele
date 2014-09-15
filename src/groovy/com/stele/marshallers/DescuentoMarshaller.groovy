package com.stele

import grails.converters.JSON
import com.payable.Discount
import org.codehaus.groovy.grails.web.converters.marshaller.ObjectMarshaller

public class DescuentoMarshaller implements ObjectMarshaller<JSON> {

  public boolean supports(Object object) {
    return object instanceof Discount
  }

  public void marshalObject(Object object, JSON converter) {
    def discount = object as Discount
    def discountValues = [key:discount.id,
                          value:discount.discountName,
                          porcentaje: discount.percentage,
                          cantidad: discount.amount,
                          dias: discount.previousDaysForCancelingDiscount]

    converter.convertAnother(discountValues)
  }

}
