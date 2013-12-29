package com.stele

import com.stele.seguridad.Usuario
import com.stele.seguridad.Rol
import com.stele.seguridad.UsuarioRol
import com.makingdevs.*

class UsuarioService {

  def perfilService
  def springSecurityService
  def notificacionService

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

  def obtenerUsuarioDesdeCommand(InscripcionCommand inscripcionCommand){
    def usuario = new Usuario()
    def perfil = new Perfil()
    def telefono = new Telefono()
    perfil.nombre = inscripcionCommand.nombrePadre
    perfil.apellidoPaterno = inscripcionCommand.apellidoPaternoPadre
    perfil.apellidoMaterno = inscripcionCommand.apellidoMaternoPadre
    telefono.numeroTelefonico = inscripcionCommand.telefono.replaceAll( "[^\\d.]", "" )
    perfil.addToTelefonos(telefono)
    usuario.perfil = perfil
    usuario.username = inscripcionCommand.email
    usuario.password = armaPasswordTemporal(perfil.nombre,usuario.username,telefono.numeroTelefonico)
    usuario.enabled = true
    usuario
  }

  def registrar(Usuario usuario, def institucion){
    def existeUsuario = Usuario.findByUsername(usuario.username)
    if(!existeUsuario) {
      usuario.perfil = perfilService.registrar(usuario.perfil)
      usuario.addToInstituciones(institucion)
      usuario.save()
      def rol = Rol.findByAuthority("ROLE_PADRE_TUTOR")
      UsuarioRol.create(usuario, rol, true)
      return  usuario
    }
    def usuarioInstitucion = Usuario.withCriteria{
      eq('username', usuario.username)
      instituciones {
        eq('id', institucion.id)
      }
    }

    if(!usuarioInstitucion.isEmpty())
      return usuarioInstitucion.first()

  }

  private String armaPasswordTemporal(String nombre, String correo, String telefono){
    String passworGenerado = nombre?.substring(0,2) + 
                              correo?.substring(0,2) + 
                              telefono?.substring((telefono.length()-4)) 
    passworGenerado.toLowerCase()
  }

  def registrarUsuarioDirector(params) {
    Institucion institucion = new Institucion(params.institucion)
    Usuario usuario = new Usuario(params.usuario + [enabled:true])
    Perfil perfil = new Perfil(params.perfil)
    Telefono telefono = new Telefono()
    if (!Usuario.findByUsername(usuario.username)) {
      def rol = Rol.findByAuthority("ROLE_DIRECTOR")
      telefono.numeroTelefonico = params.numeroTelefonico
      telefono.save()
      perfil.addToTelefonos(telefono)
      usuario.perfil = perfil.save()
      usuario.addToInstituciones(institucion)
      usuario.save()
      UsuarioRol.create(usuario, rol, true)
      notificacionService.notificarRegistroUsuarioAdministrador(usuario.username)
    }
    usuario
  }

}

