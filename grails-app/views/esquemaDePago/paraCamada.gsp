<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require module="paraCamada" />
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
          </li>
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
            <g:if test="${flash.message}">
              <input type="hidden" name="message" value="${flash.message}"/>
              ${flash.message}
            </g:if>
            <g:else>
              Inscripción Archivo + Cobro
            </g:else>
            <small>
              <i class="icon-double-angle-right"></i>
              <g:if test="${flash.message}">
                Registrar un cobro unitario o por bloque
              </g:if>
              <g:else>
                Inscripción Archivo de Alumnos y su Padre o Tutor, más a gregar un cobro a los alumnos del archivo
              </g:else>
            </small>
          </h1>
        </div>
          
        <div class="row-fluid">
          <div class="span12">
            <div class="widget-box">
              <div class="widget-header widget-header-blue widget-header-flat"></div>              
              <div class="widget-body">
                <div class="widget-main">
                  <div class="row-fluid">
                    <g:render template="menuArchivoPago" />
                    <hr />
                    <div align="center" id="imagenCarga" class="hidden">
                      <img class="prev" aling="center"  width="60" height="60" src="${resource(dir: 'images', file: 'loading.gif')}" alt="Previous" /> CARGANDO
                    </div>
                    <div class="step-content row-fluid  position-relative" id="step-container">                    
                      <div class="step-pane active" id="step5">
                        <div class="tabbable3">                          
                          <ul class="nav nav-tabs padding-18 tab-size-bigger" id="myTab3">
                            <li class="active">
                              <a data-toggle="tab" href="#faq-tab-111">
                                <i class="orange icon-money   bigger-120"></i>
                                Cobro Unitario
                              </a>
                            </li>
                            <li>
                            <a data-toggle="tab" href="#faq-tab-222">
                              <i class="blue icon-retweet   bigger-120"></i>
                              Cobro Recurrente
                            </a>
                            </li>
                          </ul>

                          <div class="tab-content">                          
                            <div id="faq-tab-111" class="tab-pane active">
                              <g:render template="/esquemaDePago/cobroUnitario" />
                            </div>
                            <div id="faq-tab-222" class="tab-pane">
                              <g:render template="/esquemaDePago/cobroRecurrente" />
                            </div>
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
    </div><!--/.main-content-->


      <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-small btn-inverse">
      <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>

    <script id="descuento-template" type="text/x-handlebars-template">
    {{#if this}}
      {{#each this}}
      <tr>
        <td>{{descuento}}</td>
        <td>{{cantidad}}</td>
        <td style="padding-left:0px;">
          <input type="text" class="expiracionDescuento" style="width:100%;" name="fechasDeExpiracionDescuento[{{@index}}]" />
          <input type="hidden" value="{{id}}" name="idDescuento[{{@index}}]" />
        </td>
      </tr>    
      {{/each}}
    {{else}}
      <tr>
        <td colspan="3">
          El concepto no tiene descuentos.
        </td>
      </tr> 
    {{/if}}
    </script>

  </body>
</html>
