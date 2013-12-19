<html>
  <head>
    <meta name="layout" content="colegio"/>
  </head>
  <body>
    <div class="page-content">
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
          <div class="row-fluid">
            <div class="span12">
              <div class="span8">                                    
                <div class="row-fluid">
                  <div class=" widget-container-span">
                    <div class="widget-box">
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
                                <td class="">
                                  <div class="input-append">
                                    <input type="text" id="datepicker" class="input-medium" placeholder="vencimiento"  />
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
                                  <span class="form-field-select-1">
                                  Efectivo
                                  </span>
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
                  <button class="btn btn-info"  type="button">
                    <i class="icon-ok bigger-110"></i>
                    Aceptar
                  </button>
                  <button class="btn" type="limpiar">
                    <i class="icon-undo bigger-110"></i>
                    Limpiar
                  </button>
                </div>  
              </div>
              <!--PAGE CONTENT ENDS-->
            </div><!--/.span-->

        </div>
      </div><!--/.main-content-->
    </div><!--/.main-container-->
      <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-small btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
      </a>
     
  </body>
</html>