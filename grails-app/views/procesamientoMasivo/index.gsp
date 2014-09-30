<html>
  <head>
    <meta name="layout" content="colegio"/>
  </head>
  <body>
   <div class="main-content">
        <div class="page-content">
          <g:if test="${flash.proceso == 'true'}">
            <div class="page-header position-relative">
              <h1>
                Inscripción Archivo + Cobro
                <small>
                  <i class="icon-double-angle-right"></i>
                  Inscripción Archivo de Alumnos y su Padre o Tutor, más a gregar un cobro a los alumnos del archivo
                </small>
              </h1>
            </div>
          </g:if>
          <g:else>
            <div class="page-header position-relative">
              <h1>
                Inscripción Archivo
                <small>
                  <i class="icon-double-angle-right"></i>
                  Inscripción Archivo de Alumnos y su Padre o Tutor
                </small>
              </h1>
            </div>
          </g:else>
          <div class="row-fluid">
            <div class="span12">
              <!--PAGE CONTENT BEGINS-->
              <div class="widget-box">
                <div class="widget-header widget-header-blue widget-header-flat">
              </div>
                <div class="widget-body">
                  <div class="widget-main">
                    <div class="row-fluid">
                      <g:if test="${flash.proceso == 'true'}">
                        <g:render template="menuArchivoCobroMasivo" />
                      </g:if>
                      <g:else>
                        <g:render template="menuArchivoMasivo" />
                      </g:else>
                      <hr />
                        <div class="step-content row-fluid  position-relative" id="step-container">
                          <div class="step-pane active" id="step4">
                            <h3 class="header  green ">Alumnos Inscritos</h3>
                            <div class="row-fluid">
                              <div class="span12 infobox-container">
                                <div class="infobox infobox-blue  ">
                                  <div class="infobox-icon">
                                    <i class="icon-file-text blue icon-2x"></i>
                                  </div>
                                  <div class="infobox-data">
                                    <span class="infobox-data-number">${totalRegistros ?: 0}</span>
                                    <div class="infobox-content">Total Registros Archivo</div>
                                  </div>
                                </div>
                                <div class="infobox infobox-green  ">
                                  <div class="infobox-icon">
                                    <i class="icon-smile  icon-large green"></i>
                                  </div>
                                  <div class="infobox-data">
                                    <span class="infobox-data-number">${dependientesProcesados ?: 0}</span>
                                    <div class="infobox-content">Registros Correctos</div>
                                  </div>
                                </div>
                                <div class="infobox infobox-red  ">
                                  <div class="infobox-icon ">
                                    <i class="icon-frown red"></i>
                                  </div>
                                  <div class="infobox-data">
                                    <span class="infobox-data-number">${erroneos ?: 0}</span>
                                    <div class="infobox-content">Registros Erróneos</div>
                                  </div>
                                </div>
                              </div>
                            </div>
                            <!--Inica DEtalleRA-->
                            <h3 class="header smaller lighter purple">Detalle alumnos</h3>
                            <div class="row-fluid">
                              <g:render template="listaDependientesProcesados" model="[historial:historiales]" />
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
      </div><!--/.main-content-->
    </div><!--/.main-container-->

      <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-small btn-inverse">
      <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
   
  </body>
</html>
