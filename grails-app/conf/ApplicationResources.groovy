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
    resource url:'js/registro/index.js'
  }
  pagosParaCamada {
    resource url:'js/esquemaDePago/paraCamada.js'
  }
  
  generarPagos {
    dependsOn 'validation'
    resource url: 'js/esquemaDePago/generar.js'
  }
}
