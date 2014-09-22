<html>
  <head>
    <meta name="layout" content="colegio"/>
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
              Conciliar
              <small>
                <i class="icon-double-angle-right"></i>
                Comprobante de pago
              </small>
            </h1>
          </div><!--/.page-header-->

          <div class="row-fluid">
            <div class="span12">
              <div class="span6">         
                <div class="span12 widget-container-span">
                    <div class="widget-box">
                      <div class="widget-header widget-header-small header-color-blue">
                        <h5 class="bigger lighter">
                          Cobro
                        </h5>
                      </div>
                      <div class="widget-body">
                        <div class="widget-main no-padding">
                          <table class="table table-striped table-bordered table-hover">
                            <tbody>
                              <tr>
                                <td>Concepto</td>
                                <td>${payment.paymentConcept}</td>
                              </tr>
                              <tr>
                                <td>Vencimiento</td>
                                <td>${payment.dueDate.format('dd/MM/yyyy')}</td>
                              </tr>
                              <tr>
                                <td>Importe</td>
                                <td><g:formatNumber number="${payment.paymentAmount}" type="currency" currencyCode="MXN" /></td>
                              </tr>   
                            </tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                </div><!--/span-->
                <g:if test="${payment.accumulatedDiscount > 0}">
                    <g:each var="applicableDiscount" in="${payment.applicableDiscounts}">
                      <div class="row-fluid">
                        <div class="span12 widget-container-span">
                          <div class="widget-box">
                            <div class="widget-header widget-header-small header-color-blue2">
                              <h5 class="bigger lighter">
                                Descuento
                              </h5>
                            </div>
                            <div class="widget-body ">
                              <div class="widget-main no-padding widget-header-small ">
                                <table class="table table-striped table-bordered table-hover">
                                  <tbody>
                                    <tr>
                                      <td >Concepto</td>
                                      <td >${applicableDiscount.discount.first().discountName}</td>
                                    </tr>

                                    <tr>
                                      <td >Vencimiento</td>
                                      <td >${applicableDiscount.expirationDate.format('dd/MM/yyyy')}</td>
                                    </tr>
                                    <tr>
                                      <td >Importe</td>
                                      <td >$ ${payment.accumulatedDiscount}</td>
                                    </tr>   
                                  </tbody>
                                </table>
                              </div>
                            </div>
                          </div>
                        </div><!--/span-->
                      </div>
                    </g:each>
                    <div class="row-fluid">
                    <div class="span12 widget-container-span">
                      <div class="widget-box">
                        <div class="widget-header widget-header-small header-color-blue3">
                          <h5 class="bigger lighter">
                            Cobro con descuento
                          </h5>
                        </div>
                        <div class="widget-body">
                          <div class="widget-main no-padding">
                            <table class="table table-striped table-bordered table-hover">
                              <tbody>
                                <tr>
                                  <td >Vencimiento</td>
                                  <td >${payment.dueDate.format('dd/MM/yyyy')}</td>
                                </tr>
                                <tr>
                                  <td>Importe</td>
                                  <td><strong><g:formatNumber number="${payment.paymentAmount - payment.accumulatedDiscount}" type="currency" currencyCode="MXN" /></strong></td>
                                </tr>
                              </tbody>
                            </table>
                          </div>
                        </div>
                        <input type="hidden" id="transactionId" name="transactionId" value="${payment.transactionId}">
                      </div>
                    </div><!--/span-->
                    </div>
                </g:if>
                <div class="form-actions ">
                  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
                   <g:link controller="pago" action="mostrarPagosAsociadosALaInstitucionEnBaseAHistorialesAcademicos"><button type="button" class="btn btn-large  btn-purple "><i class="icon-reply bigger-150"></i>Regresar</button></g:link>
                </div>  
              </div>

              <div class="span6">
                <div class="widget-box">
                  <div class="widget-header blue">
                    <h4>Descargar Comprobante</h4>
                  </div>
                  <div class="widget-body">
                    <div class="widget-main">
                      <div class="center">
    
                        <span class="control-group warning">
                          <g:if test="${payment.proofOfPayment}">
                            <g:link controller="comprobante" action="descargarComprobante" params="[pagoId:payment.id]">
                            <span class="btn btn-large btn-info  blue" href="#">
                              <i class="icon-file-text bigger-160"></i>
                              Comprobante Pago
                            </span>
                            </g:link>
                          <span class=" help-inline pink">
                            Comprobante adjuntado <strong> ${payment.lastUpdated.format('dd/MM/yyyy')} </strong>
                          </span>
                          </g:if>
                          <g:else>
                            <span class=" help-inline pink">
                              No hay comprobante, el pago fue en efectivo.
                            </span>
                          </g:else>
                        </span>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="widget-box">
                  <div class="widget-header blue">
                    <h4>Descargar recibo de pago</h4>
                  </div>
                  <div class="widget-body">
                    <div class="widget-main">
                      <div class="center">
                        <span class="control-group warning">
                          <g:link class="btn btn-large btn-info  blue" controller="pago" action="generarComprobante" params="[pagoId:payment.id]">
                            <i class="icon-file-text bigger-160"></i>
                              Recibo de pago
                          </g:link>
                        </span>
                      </div>
                    </div>
                  </div>
                </div>          
              </div>  

              </div>
            </div><!--/.span-->
          </div><!--/.row-fluid-->
        </div><!--/.page-content-->
  </body>
</html>
