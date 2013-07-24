package com.stele

import com.stele.seguridad.Usuario;
import com.stele.DistribucionInstitucional;
import com.stele.HistorialAcademico;
import com.stele.Pago;
import com.stele.TipoDePago
import com.stele.EstatusDePago

class PagoService {

  def s3AssetService

  def obtenerPagosDeUsuario(Usuario usuario) {
    def criteriaDependiente = Dependiente.createCriteria()
    def pagosDeUsuario = [] as Set 
    List<Dependiente> dependientesDeUsuario = criteriaDependiente.list {
        eq("usuario", usuario)
    }
    dependientesDeUsuario.each{ dependiente ->
      Dependiente dependienteExistente = dependiente.get(dependiente.id)
      pagosDeUsuario.addAll(dependienteExistente.pagos)
    }
    pagosDeUsuario
  }

  def obtenerPagosDeUnaInstitucion(Usuario usuario) {
    def institucionUsuario = usuario.instituciones
    def distribucionInstitucional = DistribucionInstitucional.withCriteria {
      'in'('institucion', institucionUsuario)
    }
    def historialAcademico = HistorialAcademico.withCriteria {
      'in'('distribucionInstitucional', distribucionInstitucional)
    }
    def pagos = Pago.withCriteria {
      'in'('historialAcademico', historialAcademico)
    }
    pagos
  }

  def obtenerPagoParaValidarComprobante(Long pagoId) {
    def pago = Pago.findById(pagoId,[fetch:['comprobanteDePago':'join']])
    def historialAcademico = HistorialAcademico.findById(pago.historialAcademicoId)
    def dependiente = Dependiente.findById(historialAcademico.dependienteId)
    def perfil = Perfil.findById(dependiente.perfilId)
    [pago:pago, perfil:perfil]
  }

  def validarComprobanteDePago(def datos) {
    def pago = Pago.findById(datos.pago.toLong())
    pago.fechaDePago = datos.fechaPago
    pago.tipoDePago = TipoDePago.find {it.key == datos.tipoPago}
    pago.estatusDePago = EstatusDePago.PAGADO
    pago.save(flush:true)
  }

  def rechazarComprobanteDePago(def params) {
    def pago = Pago.findById(params.pago.toLong())
    s3AssetService.delete(pago.comprobanteDePago)
    pago.comprobanteDePago = null
    pago.estatusDePago = EstatusDePago.RECHAZADO
    pago.save(flush:true)

  }


}
