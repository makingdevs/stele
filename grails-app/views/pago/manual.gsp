<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require module="busquedaDependientes" />
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
            <li class="active">Cobros</li>
          </ul><!--.breadcrumb-->
        </div>
        <div class="page-content">
          <div class="page-header position-relative">
            <h1>
              Registrar pago 
              <small>
                <i class="icon-double-angle-right"></i>
                Pago manual
              </small>
            </h1>
          </div>
          <div class="row-fluid">
            <g:if test="${flash.pagoCorrecto}">  
              <div id="message"class="alert alert-success">
                Se ha procesado el pago correctamente
              </div>
            </g:if>
            <div class="span12">
              <div class="row-fluid">
                <div class="span12">
                  <div class="widget-box">
                    <div class="widget-header">
                      <h5> Nombre Alumno </h5>
                    </div>
                    <g:formRemote name="busquedaIndividual" update="listaResultados" url="[controller: 'dependiente', action: 'busquedaDependienteParaObtenerPagos']">
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
                  <div class="widget-box" id="listaResultados" >
                    <g:render template="/dependiente/resultados" />
                  </div>
                </div>
              </div>  
                <div class="row-fluid" id="listaPagos">
                  <g:render template="/pago/contenedor" modal="['pagosVencido': pagosVencido,'pagosRechazados':pagosRechazados,'pagosEnTiempo':pagosEnTiempo,'pagosPorRealizar':pagosPorRealizar]"/>
                </div>
            </div>
          </div>

      </div><!--/.main-content-->
  </body>
</html>
