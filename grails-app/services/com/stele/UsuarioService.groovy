package com.stele

import com.stele.seguridad.Usuario
import com.stele.seguridad.Rol
import com.stele.seguridad.UsuarioRol
import com.makingdevs.*

class UsuarioService {

  def perfilService
  def springSecurityService
  def notificacionService

  def obtenerUsuarioDesdeCommand(FilaExcelCommand filaExcelCommand) throws Exception{
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
    def perfil = new Perfil(nombre:inscripcionCommand.nombrePadre,
                            apellidoPaterno:inscripcionCommand.apellidoPaternoPadre,
                            apellidoMaterno:inscripcionCommand.apellidoMaternoPadre)
    def telefono = new Telefono()
    telefono.numeroTelefonico = inscripcionCommand.telefono.replaceAll( "[^\\d.]", "" )
    perfil.addToTelefonos(telefono)
    def usuario = new Usuario(perfil:perfil,
                              username:inscripcionCommand.email,
                              enabled:true)

    usuario.password = armaPasswordTemporal(perfil.nombre,usuario.username,telefono.numeroTelefonico)

    usuario
  }

  def registrar(Usuario usuario, def institucion){
    def user = Usuario.findByUsername(usuario.username) 
    if(user){
      if(!user.instituciones.find{ it.id == institucion.id }){
        user.addToInstituciones(institucion)
        user.save()
      }
      return user
    }
    
    usuario.addToInstituciones(institucion)
    usuario.perfil = perfilService.registrar(usuario.perfil)
    usuario.save()
    def rol = Rol.findByAuthority("ROLE_PADRE_TUTOR") ?: new Rol(authority:"ROLE_PADRE_TUTOR")
    UsuarioRol.create(usuario, rol, true)
    usuario
    
  }

  private String armaPasswordTemporal(String nombre, String correo, String telefono) throws Exception{
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

