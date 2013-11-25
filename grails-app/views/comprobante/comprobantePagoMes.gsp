<%@ page import="com.payable.EstatusDePago" %>
<%@ page import="com.payable.TipoDePago" %>
<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require modules="bootstrap-js" />
  </head>
  <body>

  <div >
        <div class="page-content">
          <div class="page-header position-relative">
            <h1>
              Comprobante
            </h1>
          </div><!--/.page-header-->

          <div class="row-fluid">
            <div class="span12">
              <!--PAGE CONTENT BEGINS-->
                
              <div class="span6">         
                <g:form class="form-horizontal" id="conciliacion" name="conciliacion" controller="comprobante" action="validarComprobante">    
                  <input type="hidden" id="transactionId" name="transactionId" value="${pago.transactionId}">                      
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
                                <td>${pago.conceptoDePago}</td>
                              </tr>
                              <tr>
                                <td>Vencimiento</td>
                                <td>${pago.fechaDeVencimiento.format('dd/MM/yyyy')}</td>
                              </tr>
                              <tr>
                                <td>Importe</td>
                                <td>$<g:formatNumber number="${pago.cantidadDePago}" type="currency" currencyCode="MXN" /></td>
                              </tr>   
                            </tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                  </div><!--/span-->
                  <g:if test="${pago.descuentoAplicable > 0}">
                    <g:each var="descuentoAplicable" in="${pago.descuentosAplicables}">
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
                                      <td >${descuentoAplicable.descuento.first().nombreDeDescuento}</td>
                                    </tr>

                                    <tr>
                                      <td >Vencimiento</td>
                                      <td >${descuentoAplicable.fechaDeExpiracion.format('dd/MM/yyyy')}</td>
                                    </tr>
                                    <tr>
                                      <td >Importe</td>
                                      <td >$ ${pago.descuentoAplicable}</td>
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
                                  <td >${pago.fechaDeVencimiento.format('dd/MM/yyyy')}</td>
                                </tr>
                                <tr>
                                  <td >Importe</td>
                                  <td ><strong>$<g:formatNumber number="${pago.cantidadDePago - pago.descuentoAplicable}" type="currency" currencyCode="MXN" /></strong></td>
                                </tr>
                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                    </div><!--/span-->
                    </div>
                  </g:if>
                </g:form>
              </div>
              <div class="span6">
                <div class="widget-box">
                  <div class="widget-header blue">
                    <h4>Comprobante</h4>
                  </div>
                  <div class="widget-body">
                    <div class="widget-main">
                      <div class="center">
                        <iframe class="cboxPhoto" src="${pago.comprobanteDePago.url()}"  width="100%" height="450px" ></iframe>  
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
