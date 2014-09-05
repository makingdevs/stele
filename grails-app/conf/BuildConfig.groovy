grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
// Module plugins
//grails.plugin.location.profile='../profile'
//grails.plugin.location.payable='../payable'
grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
  // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
  //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

  // configure settings for the test-app JVM, uses the daemon by default
  test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
  // configure settings for the run-app JVM
  run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
  // configure settings for the run-war JVM
  war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
  // configure settings for the Console UI JVM
  console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy

grails.project.dependency.resolution = {
  // inherit Grails' default dependencies
  inherits("global") {
      // specify dependency exclusions here; for example, uncomment this to disable ehcache:
      // excludes 'ehcache'
  }
  log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
  checksums true // Whether to verify checksums on resolve
  legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

  repositories {
      inherits true // Whether to inherit repository definitions from plugins

      grailsPlugins()
      grailsHome()
      mavenLocal()
      grailsCentral()
      mavenCentral()
      mavenRepo "http://makingdevs.com:8081/nexus/content/repositories/thirdparty"
      mavenRepo "http://repo.grails.org/grails/core"
  }

  dependencies {
      runtime 'mysql:mysql-connector-java:5.1.20'
      compile 'net.sourceforge.jexcelapi:jxl:2.6.12'
  }

  plugins {
    compile ":quartz:1.0.1"
    runtime ':twitter-bootstrap:2.3.0'
    compile ":font-awesome-resources:3.2.1"
    compile ":spring-security-core:1.2.7.3"
    compile ":grails-melody:1.50.0"
    compile ":searchable:0.6.7"
    compile ":mail:1.0.5", {
        excludes 'spring-test'
    }  
    compile ':recaptcha:0.6.7'
    test ":code-coverage:1.2.7"


    // Uncomment these (or add new ones) to enable additional resources capabilities
    //runtime ":zipped-resources:1.0"
    //runtime ":cached-resources:1.0"
    //runtime ":yui-minify-resources:0.1.4"

    // plugins for the build system only
    build ":tomcat:7.0.52.1"

    // plugins for the compile step
    compile ":scaffolding:2.0.3"
    compile ':cache:1.1.2'
    compile ":jasper:1.8.0"

    // plugins needed at runtime but not for compilation
    runtime ":hibernate:3.6.10.13" // or ":hibernate4:4.3.5.1"
    runtime ":database-migration:1.4.0"
    runtime ":jquery:1.11.0.2"
    runtime ":resources:1.2.7"

    compile 'com.makingdevs:profile:0.1.7'
    compile('com.payable:payable:0.2.33'){
      exclude "profile"
    }
  }
}
