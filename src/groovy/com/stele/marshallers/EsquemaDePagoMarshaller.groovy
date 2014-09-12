package com.stele.marshallers

import grails.converters.JSON
import com.payable.PaymentScheme
import org.codehaus.groovy.grails.web.converters.marshaller.ObjectMarshaller

public class EsquemaDePagoMarshaller implements ObjectMarshaller<JSON> {

  public boolean supports(Object object) {
    return object instanceof PaymentScheme;
  }

  public void marshalObject(Object object,JSON converter) {
    def paymentScheme = object as PaymentScheme
    def discounts = []
    paymentScheme.discounts.sort{ discount -> discount.id }.each{ discount ->
      discounts << [id:discount.id, 
                    descuento:discount.discountName,
                    cantidad:discount.amount ? "\$${discount.amount}":"%${discount.percentage}"]
    }
    
    def paymentSchemeValues = [key:paymentScheme.id,
                               value:paymentScheme.concept,
                               paymentAmount:paymentScheme.paymentAmount,
                               surcharge:paymentScheme.surcharge,
                               discountIds: paymentScheme.discounts*.id.toString(),
                               discounts: discounts]

    converter.convertAnother(paymentSchemeValues)
  }

}
