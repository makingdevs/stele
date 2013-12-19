package com.stele

class RouterController {

  def springSecurityService

  def index() {
    if(springSecurityService.isLoggedIn()){
      def user = springSecurityService.currentUser
      def authorities = user.authorities
      log.debug authorities

      switch(authorities?.first()?.authority){
        case "ROLE_PADRE_TUTOR":
        redirect uri:"/estadoDeCuenta/show"
        break
        case "ROLE_DIRECTOR":
        redirect controller:"inicio", action:"index"
        break
        default:
        redirect uri:"/perfil"
        break
      }
      return
    }
    redirect controller:'login'
  }
}
