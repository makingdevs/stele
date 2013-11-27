modules = {
  application {
    resource url:'js/application.js'
  }

  telefono {
    resource url:'js/telefono/index.js'
  }

  uploadImg{
    resource url:'js/perfil/uploadImg.js'
  }

  auth {
    dependsOn 'assets'
    resource url:'css/login/auth.css'
  }

  upload {
    resource url:'js/upload/css/basic.css'
    resource url:'js/upload/css/dropzone.css'
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

  bootstrapDatePicker {
    resource url: 'datepicker/css/datepicker.css'
    resource url: 'datepicker/js/bootstrap-datepicker.js'
  }

  customBootsrapCss{
    resource url:'assets/css/bootstrap.min.css'
    resource url:'assets/css/bootstrap-responsive.min.css'
  }
  customFontAwesomeCss{
    resource url:'assets/css/font-awesome.min.css'
  }
  dropzoneCss {
    resource url:'assets/css/dropzone.css'
  }
  customAceCss{
    resource url:'assets/css/ace-fonts.css'
    resource url:'assets/css/ace.min.css'
    resource url:'assets/css/ace-responsive.min.css'
    resource url:'assets/css/ace-skins.min.css'
  }
  colegioCss {
    dependsOn 'customBootsrapCss'
    dependsOn 'customFontAwesomeCss'
    dependsOn 'dropzoneCss'
    dependsOn 'customAceCss'
  }
  jquery2{
    resource url:'assets/js/jquery-2.0.3.min.js', wrapper: { s ->
      def url = s.find(/src.+.js|.css/) - "src=\""
      """
        <!--[if !IE]>-->
        <script type="text/javascript">
          window.jQuery || document.write("<script src='$url'>"+"<"+"/script>");
        </script>
        <!--<![endif]-->
      """
    }
  }
  jquery1{
    resource url:'assets/js/jquery-1.10.2.min.js', wrapper: { s ->
      def url = s.find(/src.+.js|.css/) - "src=\""
      """
        <!--[if IE]>
        <script type="text/javascript">
         window.jQuery || document.write("<script src='url'>"+"<"+"/script>");
        </script>
        <![endif]-->
      """
    }
  }
  colegioJs {
    resource url:'assets/js/ace-extra.min.js'
    resource url:'assets/js/bootstrap.min.js'
    resource url:'assets/js/ace-elements.min.js'
    resource url:'assets/js/uncompressed/ace.js'
    
    resource url:'assets/js/fuelux/fuelux.wizard.min.js'
    resource url:'assets/js/bootbox.min.js'
    resource url:'assets/js/dropzone.min.js'
    resource url:'assets/js/jquery.nestable.min.js'
    resource url:'assets/js/jquery.dataTables.min.js'
    resource url:'assets/js/jquery.dataTables.bootstrap.js'
    resource url:'assets/js/jquery-ui-1.10.3.custom.min.js'
    resource url:'assets/js/chosen.jquery.min.js'
    resource url:'assets/js/jquery.autosize-min.js'
    resource url:'assets/js/jquery.inputlimiter.1.3.1.min.js'
    resource url:'assets/js/jquery.maskedinput.min.js'
  }
  colegio {
    dependsOn 'colegioCss'
    dependsOn 'jquery2'
    dependsOn 'jquery1'
    dependsOn 'colegioJs'
  }
}
