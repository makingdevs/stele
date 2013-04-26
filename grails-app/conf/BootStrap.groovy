import com.stele.Institucion
import grails.util.Environment
import net.bull.javamelody.JdbcWrapper

import com.stele.seguridad.*
import com.stele.*

class BootStrap {

  def dataSource

  def init = { servletContext ->
    wrapperMelodyDataSource()
    creaInstituciones()
    creaUsuario()
  }
  def destroy = {
  }

  private def wrapperMelodyDataSource(){
    dataSource.targetDataSource = JdbcWrapper.SINGLETON.createDataSourceProxy(dataSource.targetDataSource)
  }
  
  private def creaInstituciones(){
    new Institucion(nombre:"Instituto Juana de Arco").save(flush:true)
    new Institucion(nombre:"Kinder Primeros pasitos").save(flush:true)
    new Institucion(nombre:"Escuela Secundaria Coyoalhuiqui").save(flush:true)
    new Institucion(nombre:"Instituto Andersen").save(flush:true)
    new Institucion(nombre:"Colegio Americano").save(flush:true)
    new Institucion(nombre:"Colegio Alemán").save(flush:true)
  }

  private void creaUsuario() {
    def usuario = Usuario.findByUsername("nelson@muntz.com")
    if(!usuario) {
      Perfil perfil = new Perfil( nombre: "Nelson",
                                  apellidoPaterno: "Muntz")
      perfil.save(flush:true)
      usuario = new Usuario( username:"nelson@muntz.com",
                   password:"haha",
                   enabled:true,
                   accountExpired:false,
                   accountLocked:false,
                   passwordExpired:false,
                   perfil: perfil)

      usuario.save(flush:true)
    }
    def rol = Rol.findByAuthority("ROLE_USER")
    if(!rol)
      rol = new Rol(authority:"ROLE_USER").save(flush:true)
    def usuarioRol = UsuarioRol.findByUsuarioAndRol(usuario,rol)
    def user = Usuario.read(usuario.id)
    if(!usuarioRol)
      usuarioRol = UsuarioRol.create(user, rol, true)
  }

}
