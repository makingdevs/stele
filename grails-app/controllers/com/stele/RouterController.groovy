package com.stele

class RouterController {

  def springSecurityService

  def index() {
    if(springSecurityService.isLoggedIn()){
      def user = springSecurityService.currentUser
      def authorities = user.authorities
      switch(authorities[0]){
        case "ROLE_PADRE_TUTOR":
        redirect controller:"home"
        break
        case "ROLE_DIRECTOR":
        redirect controller:"inicio"
        break
        default:
        redirect controller:"home"
        break
      }
      return
    }
    redirect controller:'login'
  }
}
