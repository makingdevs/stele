import grails.util.Environment
import org.apache.log4j.DailyRollingFileAppender
import grails.util.Environment

def configLocations = []
configLocations << "file:${userHome}/.grails/${appName}-${Environment.current}-config.groovy"
grails.config.locations = configLocations

log.debug configLocations

grails.project.groupId = appName 
grails.mime.file.extensions = true 
grails.mime.use.accept.header = false
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000


// DB Migration configuration 
grails.plugin.databasemigration.updateOnStart = true
grails.plugin.databasemigration.updateOnStartFileNames = ['changelog.groovy']

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*', '/new/*', '/assets/*']
grails.resources.adhoc.includes = ['/images/**', '/css/**', '/js/**', '/plugins/**', '/new/**', '/assets/**']

// The default codec used to encode data with ${}
grails.views.default.codec = "html" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

def logDirectory = "target/"
environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        target = "logs/"
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

searchable{
  /**
   * Should the database be indexed at startup (using Compass:GPS)?
   *
   * Possible values: true|false|"fork"
   *
   * The value may be a boolean true|false or a string "fork", which means true,
   * and fork a thread for it
   *
   * If you use BootStrap.groovy to insert your data then you should use "true",
   * which means do a non-forking, otherwise "fork" is recommended
   */
  bulkIndexOnStartup = false
}



coverage {
  xml = true
}

// log4j configuration
log4j = {

  appenders {
    console name: 'stdout', layout: pattern(conversionPattern: '%d{ISO8601}\t%p\t%c:%L\t%m%n'), threshold: org.apache.log4j.Level.ERROR
    appender new DailyRollingFileAppender(name: 'file', file: logDirectory + 'stele.log',
        datePattern: '\'_\'yyyy-MM-dd', layout: pattern(conversionPattern: '%d{ISO8601}\t%p\t%c:%L\t%m%n'))
  }

  root {
    debug 'stdout', 'file'
    additivity = true
  }

  debug 'grails.app.controllers.com.stele',
      'grails.app.taglib.com.stele',
      'grails.app.services.com.stele',
      'grails.app.domain.com.stele',
      'grails.app.jobs.com.stele'
      'grails.app.conf'

  error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
      'org.codehaus.groovy.grails.web.pages', //  GSP
      'org.codehaus.groovy.grails.web.sitemesh', //  layouts
      'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
      'org.codehaus.groovy.grails.web.mapping', // URL mapping
      'org.codehaus.groovy.grails.commons', // core / classloading
      'org.codehaus.groovy.grails.plugins', // plugins
      'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
      'org.springframework',
      'org.hibernate',
      'net.sf.ehcache.hibernate',
      'org.apache',
      'org.codehaus',
      'org.grails.plugin.resource',
      'grails.plugin.cache',
      'grails.app.resourceMappers',
      'grails.plugins.twitterbootstrap',
      'grails.app.taglib',
      'grails.plugin.webxml',
      'grails.util',
      'grails.spring',
      'liquibase',
      'grails.plugin.databasemigration',
      'CacheHeadersGrailsPlugin',
      'org.quartz',
      'org.jets3t',
      'httpclient',
      'grails.app.jobs.org.grails',
      'grails.plugins.quartz',
      'QuartzGrailsPlugin'

  warn 'grails.plugin.jms',
      'net.bull.javamelody',
      'net.sf.ehcache'

  environments {
    production {
      // Override previous setting
      error "grails",
          "org",
          "net",
          "com",
          "groovyx",
          "net.bull.javamelody",
          "httpclient",
          "liquibase"
    }
  }
}

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'com.stele.seguridad.Usuario'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'com.stele.seguridad.UsuarioRol'
grails.plugins.springsecurity.authority.className = 'com.stele.seguridad.Rol'
grails.plugins.springsecurity.requestMap.className = 'com.stele.seguridad.Requestmap'
grails.plugins.springsecurity.securityConfigType = 'Requestmap'
grails.plugins.springsecurity.successHandler.defaultTargetUrl = '/router'

// Uncomment and edit the following lines to start using Grails encoding & escaping improvements

/* remove this line 
// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside null
                scriptlet = 'none' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
remove this line */
