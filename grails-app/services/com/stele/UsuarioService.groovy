package com.stele

import com.stele.seguridad.Usuario

class UsuarioService {

  def obtenerUsuarioDesdeCommand(FilaExcelCommand filaExcelCommand) {
    def usuario = new Usuario()
    def perfil = new Perfil()
    perfil.nombre = filaExcelCommand.tutorNombre
    perfil.apellidoPaterno = filaExcelCommand.tutorApellidoPaterno
    perfil.apellidoMaterno = filaExcelCommand.tutorApellidoMaterno
    usuario.perfil = perfil
    usuario.username = filaExcelCommand.correoElectronico
    usuario.password = UUID.randomUUID().toString().replaceAll('-', '').substring(0,10)
    usuario.enabled = true
    usuario
  }

  def registrar(Usuario usuario){
    def existeUsuario = Usuario.findByUsername(usuario.username)
    existeUsuario ?: usuario.save()
  }

}

