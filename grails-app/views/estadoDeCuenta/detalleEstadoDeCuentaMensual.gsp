<%@ page import="com.payable.EstatusDePago" %>


<html>
<head>
  <meta name="layout" content="colegio"/>
</head>
<body>
  <div class="page-content">
    <div class="page-header position-relative  ">
      <h1> Detalle Estado de Cuenta </h1>
    </div><!--/.page-header-->

  <div class="row-fluid">
    <div class="span12">
      <!--PAGE CONTENT BEGINS-->
      <div class="widget-box">
        <div class="widget-header widget-header-small header-color-blue center">
          <h5 class="bigger lighter">
            <i class="icon-table"></i>
            <strong> ${mes} </strong>
          </h5> 
        </div>

        <div class="widget-body">
          <div class="widget-main ">
            <div class="row-fluid"> 
              <div class="span12">              

                <div class="span4 widget-container-span">
                  <div class="widget-box">
                    <div class="widget-header widget-header-small header-color-red3 center">
                      <h5 class="bigger lighter">
                        <strong>Mis Cargos</strong> 
                      </h5>
                    </div>

                    <div class="widget-body">
                      <div class="widget-main no-padding">
                        <table class="table table-striped table-bordered table-hover">
                          <thead>
                            <tr>
                              <th>Fecha</th>
                              <th>Concepto</th>
                              <th>Monto</th>
                            </tr>
                          </thead>
                          <tbody>
                            <g:each in="${pagosDelMes}">
                              <tr>
                                <td>${it.fechaDeVencimiento.format("dd/MM/yy")}</td>
                                <td>${it.conceptoDePago}</td>
                                <td>${it.cantidadDePago}</td>
                              </tr>
                            </g:each>
                          </tbody>
                        </table>
                        <div class="alert alert-info center">
                          <strong>$ ${pagosDelMes*.cantidadDePago.sum()}</strong>
                        </div>                          
                      </div>
                    </div>
                  </div>
                </div><!--/span-->


                <div class="span8 widget-container-span">
                  <div class="widget-box">
                    <div class="widget-header widget-header-small header-color-green center">
                      <h5 class="bigger lighter">
                        <strong>Mis Pagos</strong> 
                      </h5>

                    </div>

                    <div class="widget-body">
                      <div class="widget-main no-padding">
                        <table class="table table-striped table-bordered table-hover">
                          <thead>
                            <tr>
                              <th>Fecha</th>
                              <th>Concepto</th>
                              <th>Monto</th>
                              <th>Forma pago</th>
                              <th>Comprobante</th>
                            </tr>
                          </thead>
                          <tbody>
                            <g:findAll in="${pagosDelMes}" expr="it.estatusDePago == EstatusDePago.PAGADO">
                              <tr>
                                <td>${it.fechaDePago.format("dd/MM/yy")}</td>
                                <td>${it.conceptoDePago}</td>
                                <td>$ ${it.cantidadDePago}</td>
                                <td>${it.tipoDePago}</td>
                                <td>
                                  <div class="action-buttons center">
                                    <g:link controller="comprobante" action="comprobantePagoMes" params='[id:"${it.id}"]'>
                                      <i class="icon-file-text-alt bigger-140"></i>
                                    </g:link>
                                  </div>
                                </td>
                             </tr>
                            </g:findAll>
                          </tbody>
                        </table>
                      <div class="alert alert-info center">
                        <strong>$ ${pagosDelMes.findAll{ pago -> pago.estatusDePago == EstatusDePago.PAGADO}*.cantidadDePago.sum()} </strong>
                      </div>

                    </div>
                  </div>
                </div>
              </div><!--/span-->
            </div>
          </div>
          <div class="row-fluid"> 
            <div class="span12">
              <g:link  class="btn btn-primary pull-right" controller="estadoDeCuenta" action="show">
              <i class="icon-reply  bigger-125"></i>
              Regresar
              </g:link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
