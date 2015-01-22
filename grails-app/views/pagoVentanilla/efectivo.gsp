<%@ page import="com.payable.PaymentType" %>
<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require modules="telefono,styledrop,uploadImg,upload,perfilValidate,pagoVentanilla"/>
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
        <li class="active">Pago Manual</li>
      </ul><!--.breadcrumb-->
    </div>
    
    <div class="page-content">      
      
      <div class="page-header position-relative  ">
         <font color="2E9AFE"><h1>Comprobante de pago</h1></font>
      </div><!--/.page-header-->
      
      <div class="page-content">        
        <!--PAGE CONTENT BEGINS-->
        <div class="row-fluid" style="height:200px;">
          <!--ROW_FLUID BEGINS-->
          <div class="span12 ">
            <div class="widget-box">
              
              <div class="widget-header widget-header-small header-color-blue2">
                <input type="hidden" value="${createLink(controller:'reciboPago', action:'subirArchivo', id: payment.id)}" id="url" />
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
                        <td>${payment.paymentConcept}</td>
                        <td>$ ${payment.accumulatedDiscount}</td>
                        <td>$ ${payment.paymentAmount - payment.accumulatedDiscount}</td>
                        <td>$ ${payment.accumulatedSurcharges}</td>
                        <td>$ ${payment.paymentAmount - payment.accumulatedSurcharges}</td>
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
          <!--ROW_FLUID ENDS--> 
        </div>
        <div class="row-fluid">
          <!--ROW_FLUID BEGIN-->           
          <g:form id="pagoInmediato" name="pagoInmediato" url="[action:'pagoInmediatoVentanilla', controller:'pago']" style="margin-bottom:0px"> 
          <div class="span4">            
              <div class="widget-container-span">

              <!--WIDGET-CONTAINER-BEGIN-->
                <div class="widget-box">
                  <input type="hidden" id="transactionId" name="transactionId" value="${payment.transactionId}">
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
                              <div class="input-append date">
                                <input id="fechaDePago" name="fechaDePago" type="text" />
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
                              <g:select id="tipoDePago" name="tipoDePago" from="${listTipoPagos}" optionKey="key" optionValue="pago"/>
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
              <!--WIDGET-CONTAINER-END-->
              </div>
              <div class="form-actions center">
                <button class="btn btn-info"  type="submit" formtarget="_blank">
                  <i class="icon-ok bigger-110"></i>
                  Aceptar
                </button>
              </div>            
          </div>
          </g:form>            
          <div class="span8">
            
            <div class=" widget-container-span">
              <div class="widget-box">
                <div class="widget-header widget-header-small header-color-green">
                  <h5 class="bigger lighter">
                    Adjunte su comprobante
                  </h5>
                </div>
                <div class="widget-body">
                  <div>
                    <div class="widget-main">
                      <div id="comprobante" type="file" class="dropzone"></div>
                    </div>
                  </div>                  
                </div>
              </div>
            </div>
            <div class="span6">
              <g:link controller="pago" action="generarPagoEnVentanilla">
                <button type="button" class="btn btn-purple">
                <i class="icon-reply bigger-150"></i>
                  Regresar
                </button>
              </g:link>
            </div>
          </div>

          
          <!--ROW_FLUID ENDS--> 
        </div>
        <!--PAGE CONTENT ENDS-->
      </div>
    </div>

  </div>
  </body>
</html>
