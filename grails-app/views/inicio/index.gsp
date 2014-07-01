<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:script>
      function check() {        
        $('#imagenCarga').removeClass("hidden");
      }
      $(document).ready(function(){
        $("#siguiente").click(function(){
          $("#cargaArchivo").submit();
        });
      });
    </r:script>
  </head>
  <body>
   <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
          <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
          </script>

          <ul class="breadcrumb">
            <li>
              <i class="icon-home home-icon"></i>
              <a href="#">Colegio</a>

              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>

            <li>
              <a href="#">Inscripcion</a>
              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>
            </li>
            <li class="active">Archivo</li>
          </ul><!--.breadcrumb-->


        </div>

        <div class="page-content">
          <g:if test="${flash.inscripcionCobro == 'true'}">
            <div class="page-header position-relative">
              <h1>
                Inscripcion Archivo + Cobro
                <small>
                  <i class="icon-double-angle-right"></i>
                  Inscripcion Archivo de Alumnos y su Padre o Tutor, mas a gregar un cobro a los alumnos del archivo
                </small>
              </h1>
            </div>
          </g:if>
          <g:else>
            <div class="page-header position-relative">
              <h1>
                Inscripcion Archivo
                <small>
                  <i class="icon-double-angle-right"></i>
                  Inscripcion Archivo de Alumnos y su Padre o Tutor
                </small>
              </h1>
            </div>
          </g:else>
          <g:if test="${flash.error}">
            <div id="message"class="alert alert-error">
              ${flash.error}
            </div>
          </g:if>

          <div class="row-fluid">
            <g:form name="layout" id="cargaArchivo" controller="inicio" action="preview" onsubmit="return check()">
            <div class="span12">
              <!--PAGE CONTENT BEGINS-->

              <div class="widget-box">
                <div class="widget-header widget-header-blue widget-header-flat">
                </div>

                <div class="widget-body">
                  <div class="widget-main">
                    <div class="row-fluid">
                      <g:if test="${flash.inscripcionCobro == 'true'}">
                        <g:render template="menuArchivoCobro" />
                      </g:if>
                      <g:else>
                        <g:render template="menuArchivo" />
                      </g:else>

                      <hr />
                        <div align="center" id="imagenCarga" class="hidden">
                          <img class="prev" aling="center"  width="60" height="60" src="${resource(dir: 'images', file: 'loading.gif')}" alt="Previous" /> CARGANDO
                        </div>
                        <div class="step-content row-fluid  position-relative" id="step-container">
                          <div class="step-pane active" id="step1">
                            <div class="row-fluid">
                              <div class="span12">
                                <div class="widget-box">
                                  <div class="widget-header blue">
                                    <h4>Selecciona la institución:</h3> <p>
                                    <div align="center">
                                      <g:select name="institucionId" from="${instituciones}" optionKey="id" optionValue="nombre" value="${institucionId}" class="input-xxlarge"/>
                                    </div>
                                  </div>
                                </div>
                                <div class="widget-box">
                                  <div class="widget-header blue">
                                    <h4>Plantilla</h4>
                                  </div>
                                  <div class="widget-body">
                                    <div class="widget-main">
                                      <div class="center">
                                        <span class="control-group warning">
                                          <g:if test="${flash.inscripcionCobro == 'true'}">
                                            <div class="alert alert-warning">
                                            <strong>NOTA!</strong>
                                            El sistema genera un cobro generico por todos los alumnos en el archivo<br> por lo que si los pagos no son iguales <strong> genere un archivo de alumnos por tipo de cobro</strong>
                                            <br>
                                          </div>
                                          </g:if>
                                           <a class="btn btn-app btn-info btn-mini blue" href="${resource(dir: 'template', file: 'plantilla.xls')}">
                                            <i class="icon-file-text bigger-160"></i>
                                            Plantilla
                                          </a>
                                          <span class=" help-inline ">
                                            Necesita descargar la plantilla y llenarla correctamente, todos los campos son obligatorios
                                          </span>
                                        </span>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                                <div class="widget-box">
                                  <div class="widget-header blue">
                                    <h4><strong>Importar plantilla</strong></h4>
                                  </div>
                                  <div class="widget-body">
                                    <div class="widget-main">                                      
                                      <div id="carga-archivo" class="dropzone dz-default dz-message">
                                        
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>  
                          </div>
                          <div class="step-pane" id="step2" align="center">
                            <img style="-webkit-user-select: none" src="http://www.jose-aguilar.com/blog/wp-content/uploads/2012/03/loading.gif" align="middle">
                          </div>
                          
                        </div>
                      <hr />
                    </div>
                  </div><!--/widget-main-->
                </div><!--/widget-body-->
              </div>



              <!--PAGE CONTENT ENDS-->
            </div><!--/.span-->
            </g:form>
          </div><!--/.row-fluid-->
        </div><!--/.page-content-->

        <div class="ace-settings-container" id="ace-settings-container">


          <div class="ace-settings-box" id="ace-settings-box">
         

            <div>
              <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
              <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
            </div>

            <div>
              <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
              <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
            </div>

            <div>
              <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
              <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
            </div>

            <div>
              <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
              <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
            </div>
          </div>
        </div><!--/#ace-settings-container-->
      </div><!--/.main-content-->
    </div><!--/.main-container-->

      <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-small btn-inverse">
      <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
   
  </body>
</html>