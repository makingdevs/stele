

import grails.converters.JSON
import com.makingdevs.Perfil
import org.codehaus.groovy.grails.web.converters.marshaller.ObjectMarshaller

public class PerfilMarshaller implements ObjectMarshaller<JSON> {

  public boolean supports(Object object) {
    return object instanceof Perfil;
  }

  public void marshalObject(Object object,JSON converter) {
    def perfil = object as Perfil
    def perfilValues = [nombre:perfil.nombre, paterno:perfil.apellidoPaterno, materno:perfil.apellidoMaterno]
    converter.convertAnother(perfilValues)
  }

}
