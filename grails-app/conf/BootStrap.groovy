import com.stele.Institucion
import grails.util.Environment
import net.bull.javamelody.JdbcWrapper
import grails.converters.JSON

import com.stele.seguridad.*
import com.stele.*
import com.stele.marshallers.*
import com.makingdevs.*
import com.payable.*

class BootStrap {

  def dataSource
  def searchableService

  def init = { servletContext ->
    wrapperMelodyDataSource()
    creaInstituciones()
    creaUsuario()
    JSON.createNamedConfig('stele') {
      it.registerObjectMarshaller(new EsquemaDePagoMarshaller())
      it.registerObjectMarshaller(new ConceptoMarshaller())
      it.registerObjectMarshaller(new DescuentoMarshaller())
      it.registerObjectMarshaller(new RecargosMarshaller())
      it.registerObjectMarshaller(new PerfilMarshaller())
    }

    switch(Environment.current){
      case Environment.DEVELOPMENT :
        log.debug "do your shit for DEVELOPMENT here"
        searchableService.index()
      break
      case Environment.TEST :
        log.debug "do your shit for TEST here"
      break
      case Environment.PRODUCTION :
        searchableService.index()
      break
    }

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
    def rol = Rol.findByAuthority("ROLE_PADRE_TUTOR")
    if(!rol)
      rol = new Rol(authority:"ROLE_PADRE_TUTOR").save(flush:true)
    def rolDirector = Rol.findByAuthority("ROLE_DIRECTOR")
    if(!rolDirector)
      rolDirector = new Rol(authority:"ROLE_DIRECTOR").save(flush:true)
    def usuarioRol = UsuarioRol.findByUsuarioAndRol(usuario,rol)
    def user = Usuario.read(usuario.id)
    if(!usuarioRol)
      usuarioRol = UsuarioRol.create(user, rol, true)

    Perfil perfilDependiente = new Perfil(nombre: "Nelson Jr.",
                                          apellidoPaterno: "Muntz")
    perfilDependiente.save(flush:true)
    Dependiente dependiente = new Dependiente(matricula : "2013A9023",
                                              perfil : perfilDependiente,
                                              camada : "0000000001")
    Pago pago = new Pago(conceptoDePago : "Pago test 1",
                         cantidadDePago : 123456789,
                         fechaDePago : new Date(),
                         fechaDeVencimiento : new Date(),
                         tipoDePago : TipoDePago.TRANSFERENCIA_BANCARIA,
                         estaDePago : EstatusDePago.CREADO,
                         transactionId : UUID.randomUUID().toString().replaceAll('-', '').substring(0,20)
                         )
    pago.save(flush:true)
    dependiente.addToPagos( pago )
    usuario.addToDependientes( dependiente )
    usuario.save(flush:true)
  }

}
