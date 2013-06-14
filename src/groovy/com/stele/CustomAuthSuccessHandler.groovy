package com.stele

import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils 
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib

public class CustomAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

  String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
    if( SpringSecurityUtils.getPrincipalAuthorities().find{ it == "ROLE_DIRECTOR" } ) {
      return new ApplicationTagLib().createLink([controller: 'resumen'])
    }
    else if( SpringSecurityUtils.getPrincipalAuthorities().find{ it == "ROLE_CONTROL_ESCOLAR" } ) {
      return new ApplicationTagLib().createLink([controller: 'inicio'])
    }
    else if( SpringSecurityUtils.getPrincipalAuthorities().find{ it == "ROLE_PADRE_TUTOR" } ) {
      String url = new ApplicationTagLib().createLink([controller: 'perfil', base:'/'])
      return url.substring(1)
    }

    "/"
  }

}
