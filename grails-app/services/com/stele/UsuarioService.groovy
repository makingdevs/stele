package com.stele

import com.stele.seguridad.Usuario
import com.stele.seguridad.Rol
import com.stele.seguridad.UsuarioRol

class UsuarioService {

  def perfilService

  def obtenerUsuarioDesdeCommand(FilaExcelCommand filaExcelCommand) {
    def usuario = new Usuario()
    def perfil = new Perfil()
    def telefono = new Telefono()
    perfil.nombre = filaExcelCommand.tutorNombre
    perfil.apellidoPaterno = filaExcelCommand.tutorApellidoPaterno
    perfil.apellidoMaterno = filaExcelCommand.tutorApellidoMaterno
    telefono.numeroTelefonico = filaExcelCommand.telefono.replaceAll( "[^\\d.]", "" )
    perfil.addToTelefonos(telefono)
    usuario.perfil = perfil
    usuario.username = filaExcelCommand.correoElectronico
    usuario.password = armaPasswordTemporal(perfil.nombre,usuario.username,telefono.numeroTelefonico)
    usuario.enabled = true
    usuario
  }

  def registrar(Usuario usuario){
    def existeUsuario = Usuario.findByUsername(usuario.username)
    if(!existeUsuario) {
      usuario.perfil = perfilService.registrar(usuario.perfil)
      usuario.save(flush:true)
      def rol = Rol.findByAuthority("ROLE_PADRE_TUTOR")
      UsuarioRol.create(usuario, rol, true)
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

