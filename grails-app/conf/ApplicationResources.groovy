modules = {
  application {
    resource url:'js/application.js'
  }

  handlebars {
    resource url:'js/handlebars/handlebars-1.0.0.rc.3.js'
  }

  backbone {
    dependsOn 'underscore'
    resource url:'js/backbone/backbone.js'
  }

  underscore {
    resource url:'js/underscore/underscore.js'
  }

  telefono {
    resource url:'js/telefono/index.js'
  }

}
