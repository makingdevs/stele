<%@ page import="com.payable.TipoDePago" %>
<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require modules="telefono,styledrop,uploadImg,bootstrapDatePicker,upload,perfilValidate"/>
    <r:script>
      $(document).ready(function() {
        $('#fechaPago').datepicker({
          format : "dd/mm/yyyy",
          language : 'es',
          autoclose : false
        });
      });
      $(function() {
        var urlValue = $("input#url").val() 
        $("#comprobante").dropzone({
          url : urlValue,
          maxFilesize : .5,
          addRemoveLinks : false
        });
      });
    </r:script>
  </head>
  <body>
    <div class="page-content">
      <input type="hidden" value="${createLink(controller:'reciboPago', action:'subirArchivo', id: pago.id)}" id="url" />
      <div class="page-header position-relative  ">
        <h1> Comprobante de pago </h1>
      </div><!--/.page-header-->
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
                            Descuento
                          </th>
                          <th class=" green">
                            Total con Descuento
                          </th>
                          <th class=" red">
                            Recargo
                          </th>
                          <th class=" red">
                            Total con Recargo
                          </th>
                          <th>F. Vencimiento</th>
                          <th>Monto</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>${pago.conceptoDePago}</td>
                          <td>$ ${pago.descuentoAplicable}</td>
                          <td>$ ${pago.cantidadDePago - pago.descuentoAplicable}</td>
                          <td>$ ${pago.recargosAcumulados}</td>
                          <td>$ ${pago.cantidadDePago - pago.recargosAcumulados}</td>
                          <td>${pago.fechaDeVencimiento.format('dd-MMM-yyyy')}</td>
                          <td>$ ${pago.cantidadDePago}</td>     
                          </tr>
                      </tbody>  
                    </table>
                  </div>
                </div>
              </div>
            </div><!--/span-->
          </div>
          <div class="widget-box">
            <div class="widget-header widget-header-small header-color-green">
              <h5 class="bigger lighter">
                Adjunte su comprobante
              </h5>
            </div>
            <div class="widget-body">
              <div class="widget-main">
                <div id="comprobante" type="file" class="dropzone">
              </div>
            </div>
          </div>
          <div class="row-fluid">
          <g:form name="pagoInmediato" url="[action:'pagoInmediatoVentanilla', controller:'pago']">
              <div class="span12">
                <div class="span8">                                    
                  <div class="row-fluid">
                    <div class=" widget-container-span">
                      <div class="widget-box">
                        <input type="hidden" id="transactionId" name="transactionId" value="${pago.transactionId}">
                        <div class="widget-header widget-header-small header-color-green2">
                          <h5 class="bigger lighter">
                            Confirmar pago
                          </h5>
                        </div>
                        <div class="widget-body">
                          <div class="widget-main no-padding">
                            <table class="table table-striped table-bordered table-hover">
                              <tbody>
                                <tr>
                                  <td class="">Fecha comprobante</td>
                                  <td>
                                    <div id="fechaPago" class="input-append date" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
                                      <input id="fechaDePago" name="fechaDePago" data-format="yyyy-mm-dd" typeinput>
                                      <span class="add-on">
                                        <i class="icon-calendar"></i>
                                      </span>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <td  class="">Monto</td>
                                  <td class="">                                     
                                    <div class="input-prepend"> 
                                      <span class="add-on">
                                        <i class="icon-usd"></i>
                                      </span>
                                      <input id="form-field-mask-2" class="input-medium " type="text" placeholder="importe" >
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <td  class="">Tipo pago</td>
                                  <td class="">                                     
                                     <g:select id="tipoDePago" name="tipoDePago" from="${TipoDePago.values()}" optionKey="key" />
                                  </td>
                                </tr>
                                <tr>
                                  <td>Folio Banco</td>
                                  <td>
                                    <input type="text" id="folioBanco" name="folioBanco" placeholder="Folio">
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                    </div><!--/span-->
                  </div>
                  <div class="form-actions center">
                    <button class="btn btn-info"  type="submit">
                      <i class="icon-ok bigger-110"></i>
                      Aceptar
                    </button>
                  </div>  
                </div>
              </div><!--/.span-->
            </g:form>
          </div>
        </div>
      </div><!--/.main-content-->
    </div><!--/.main-container-->
      <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-small btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
      </a>
     
  </body>
</html>