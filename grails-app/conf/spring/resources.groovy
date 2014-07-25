import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

beans = {

  localeResolver(org.springframework.web.servlet.i18n.SessionLocaleResolver) {
    defaultLocale = new Locale("es","MX")
    java.util.Locale.setDefault(defaultLocale)
  }

}
