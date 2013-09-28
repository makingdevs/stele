modules = {
  application {
    resource url:'js/application.js'
  }

  telefono {
    resource url:'js/telefono/index.js'
  }

  auth {
    dependsOn 'assets'
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

  inscripcion {
    resource url: 'js/inscripcion/validar.js'
  }

  autocomplete {
    resource url: 'js/esquemaDePago/autocomplete.js'
  }

  assets {
    resource url: 'css/assets/style.css'
    resource url: 'css/assets/headers/header1.css'
    resource url: 'css/assets/style_responsive.css'
    resource url: 'css/assets/themes/default.css'
    resource url: 'js/assets/jquery-1.8.2.min.js'
    resource url: 'js/assets/modernizr.custom.js'
    resource url: 'js/assets/back-to-top.js'
    resource url: 'js/assets/app.js'    
  }

  assetsMain {
    dependsOn 'assets'
    
    resource url: 'css/assets/flexslider.css'
    resource url: 'js/assets/bxslider/jquery.bxslider.css'
    resource url: 'css/assets/headers/header2.css'
    resource url: 'js/assets/font-awesome/css/font-awesome.css'
    resource url: 'css/assets/horizontal-parallax.css'
    resource url: 'js/assets/bxslider/jquery.bxslider.js'
    resource url: 'js/assets/jquery.flexslider-min.js'
    resource url: 'js/assets/sequence.jquery-min.js'
    resource url: 'js/assets/horizontal-parallax.js'

  }

  assetsDashBoard {
    resource url: 'css/assets/font-awesome.min.css'
    resource url: 'css/assets/ace-fonts.css'
    resource url: 'css/assets/ace.min.css'
    resource url: 'css/assets/ace-responsive.min.css'
    resource url: 'css/assets/ace-skins.min.css'
    resource url: 'js/assets/ace-extra.min.js'
    resource url: 'js/assets/ace-elements.min.js'
    resource url: 'js/assets/ace.min.js'
  }

  inscripcionArchivo {
    resource url: 'js/assets/fuelux/fuelux.wizard.min.js'
    resource url: 'js/assets/bootbox.min.js'
    resource url: 'js/assets/jquery.nestable.min.js'
    resource url: 'js/assets/jquery.dataTables.min.js'
    resource url: 'js/assets/jquery.dataTables.bootstrap.js'
    resource url: 'js/assets/jquery-ui-1.10.3.custom.min.js'
    resource url: 'js/assets/chosen.jquery.min.js'
    resource url: 'js/assets/jquery.autosize-min.js'
    resource url: 'js/assets/jquery.inputlimiter.1.3.1.min.js'
    resource url: 'js/assets/jquery.maskedinput.min.js'
  }
}
