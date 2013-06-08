package com.stele

import com.stele.seguridad.Usuario

class UsuarioService {

  def obtenerUsuarioDesdeCommand(FilaExcelCommand filaExcelCommand) {
    def usuario = new Usuario()
    def perfil = new Perfil()
    def telefono = new Telefono()
    perfil.nombre = filaExcelCommand.tutorNombre
    perfil.apellidoPaterno = filaExcelCommand.tutorApellidoPaterno
    perfil.apellidoMaterno = filaExcelCommand.tutorApellidoMaterno
    telefono.numeroTelefonico = filaExcelCommand.telefono
    perfil.addToTelefonos(telefono)
    usuario.perfil = perfil
    usuario.username = filaExcelCommand.correoElectronico
    usuario.password = armaPasswordTemporal(filaExcelCommand.tutorNombre,filaExcelCommand.correoElectronico,filaExcelCommand.telefono)
    usuario.enabled = true
    usuario
  }

  def registrar(Usuario usuario){
    def existeUsuario = Usuario.findByUsername(usuario.username)

    if(!existeUsuario) {
      Perfil perfil = usuario.perfil
      log.debug "perfil telefonos : ${perfil.telefonos.size()}"
      log.debug "perfil telefonos : ${perfil.telefonos.first().validate()}"
      log.debug "perfil telefonos : ${perfil.telefonos.first().errors}"
      log.debug "perfil : ${perfil.validate()}"
      log.debug "perfil : ${perfil.errors}"
      perfil.save(flush:true)
      usuario.perfil = perfil
      usuario.save(flush:true)
      return  usuario
    }

    existeUsuario
  }

  private String armaPasswordTemporal(String nombre, String correo, String telefono){
    String passworGenerado = nombre?.substring(0,2) + 
                              correo?.substring(0,2) + 
                              telefono?.substring((telefono.length()-4)) 
    passworGenerado.toLowerCase()
  }

}

