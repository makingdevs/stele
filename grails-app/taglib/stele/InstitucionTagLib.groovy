package stele

class InstitucionTagLib {

  def springSecurityService

  def nombreDeLaInstitucion = {body->
    def institucion = springSecurityService.currentUser.instituciones?.first()
    out << institucion.nombre.capitalize()
  }

}
