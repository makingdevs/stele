<%@ page import="com.stele.Turno" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require modules="bootstrap-js,busquedaDependientes" />
  </head>
  <body>
    <script type="text/javascript">
      $(function(){
        $("#faq-tab-1").on( "click", "#searchDependientesButton", function(){
          $("#searchDependientes").submit();
        });
      });
    </script>
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
          <li class="active">Generar Cobros</li>
        </ul><!--.breadcrumb-->
      </div>
      <div class="page-content">
        <div class="page-header position-relative">
          <h1>
            Generar Cobros
            <small>
              <i class="icon-double-angle-right"></i>
              Registrar un cobro unitario o por bloque 
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
                        <g:render template="/utilidades/busquedaForm" model="[turno:turno]" />
                      </div>
                      <div class="span1"></div>
                      <div id="dependientes" name="dependientes" >
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
                              <div class="input-append"> 
                                <input type="text" id="nombreDependiente" name="nombreDependiente" placeholder="Nombre del Dependiente" />
                                <button type="submit" class="btn btn-purple btn-small">
                                  Buscar
                                  <i class="icon-search icon-on-right bigger-110"></i>
                                </button>
                              </div>
                            </div>
                          </div>
                      </g:formRemote>
                      </div>
                      <div id="listaResultados" class="widget-box">
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

    </div><!--/.main-content-->
  </body>
</html>
