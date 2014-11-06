<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require module="upload" />

    <r:script>
    $(function() {
      var urlValue = $("input#url").val() 

      Dropzone.options.dropzone = {
        url : urlValue,
        maxFilesize : .5,
        addRemoveLinks : false
      };
    });
    </r:script>
  </head>
  <body>
  <div class="main-content">
    <input type="hidden" value="${createLink(controller:'reciboPago', action:'subirArchivo', id: payment.id)}" id="url" />

    <div class="breadcrumbs" id="breadcrumbs">
      <ul class="breadcrumb">
        <li>
          <i class="icon-home home-icon"></i>
          <a href="#">Colegio</a>
          <span class="divider">
            <i class="icon-angle-right arrow-icon"></i>
          </span>
        <li class="active">Pago Manual</li>
      </ul><!--.breadcrumb-->
    </div>
    
    <div class="page-content">
      <div class="page-header position-relative">
         <font color="2E9AFE"><h1>Comprobante de pago</h1></font>
      </div><!--/.page-header-->
      <div class="page-content">
      <!--PAGE CONTENT BEGINS-->      
        <div class="row-fluid" style="height:200px;">
          <!--ROW_FLUID BEGINS-->
          <div class="span12 ">
            
            <div class="widget-box">            
              <div class="widget-header widget-header-small header-color-blue2">
                <h5 class="bigger lighter">
                  <i class="icon-money"></i>
                  Pago
                </h5> 
              </div>
              <div class="widget-body">
                <div class="widget-main no-padding">
                <!--WIDGET_MAIN BEGIN-->
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>Concepto</th>
                        <th class=" green">
                          Fecha Descuento
                        </th>
                        <th class=" green">
                          Descuento
                        </th>
                        <th class=" green">
                          Total con Descuento
                        </th>
                        <th>F. Vencimiento</th>
                        <th>Monto</th>

                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>${payment.paymentConcept}</td>
                        <td></td>
                        <td>$ ${payment.accumulatedDiscount}</td>
                        <td>$ ${payment.paymentAmount - payment.accumulatedDiscount}</td>
                        <td>${payment.dueDate.format('dd-MMM-yyyy')}</td>
                        <td>$ ${payment.paymentAmount}</td>      
                      </tr>
                    </tbody>  
                  </table>
                <!--WIDGET_MAIN ENDS-->
                </div>
              </div>
            </div>

          </div>
          <!--ROW FLUID ENDS-->
        </div>
        <div class="row-fluid">
          <!--ROW FLUID BEGIN -->
          <div class="span8">
            <div class=" widget-container-span">
              <div class="widget-box">
                <div class="widget-header widget-header-small ">
                  <h4>Comprobante</h4>
                </div>
                <div class="widget-body">
                  <div class="widget-main">
                    <div class="center">
                      <div id="dropzone" class="dropzone">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="span8">
              <g:link controller="pago" action="generarPagoEnVentanilla">
                <button type="button" class="btn btn-purple">
                  <i class="icon-reply bigger-150"></i>
                    Regresar
                </button>
              </g:link>
            </div>  
          </div> 
          <!--ROW FLUID END -->
        </div>
      <!--PAGE CONTENT ENDS-->
      </div>
    </div>
  </div>

  <!--[if !IE]>-->
  <script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
  </script>
  <!--<![endif]-->

  </body>
</html>
