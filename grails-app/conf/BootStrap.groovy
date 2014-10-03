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
    crearRoles()
    //creaInstituciones()
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

  def crearRoles(){
    def rolTutor = Rol.findByAuthority("ROLE_PADRE_TUTOR") ?: new Rol(authority:"ROLE_PADRE_TUTOR").save(flush:true)
    def rolDirector = Rol.findByAuthority("ROLE_DIRECTOR") ?: new Rol(authority:"ROLE_DIRECTOR").save(flush:true)
  }

}
