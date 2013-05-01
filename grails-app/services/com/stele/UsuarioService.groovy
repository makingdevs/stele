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
    existeUsuario ?: usuario.save(flush:true)
  }

  private String armaPasswordTemporal(String nombre, String correo, String telefono){
    String passworGenerado = nombre?.substring(0,2) + 
                              correo?.substring(0,2) + 
                              telefono?.substring((telefono.length()-4)) 
    passworGenerado.toLowerCase()
  }

}

