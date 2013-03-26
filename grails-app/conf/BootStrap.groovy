import com.stele.Institucion
import grails.util.Environment
import net.bull.javamelody.JdbcWrapper

class BootStrap {

  def dataSource

  def init = { servletContext ->
    wrapperMelodyDataSource()
    creaInstituciones()
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

}
