package com.stele

import grails.test.mixin.*
import spock.lang.Specification
import spock.lang.Unroll
import com.stele.seguridad.Usuario
import com.makingdevs.*
import com.payable.*

@TestFor(PagoService)
@Mock([HistorialAcademico,Dependiente,DistribucionInstitucional,Institucion,Usuario,Perfil,Pago,EsquemaDePago, Recargo, Concepto])
class PagoServiceSpec extends Specification {

  @Unroll("Crear un pago con el concepto: '#conceptoDePago', vencimiento: '#fechaDeVencimiento' y la cantidad: '\$ #cantidadDePago'")
  def "Crear un pago con el concepto: '#conceptoDePago', vencimiento: '#fechaDeVencimiento' y la cantidad: '#cantidadDePago'"(){
    given:
      EsquemaDePago esquemaDePago = new EsquemaDePago()
      esquemaDePago.cantidadDePago = cantidadDePago
      esquemaDePago.concepto = new Concepto(descripcion:conceptoDePago).save(validate:false)
      esquemaDePago.recargo = new Recargo(cantidad:1).save(validate:false)
      esquemaDePago.save(validate:false)
    when:
      def pago = service.crearPago(fechaDeVencimiento, esquemaDePago.id)
    then:
      pago.id > 0
      pago.transactionId
      pago.cantidadDePago == cantidadDePago
      pago.conceptoDePago == conceptoDePago
      pago.fechaDeVencimiento.date  == fechaDeVencimiento.date
      pago.fechaDeVencimiento.month  == fechaDeVencimiento.month
      pago.fechaDeVencimiento.year  == fechaDeVencimiento.year
      pago.tipoDePago == TipoDePago.TRANSFERENCIA_BANCARIA
      pago.estatusDePago == EstatusDePago.CREADO
      pago.recargosAcumulados == 0

    where:
      fechaDeVencimiento || cantidadDePago | conceptoDePago 
      new Date() + 30    || 1234.45        | "Inscripción"  
      new Date() + 40    || 1345.98        | "Colegiatura"  
      new Date() + 30    || 1500.00        | "Inscripción"  
      new Date() + 30    || 1750.50        | "Excursión"    
      new Date() + 90    || 9999.99        | "Televisión"   
      new Date() + 30    || 1234.45        | "Inscripción"  
  }

}
