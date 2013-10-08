package com.stele

class RouterController {

  def springSecurityService

  def index() {
    if(springSecurityService.isLoggedIn()){
      def user = springSecurityService.currentUser
      println user
      def authorities = user.authorities
      println authorities
      switch(authorities.first().authority){
        case "ROLE_PADRE_TUTOR":
        redirect uri:"/perfil"
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
