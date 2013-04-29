import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

beans = {

  authenticationSuccessHandler(com.stele.CustomAuthSuccessHandler) {
    def conf = SpringSecurityUtils.securityConfig
      requestCache = ref('requestCache')
      defaultTargetUrl = conf.successHandler.defaultTargetUrl
      alwaysUseDefaultTargetUrl = conf.successHandler.alwaysUseDefault
      targetUrlParameter = conf.successHandler.targetUrlParameter
      useReferer = conf.successHandler.useReferer
      redirectStrategy = ref('redirectStrategy')
  }
}
