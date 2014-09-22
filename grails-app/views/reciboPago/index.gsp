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

  <input type="hidden" value="${createLink(controller:'reciboPago', action:'subirArchivo', id: payment.id)}" id="url" />

  <div class="page-content">
    <div class="page-header position-relative  ">
      <h1> Comprobante de pago </h1>
    </div><!--/.page-header-->

    <div class="row-fluid">
      <div class="span12">
        <!--PAGE CONTENT BEGINS-->

        <div class="row-fluid">
          <div class="span12 widget-container-span">
            <div class="widget-box">
              <div class="widget-header widget-header-small header-color-blue2">
                <h5 class="bigger lighter">
                  <i class="icon-money"></i>
                  Pago
                </h5> 
              </div>

              <div class="widget-body">
                <div class="widget-main no-padding">
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
                        <td>01-Nov-2013</td>
                        <td>$ ${payment.accumulatedDiscount}</td>
                        <td>$ ${payment.paymentAmount - payment.accumulatedDiscount}</td>
                        <td>${payment.dueDate.format('dd-MMM-yyyy')}</td>
                        <td>$ ${payment.paymentAmount}</td>      
                      </tr>
                    </tbody>  
                  </table>
                </div>
              </div>
            </div>
          </div><!--/span-->
        </div>
        <div class="row-fluid">
          <div class="span12">
            <div class="span4">         
              <form class="form-horizontal" id="sample-form">                             
                <div class="widget-box">
                  <div class="widget-header widget-header-small header-color-green">
                    <h5 class="bigger lighter">Adjunte su comprobante</h5>
                  </div>
                  <div class="widget-body">
                    <div class="widget-main">
                      <input type="file" id="id-input-file-2" />
                    </div>
                  </div>  
                </div>
              </form>
            </div>

            <div class="span8">
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
              <div class="span8">
                <g:link controller="estadoDeCuenta" action="show">
                <button type="button" class="btn btn-purple">
                  <i class="icon-reply bigger-150"></i>
                  Regresar
                </button>
                </g:link>
              </div>  
            </div>  

            <!--PAGE CONTENT ENDS-->
          </div><!--/.span-->
        </div><!--/.row-fluid-->
      </div><!--/.page-content-->
      <div class="ace-settings-container" id="ace-settings-container">
        <div class="ace-settings-box" id="ace-settings-box">
          <div>
            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
          </div>

          <div>
            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
          </div>

          <div>
            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
          </div>

          <div>
            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
          </div>
        </div>
      </div><!--/#ace-settings-container-->

      <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-small btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
      </a>
      <!--basic scripts-->

      <!--[if !IE]>-->

      <script type="text/javascript">
        window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
      </script>

      <!--<![endif]-->

    </body>
</html>
