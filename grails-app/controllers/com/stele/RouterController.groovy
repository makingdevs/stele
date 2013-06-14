package com.stele

class RouterController {

  def springSecurityService

  def index() {
    if(springSecurityService.isLoggedIn()){
      def user = springSecurityService.currentUser
      def authorities = user.authorities
      switch(authorities.first().authority){
        case "ROLE_PADRE_TUTOR":
        redirect uri:"/"
        break
        case "ROLE_DIRECTOR":
        redirect controller:"inicio", action:"index"
        break
        default:
        redirect uri:"/"
        break
      }
      return
    }
    redirect controller:'login'
  }
}
