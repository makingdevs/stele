<html>
  <head>
    <meta name="layout" content="colegio"/>
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
            <li class="active">Conciliacion</li>
          </ul><!--.breadcrumb-->
        </div>

        <div class="page-content">
          <div class="page-header position-relative">
            <h1>
              Conciliacion 
              <small>
                <i class="icon-double-angle-right"></i>
                Pagos <i class="icon-double-angle-right"></i> Pendientes, Rechazados, Por Conciliar y Vencidos
              </small>
            </h1>
          </div><!--/.page-header-->
          <div class="row-fluid">
            <div class="span12">
              <!--PAGE CONTENT BEGINS-->
                  <div class="tabbable">
                    <ul class="nav nav-tabs" id="myTab">
                      <li class="active">
                        <a data-toggle="tab" href="#pendientes">
                          Pendientes
                        </a>
                      </li>

                      <li>
                        <a data-toggle="tab" href="#xconciliar">
                          Por Conciliar
                          <span class="badge badge-warning"></span>
                        </a>
                      </li>

                      <li>
                        <a data-toggle="tab" href="#conciliados">
                          Conciliados                         
                        </a>
                      </li>
                      <li>
                        <a data-toggle="tab" href="#rechazados">
                          Rechazados
                          <span class="badge badge-important"></span>
                        </a>
                      </li>
                      <li>
                        <a data-toggle="tab" href="#vencidos">
                          Vencidos
                          <span class="badge badge-pink"></span>
                        </a>
                      </li>
                    </ul>
                    <div class="tab-content">
                      <div id="pendientes" class="tab-pane in active">
                        <g:render template="estatusDePago/pagosCreados" model="[pagos:pagosInstitucion]"/>
                      </div>

                      <div id="xconciliar" class="tab-pane">
                        <g:render template="estatusDePago/pagosProcesados" model="[pagos:pagosInstitucion]"/>
                      </div>

                      <div id="conciliados" class="tab-pane ">
                        <!--g:render template="estatusDePago/pagosRealizados" model="[pagos:pagosInstitucion]"/-->
                      </div>

                      <div id="rechazados" class="tab-pane ">
                        <!--g:render template="estatusDePago/pagosRechazados" model="[pagos:pagosInstitucion]"/-->
                      </div>

                      <div id="vencidos" class="tab-pane">
                        <!--g:render template="estatusDePago/pagosVencidos" model="[pagos:pagosInstitucion]"/-->
                      </div>
                    </div>
                  </div>
              <!--PAGE CONTENT ENDS-->
            </div><!--/.span-->
          </div><!--/.row-fluid-->
        </div>       

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