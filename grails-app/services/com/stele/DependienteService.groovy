package com.stele

import com.stele.seguridad.Usuario

class DependienteService {

  def perfilService

  def obtenerDependienteDesdeCommand(FilaExcelCommand filaExcelCommand) {
    def perfil = new Perfil()
    perfil.nombre = filaExcelCommand.dependienteNombre
    perfil.apellidoPaterno = filaExcelCommand.dependienteApellidoPaterno
    perfil.apellidoMaterno = filaExcelCommand.dependienteApellidoMaterno
    def dependiente = new Dependiente()
    dependiente.matricula = filaExcelCommand.matricula
    dependiente.perfil = perfil
    dependiente
  }

  def registrar(Dependiente dependiente, Long usuarioId){
    Usuario usuario = Usuario.get(usuarioId)
    if(usuario){
      dependiente.usuario = usuario
      dependiente.perfil = perfilService.registrar(dependiente.perfil)
      dependiente.save()
      }else{
        dependiente
      }
    }

  }
