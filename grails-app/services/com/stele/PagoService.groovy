package com.stele

import com.stele.seguridad.Usuario;
import com.stele.DistribucionInstitucional;
import com.stele.HistorialAcademico;
import com.stele.Pago
import com.stele.TipoDePago
import com.stele.EstatusDePago
import com.stele.Dependiente
import com.makingdevs.*

class PagoService {

  def crearPagoSimple(String concepto, Date fechaDeVencimiento, BigDecimal cantidad){
    def p = new Pago(conceptoDePago:concepto,fechaDeVencimiento:fechaDeVencimiento,cantidadDePago:cantidad)
    p
  }

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
    [dependiente: dependientesDeUsuario, pagos: pagosDeUsuario]
  }

  def obtenerPagosDeUnaInstitucion(Usuario usuario) {
    def institucionUsuario = usuario.instituciones

    def distribucionInstitucional = DistribucionInstitucional.withCriteria {
      'in'('institucion', institucionUsuario)
    }
    def historialAcademico = HistorialAcademico.withCriteria {
      'in'('distribucionInstitucional', distribucionInstitucional)
    }
    [dependiente: historialAcademico.dependiente, historial:historialAcademico]
  }

  def obtenerPagoParaValidarComprobante(Long pagoId) {
    Pago.findById(pagoId,[fetch:['comprobanteDePago':'join']])

  }


  def estadoDeCuentaUsuario(Usuario usuario) {
    [pagosVencidos:obtenerPagosDeUsuarioQueSon(usuario,"Vencidos"),
     pagosEnTiempo:obtenerPagosDeUsuarioQueSon(usuario,"EnTiempoConDescuento"),
     pagosPorRealizar:obtenerPagosDeUsuarioQueSon(usuario,"EnTiempoSinDescuento"),
     pagoMensual:obtenerPagosConciliadosFavorablemente(usuario)]

  }

  def buscarPagosConFechasDeVencimientoCumplida() {
    List listaDePagosConFechaVencida = Pago.withCriteria{
      eq('estatusDePago', EstatusDePago.CREADO)
      ge('fechaDeVencimiento', new Date())
    }


  }

  private def cambiarEstatusDeUnPagoAVencido(List listaDePagosConFechaVencida) {
    List listaDePagosConNuevoEstatusVencido = []

    listaDePagosConFechaVencida.each { pago ->
      if (pago.estatusDePago == EstatusDePago.CREADO) {
        pago.estatusDePago = EstatusDePago.VENCIDO
        listaDePagosConNuevoEstatusVencido.add(pago.save())
      }
    }
    listaDePagosConNuevoEstatusVencido
  }


  private def obtenerPagosDeUsuarioQueSon(Usuario usuario, String tipoDePago){
    def dependienteHistorial = obtenerDependientesEHistorialAcademicoPorTutor(usuario)
    Pago.withCriteria {
      'in'('historialAcademico', dependienteHistorial.historiales)
       switch(tipoDePago){
          case "Vencidos":
            le('fechaDeVencimiento', new Date()) 
            eq('estatusDePago', EstatusDePago.VENCIDO)
          break
          case "EnTiempoConDescuento":
            ge('fechaDeVencimiento', new Date())
            eq('estatusDePago', EstatusDePago.CREADO)
            isNotEmpty("descuentos")
          break
          case "EnTiempoSinDescuento":
            ge('fechaDeVencimiento', new Date())
            eq('estatusDePago', EstatusDePago.CREADO)
            isEmpty("descuentos")
          break
       }
    }
  }

  private def obtenerPagosConciliadosFavorablemente(Usuario usuario) {
    def dependienteHistorial = obtenerDependientesEHistorialAcademicoPorTutor(usuario)

    def pagos = Pago.withCriteria {
      between("lastUpdated",getFirstAndLastDayOfMonth('first'), getFirstAndLastDayOfMonth('last'))
      'in'('historialAcademico', dependienteHistorial.historiales)
      eq('estatusDePago', EstatusDePago.PAGADO)

    }
    pagos
  }

  private def obtenerDependientesEHistorialAcademicoPorTutor(Usuario usuario) {
    def dependientesUsuario = Dependiente.withCriteria {
      'in'('usuario', usuario)
    }

    def historialAcademico = HistorialAcademico.withCriteria {
      'in'('dependiente', dependientesUsuario)
    } 

    [dependientes:dependientesUsuario, historiales: historialAcademico]
  }

  private def getFirstAndLastDayOfMonth(String indicador) {
    Calendar calendar = Calendar.getInstance()
    calendar.setTime(new Date())
    if (indicador.equals('first')) {
      new Date("${calendar.get(Calendar.YEAR)}/${calendar.get(Calendar.MONTH)+1}/01")
    } else {
      new Date("${calendar.get(Calendar.YEAR)}/${calendar.get(Calendar.MONTH)+1}/31")
    }
  }

}
