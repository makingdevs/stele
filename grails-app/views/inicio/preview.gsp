<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:script>
      $(document).ready(function(){
        $("#procesar").click(function(){
          $('#imagenCarga').removeClass("hidden");
        });
      });
      $(document).ready(function(){
        $("#procesarCobro").click(function(){
          $('#imagenCarga').removeClass("hidden");
        });
      });
    </r:script>
  </head>
  <body>
   <div class="main-content">

        <div class="page-content">
          <g:if test="${flash.inscripcionCobro == 'true'}">
            <div class="page-header position-relative">
              <h1>
                Inscripcion Archivo + Cobro
                <small>
                  <i class="icon-double-angle-right"></i>
                  Inscripción Archivo de Alumnos y su Padre o Tutor, mas agregar un cobro a los alumnos del archivo
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
          <div class="row-fluid">
<!--aqui el update-->
            <div class="span12">
              <!--PAGE CONTENT BEGINS-->

              <div class="widget-box">
                <div class="widget-header widget-header-blue widget-header-flat">
              </div>

                <div class="widget-body">
                  <div class="widget-main">
                    <div class="row-fluid">
                      <g:if test="${flash.inscripcionCobro == 'true'}">
                        <g:render template="preview/menuArchivoCobroPreview" />
                      </g:if>
                      <g:else>
                        <g:render template="preview/menuArchivoPreview" />
                      </g:else>

                      <hr />
                        <div align="center" id="imagenCarga" class="hidden">
                          <img class="prev" aling="center"  width="60" height="60" src="${resource(dir: 'images', file: 'loading.gif')}" alt="Previous" /> CARGANDO
                        </div>
                        <div class="step-content row-fluid  position-relative" id="step-container">
                          <div class="step-pane active" id="step2" >
                            <div class="row-fluid">
                              <g:each in="${estructuraInstitucional}" var="distribucionDeCicloEscolar">
                               <g:render template="datosDeLosNiveles" model="[
                               distribucionDeCicloEscolar:distribucionDeCicloEscolar,
                               alumnosPorNivel:alumnosPorNivel[distribucionDeCicloEscolar.key],
                               alumnosPorGrado:alumnosPorGrado[distribucionDeCicloEscolar.key],
                               alumnosPorTurno:alumnosPorTurno[distribucionDeCicloEscolar.key]
                               ]" />
                              </g:each>
                            </div><!--PAGE EDN CIFRA-->

                            <!--Inica DEtalleRA-->
                            <h3 class="header smaller lighter purple">Detalle de alumnos</h3>
                            <div class="row-fluid">
                              <g:render template="datosTabulares" model="[listaDeMapaDeDominios:listaDeMapaDeDominios]" />
                            </div>
                          </div> 
                          
                        </div>
                      <hr />
                    </div>
                  </div><!--/widget-main-->
                </div><!--/widget-body-->
              </div>



              <!--PAGE CONTENT ENDS-->
            </div><!--/.span-->
            <!-- aqui cierra --> 
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
