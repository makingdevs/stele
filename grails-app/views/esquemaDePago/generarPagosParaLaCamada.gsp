<html>
  <head>
    <meta name="layout" content="colegio"/>
    <title></title>
  </head>
  <body>
   <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
          <ul class="breadcrumb">
            <li>
              <i class="icon-home home-icon"></i>
              <a href="#">Colegio</a>
              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>
            <li>
              <a href="#">Inscripción</a>
              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>
            </li>
            <li class="active">Archivo</li>
          </ul><!--.breadcrumb-->
        </div>
        <div class="page-content">
          <div class="page-header position-relative">
            <h1>
              Inscripcion Archivo + Cobro
              <small>
                <i class="icon-double-angle-right"></i>
                Inscripcion Archivo de Alumnos y su Padre o Tutor, mas a gregar un cobro a los alumnos del archivo
              </small>
            </h1>
          </div>
          <div class="row-fluid">
            <div class="span12">
              <div class="widget-box">
                <div class="widget-header widget-header-blue widget-header-flat">
                </div>
                <div class="widget-body">
                  <div class="widget-main">
                    <div class="row-fluid">
                      <g:render template="menuArchivoPagoLista" />
                      <hr />
                        <div class="step-content row-fluid  position-relative" id="step-container">
                          <div class="step-pane active" id="step6">
                            <div class="row-fluid">
                              <div class="span12">
                                <form class="form-horizontal" id="sample-form2">
                                  <div class="span12 widget-container-span">
                                    <div class="widget-box">
                                      <g:if test="${pagos}">
                                        <g:if test="${flash.success}">
                                          <div id="message"class="alert alert-success">
                                            ${flash.success}
                                          </div>
                                        </g:if>
                                        <div class="widget-header ">
                                          <h5 class="bigger ">
                                            Cobros Generados
                                          </h5>
                                        </div>
                                        <div class="row-fluid">
                                          <div class="span12">
                                            <g:render template='list' model="[pagos : pagos]" />
                                          </div>
                                        </div>
                                      </g:if>
                                    </div>
                                  </div><!--/span-->
                                </form>
                              </div>
                            </div>
                          </div>
                        </div>
                      <hr />
                    </div>
                  </div><!--/widget-main-->
                </div><!--/widget-body-->
              </div><!--/widget-box-->
            </div><!--/.span-->
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


      <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-small btn-inverse">
      <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
   
  </body>
</html>
