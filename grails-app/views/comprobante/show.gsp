<%@ page import="com.payable.EstatusDePago" %>
<%@ page import="com.payable.TipoDePago" %>
<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require modules="bootstrapDatePicker,perfilValidate"/>
  </head>

  <body>
    <r:script>
      $(document).ready(function() {
        $('#datetimepicker1').datepicker({
          format : "dd/mm/yyyy",
          language : 'es',
          autoclose : true
        });
      });
    </r:script>

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
                  <sec:ifAllGranted roles="ROLE_DIRECTOR">
                    <div class="row-fluid">
                      <div class="span12 widget-container-span">
                      <div class="widget-box">
                        <div class="widget-header widget-header-small header-color-green">
                          <h5 class="bigger lighter">
                            Confirmar pago
                          </h5>
                        </div>
                        <div class="widget-body">
                          <div class="widget-main no-padding">
                            <table class="table table-striped table-bordered table-hover">
                              <tbody>
                                <tr>
                                  <td >Fecha comprobante</td>
                                  <td >
                                    <div id="datetimepicker1" class="input-append date" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
                                      <input id="fechaDePago" name="fechaDePago" data-format="yyyy-mm-dd" type="text" />
                                      <span class="add-on">
                                        <i class="icon-calendar"></i>
                                      </span>
                                    </div>
                                  </td>
                                </tr>

                                <tr>
                                  <td  >Monto</td>
                                  <td >   
                                    $<g:formatNumber number="${pago.cantidadDePago}" type="currency" currencyCode="MXN" />
                                  </td>
                                </tr>

                                <tr>
                                  <td  >Tipo pago</td>
                                  <td >                    
                                  <span class="form-field-select-1">
                                    <g:select id="tipoDePago" name="tipoDePago" noSelection="['':'- Tipo de Pago-']" from="${TipoDePago.values()}" optionKey="key" />
                                  </span>
                                  </td>
                                </tr>


                                <tr>
                                  <td  >Referencia Banco</td>
                                  <td >                                     
                                    <div class="input-prepend">
                                     <input type="text" id="folioBanco" name="folioBanco">
                                      <span class="add-on">
                                        <i class="icon-edit"></i>
                                      </span>
                                    </div>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                      </div><!--/span-->
                    </div>
                    <div class="form-actions ">
                      <button type="submit" class="btn btn-success"><i class="icon-thumbs-up-alt"></i> Aprobar</button>
                      &nbsp; &nbsp; &nbsp;
                      <g:link controller="comprobante" action="rechazarPago" params="[transactionId: "${pago.transactionId}"]" ><button type="button" class="btn btn-danger"><i class="icon-reply bigger-150"></i></i> Rechazar</button></g:link>
                    </div>  
                  </sec:ifAllGranted> 
                </g:form>
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

                          <span class="btn btn-large btn-info  blue" href="#">
                            <i class="icon-file-text bigger-160"></i>
                            Comporbante Pago
                          </span>
                          <span class=" help-inline pink">
                              Comporbante adjuntado <strong> ${pago.lastUpdated.format('dd/MM/yyyy')} </strong>
                          </span>
                        </span>
                      </div>
                    </div>
                  </div>
                </div>
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
