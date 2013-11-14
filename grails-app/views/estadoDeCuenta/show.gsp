<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="Colegio"/>
</head>
<body>
  <div class="page-content">
    <div class="page-header position-relative  ">
      <h1> Estado de cuenta </h1>
    </div><!--/.page-header-->

    <div class="row-fluid">
      <div class="span12">
        <!--PAGE CONTENT BEGINS-->
        <g:render template="/perfil/header" model="[usuarioActual:usuarioActual, dependiente:dependiente , perfil:perfil]" />
        
        <div class="row-fluid">
          <div class="span12">
            <form class="form-horizontal">
              <div class="row-fluid">
                <!--div class="span12 widget-container-span">
                  <div class="widget-box">
                    <div class="widget-header widget-header-small header-color-green2">
                      <h5 class="bigger lighter">
                        <i class="icon-info-sign bigger-130"></i>
                        Datos para generar el pago
                      </h5>

                      <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                          <i class="icon-chevron-down"></i>
                        </a>
                      </div>
                    </div>

                    <div class="widget-body no-padding">
                      <div class="widget-main ">
                        <div id="faq-list-1" class="accordion-style1 accordion">
                          <div class="accordion-group">
                            <div class="accordion-heading">
                              <a href="#faq-1-1" data-parent="#faq-list-1" data-toggle="collapse" class="accordion-toggle collapsed">
                                <i class="icon-exchange bigger-130"></i>
                                Tranferencia bancaria
                              </a>
                            </div>

                            <div class="accordion-body collapse" id="faq-1-1">
                              <div class="accordion-inner">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
                              </div>
                            </div>
                          </div>

                          <div class="accordion-group">
                            <div class="accordion-heading">
                              <a href="#faq-1-2" data-parent="#faq-list-1" data-toggle="collapse" class="accordion-toggle collapsed">
                                <i class="icon-indent-right bigger-130"></i>
                                Ficha de referencia
                              </a>
                            </div>
                            <div class="accordion-body collapse" id="faq-1-2">
                              <div class="accordion-inner">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
                              </div>
                            </div>
                          </div>

                          <div class="accordion-group">
                            <div class="accordion-heading">
                              <a href="#faq-1-3" data-parent="#faq-list-1" data-toggle="collapse" class="accordion-toggle collapsed">
                                <i class="icon-edit bigger-130"></i>
                                Cheque
                              </a>
                            </div>

                            <div class="accordion-body collapse" id="faq-1-3">
                              <div class="accordion-inner">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et.
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div-->                
                <g:render template="pagosVencidos" modal="[pagoVencido:pagosVencidos, pagoRechazo: pagosRechazados]" />
                <div class="row-fluid">
                  <div class="span12 widget-container-span">
                    <div class="widget-box">
                      <div class="widget-header widget-header-small header-color-blue">
                        <h5 class="bigger lighter">
                          <i class="icon-money"></i>
                          Pagos
                        </h5> 
                      </div>

                      <div class="widget-body">
                        <div class="widget-main no-padding">
                          <table class="table table-striped table-bordered table-hover">
                            <thead>
                              <tr>
                                <th > </th>
                                <th colspan="3" class="center green" >Descuento</th>
                                <th colspan="2" ></th>
                                <th></th>
                                <th></th>
                              </tr>
                              <tr>
                                <th>Concepto</th>
                                <th class=" green">
                                  Fecha
                                </th>
                                <th class=" green">
                                  Descuento
                                </th>
                                <th class=" green">
                                  Total
                                </th>
                                <th>F. Vencimiento</th>
                                <th>Monto</th>
                                <th></th>
                                <th></th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <td>Teatro de titeles pradres de familia</td>
                                <td>01-Nov-2013</td>
                                <td>$600.00</td>
                                <td>$5,400.00</td>
                                <td>01-Nov-2013</td>
                                <td>$6,000.00</td>      
                                <td width="70"><span class="label label-info arrowed-in">Pendiente</span></td>
                                <td class="center" width="140"> 
                                  <button class="btn btn-mini btn-purple">Adjunte comprobante...</button>
                                </td>
                              </tr>

                              <tr>
                                <td>Teatro de titeles pradres de familia</td>
                                <td>01-Nov-2013</td>
                                <td>$600.00</td>
                                <td>$5,400.00</td>
                                <td>01-Nov-2013</td>
                                <td>$6,000.00</td>      
                                <td width="70"><span class="label label-warning arrowed-in">&nbsp Revision &nbsp</span></td>
                                <td class="center" width="140"> 
                                  
                                </td>
                              </tr>

                              <tr>
                                <td>Teatro de titeles pradres de familia</td>
                                <td>01-Nov-2013</td>
                                <td>$600.00</td>
                                <td>$5,400.00</td>
                                <td>01-Nov-2013</td>
                                <td>$6,000.00</td>
                                <td width="70"><span class="label label-success arrowed-in"> &nbsp Pagado &nbsp &nbsp</span></td>
                                <td class="center" width="140">                                   
                                </td>
                              </tr>
                              <tr>
                                <td>Teatro de titeles pradres de familia</td>
                                <td>01-Nov-2013</td>
                                <td>$600.00</td>
                                <td>$5,400.00</td>
                                <td>01-Nov-2013</td>
                                <td>$6,000.00</td>
                                <td width="70"><span class="label label-important arrowed-in">Rechazado</span></td>
                                <td class="center" width="140"> 
                                  <button class="btn btn-mini btn-purple">Adjunte comprobante...</button>
                                </td>
                              </tr>                             
                            </tbody>  
                          </table>
                        </div>
                      </div>
                    </div>
                  </div><!--/span-->
                </div>
                <div class="row-fluid">
                  <div class="span12 widget-container-span">
                    <div class="widget-box">
                      <div class="widget-header widget-header-small header-color-blue3 center">
                        <h5 class="bigger lighter">
                          <i class="icon-table"></i>
                          <strong> Estado de cuenta </strong>
                        </h5> 
                        <div class="widget-toolbar">
                          <button class="btn btn-success btn-small">
                            <i class="icon-cloud-download "></i>
                            Excel
                          </button>
                          <button class="btn  btn-danger  btn-small">
                            <i class="icon-cloud-download "></i>
                            PDF
                          </button>

                        </div>
                      </div>

                      <div class="widget-body">
                        <div class="widget-main no-padding">
                          <div class="row-fluid"> 
                            <div class="span12">              

                              <div class="span6 widget-container-span">
                                <div class="widget-box">
                                  <div class="widget-header widget-header-small center">
                                    <h5 class="bigger lighter">
                                      <strong>Movimientos a la fecha</strong> 
                                    </h5>
                                  </div>

                                  <div class="widget-body">
                                    <div class="widget-main no-padding">
                                      <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                          <tr>
                                            <th>Mes</th>
                                            <th>Cargos</th>
                                            <th>Abonos</th>
                                            <th class="center">Detalle</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                          <tr>
                                            <td class="">Agosto</td>
                                            <td class="">$12,000.00</td>
                                            <td class="">$12,000.00</td>
                                            <td>
                                              <div class="action-buttons center">
                                                <a class="pink" href="conciliarpagado.html">
                                                  <i class="icon-zoom-in bigger-130"></i>
                                                </a>
                                              </div>
                                            </td>     
                                          </tr>
                                          <tr>
                                            <td class="">Setpiembre</td>
                                            <td class="">$12,000.00</td>
                                            <td class="">$12,000.00</td>
                                            <td>
                                              <div class="action-buttons center">
                                                <a class="pink" href="conciliarpagado.html">
                                                  <i class="icon-zoom-in bigger-130"></i>
                                                </a>
                                              </div>
                                            </td>     
                                          </tr>
                                        </tbody>
                                      </table>
                                    </div>
                                  </div>
                                </div>
                              </div><!--/span-->
                              <div class="span6 widget-container-span">
                                <div class="widget-box">
                                  <div class="widget-header widget-header-small center">
                                    <h5 class="bigger lighter">
                                      <strong>Movimientos por aplicar</strong> 
                                    </h5>
                                  </div>

                                  <div class="widget-body">
                                    <div class="widget-main no-padding">
                                      <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                          <tr>
                                            <th>Mes</th>
                                            <th>Cargos</th>
                                            <th>Abonos</th>
                                            <th class="center">Detalle</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                          <tr>
                                            <td class="">Enero</td>
                                            <td class="">$12,000.00</td>
                                            <td class="">$0</td>
                                            <td>
                                              <div class="action-buttons center">
                                                <a class="pink" href="conciliarpagado.html">
                                                  <i class="icon-zoom-in bigger-130"></i>
                                                </a>
                                              </div>
                                            </td>     
                                          </tr>
                                          <tr>
                                            <td class="">Febrero</td>
                                            <td class="">$12,000.00</td>
                                            <td class="">$0</td>
                                            <td>
                                              <div class="action-buttons center">
                                                <a class="pink" href="conciliarpagado.html">
                                                  <i class="icon-zoom-in bigger-130"></i>
                                                </a>
                                              </div>
                                            </td>
                                            
                                          </tr>
                                          <tr>
                                            <td class="">Mazro</td>
                                            <td class="">$12,000.00</td>
                                            <td class="">$0</td>
                                            <td>
                                              <div class="action-buttons center">
                                                <a class="pink" href="conciliarpagado.html">
                                                  <i class="icon-zoom-in bigger-130"></i>
                                                </a>
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
                          </div>
                        </div>
                      </div>
                    </div>
                  </div><!--/span-->
                </div>
              </div>
            </form>
          </div>          
          <!--PAGE CONTENT ENDS-->
        </div><!--/.span-->
      </div><!--/.row-fluid-->
  </div><!--/.page-content-->
</body>
</html>
