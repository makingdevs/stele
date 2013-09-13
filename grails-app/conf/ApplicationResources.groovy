modules = {
  application {
    resource url:'js/application.js'
  }

  telefono {
    resource url:'js/telefono/index.js'
  }

  auth {
    resource url:'css/login/auth.css'
  }

  upload {
    resource url:'css/upload/upload.css'
    resource url:'js/upload/css/basic.css'
    resource url:'js/upload/css/dropzone.css'
    resource url:'js/upload/dropzone.min.js'
  }
  
  validation {
    resource url:'js/common/jquery.validate.min.js'
  }

  registrar {
    dependsOn 'validation'
    dependsOn 'assets'
    resource url:'js/registro/index.js'
  }

  pagosParaCamada {
    resource url:'js/esquemaDePago/paraCamada.js'
  }
  
  generarPagos {
    dependsOn 'validation'
    resource url: 'js/esquemaDePago/generar.js'
  }

  autocomplete {
    resource url: 'js/esquemaDePago/autocomplete.js'
  }

  assets {
    resource url: 'css/assets/style.css'
    resource url: 'css/assets/headers/header1.css'
    resource url: 'css/assets/headers/header2.css'
    resource url: 'css/assets/style_responsive.css'
    resource url: 'css/assets/themes/default.css'
    resource url: 'css/assets/flexslider.css'
    resource url: 'css/assets/jquery.bxslider.css'
    resource url: 'css/assets/font-awesome.css'
    resource url: 'css/assets/horizontal-parallax.css'
    resource url: 'js/assets/jquery-1.8.2.min.js'
    resource url: 'js/assets/modernizr.custom.js'
    resource url: 'js/assets/back-to-top.js'
    resource url: 'js/assets/app.js'
    resource url: 'js/assets/jquery.flexslider-min.js'
    resource url: 'js/assets/sequence.jquery-min.js'
    resource url: 'js/assets/horizontal-parallax.js'
  }

}
