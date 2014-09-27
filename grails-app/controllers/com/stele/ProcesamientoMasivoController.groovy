package com.stele

class ProcesamientoMasivoController {

  def procesamientoMasivoService

  def index() {
    def listaDeMapaDeDominios = flash.listaDeMapaDeDominios
    def institucion = Institucion.get(params?.long("institucionId"))
    def nombreDeInstitucion = institucion.name.size() > 100 ? institucion.name.substring(0,80) : institucion.name
    def usuariosPersistidos = [] as Set
    def dependientesPersistidos = [] as Set
    def ciclosEscolaresPersistidos = [] as Set
    def dependientesExistentes = [] as Set
    def usuariosErroneos = [] as Set
    def historialesAcademicos = [] as Set
    def camadaGenerada = nombreDeInstitucion.replaceAll(" ","_") + "_" + new Date().format("dd_MM_yy_HH_mm")

    listaDeMapaDeDominios*.dependiente*.camada = camadaGenerada
    listaDeMapaDeDominios.each { l ->
      def mapaDeDominiosPersistidos = procesamientoMasivoService.procesaMapaConDatosDeFilaDeExcelParaPersistir(l,params.long("institucionId") )
      if (!mapaDeDominiosPersistidos.dependienteExistente) {  
        usuariosPersistidos.add(mapaDeDominiosPersistidos.usuario)
        dependientesPersistidos.add(mapaDeDominiosPersistidos.dependiente)
        dependientesExistentes.add( mapaDeDominiosPersistidos.dependiente.id)
        ciclosEscolaresPersistidos.add(mapaDeDominiosPersistidos.cicloEscolar)
        historialesAcademicos.add(mapaDeDominiosPersistidos.historialAcademico)
        flash.dependientes = dependientesExistentes
      } else{
        usuariosErroneos.add(mapaDeDominiosPersistidos.dependienteExistente)
      }

    }
    [
      camadaGenerada: camadaGenerada,
      usariosProcesados: usuariosPersistidos?.size(),
      dependientesProcesados: dependientesPersistidos?.size(),
      ciclosEcolaresProcesados: ciclosEscolaresPersistidos?.size(),
      listaUsuariosProcesados: dependientesExistentes,
      dependientes: dependientesPersistidos,
      erroneos: usuariosErroneos?.size(),
      historiales: historialesAcademicos
    ]
  }

}

