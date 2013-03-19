import grails.util.Environment
import net.bull.javamelody.JdbcWrapper

class BootStrap {

  def dataSource

  def init = { servletContext ->
    wrapperMelodyDataSource()
  }
  def destroy = {
  }

  private def wrapperMelodyDataSource(){
    dataSource.targetDataSource = JdbcWrapper.SINGLETON.createDataSourceProxy(dataSource.targetDataSource)
  }

}
