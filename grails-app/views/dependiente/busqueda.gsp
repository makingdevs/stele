<%@ page import="com.stele.Turno" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="colegio"/>listaDependientes
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
          <li class="active">Conciliacion</li>
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
            <div class="tabbable">
              <ul class="nav nav-tabs" id="myTab">
                <li class="active">
                  <a data-toggle="tab" href="#faq-tab-1">
                    <i class="green icon-group   bigger-120"></i>
                    Bloque
                  </a>
                </li>
                <li>
                  <a data-toggle="tab" href="#faq-tab-2">
                    <i class="blue icon-user   bigger-120"></i>
                    Alumno
                  </a>
                </li>
              </ul>
              <div class="tab-content no-border">
                <div id="faq-tab-1" class="tab-pane  in active">
                  <div class="row-fluid">
                    <div class="span12">
                      <div id="busquedaForm">
                        <g:render template="busquedaForm" model="[turno:turno]" />
                      </div>
                      <div class="span1"></div>
                      <div id="dependientes" name="dependientes" >
                        <g:render template="dependienteCar" />
                      </div>
                    </div>
                  </div>            
                </div>
                <div id="faq-tab-2" class="tab-pane">                   
                  <div class="row-fluid">
                    <div class="span12">
                      <div class="widget-box">
                      <g:formRemote name="busquedaIndividual" update="listaResultados" url="[controller: 'dependiente', action: 'busquedaDependienteParaGenerarPago']">
                          <div class="widget-header">
                            <h5> Nombre Alumno </h5>
                          </div>

                          <div class="widget-body">
                            <div class="widget-main">
                              <input type="text" id="nombreDependiente" name="nombreDependiente" placeholder="Nombre del Dependiente" />
                              <button type="submit" class="btn btn-purple btn-small">
                                Buscar
                                <i class="icon-search icon-on-right bigger-110"></i>
                              </button>
                            </div>
                          </div>
                      </g:formRemote>
                      </div>
                      <div id="listaResultados" class="widget-box">
                        <div class="widget-header">
                          <h5> Lista de Alumnos </h5>
                        </div>
                        <g:render template="busquedaDependiente" />
                      </div>
                    </div>
                  </div>  
                </div>
              </div>
            </div>
            </div>
          </div>
        </div>
      <div class="ace-settings-container" id="ace-settings-container">          
        <div class="ace-settings-box" id="ace-settings-box">
          <div>
            <div class="pull-left">
              <select id="skin-colorpicker" class="hide">
                <option data-skin="default" value="#438EB9">#438EB9</option>
                <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
              </select>
            </div>
            <span>&nbsp; Choose Skin</span>
          </div>
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
  </body>
</html>