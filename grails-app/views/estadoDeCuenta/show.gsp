<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="colegio"/>
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
                <div class="span12 widget-container-span">
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
                                <table class="table table-striped table-bordered table-hover">
                                  <thead>
                                    <tr>
                                      <th class="center">Banco</th>
                                      <th class="center">Numero de Cuenta</th>
                                      <th class="center">Beneficiario</th>
                                      <th class="center">CLABE</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <g:each in="${electronica}">
                                      <tr>
                                        <td class="center">${it.nombreDeBanco}</td>
                                        <td class="center">${it.numeroDeCuenta}</td>
                                        <td class="center">${it.beneficiario}</td>
                                        <td class="center">${it.cuentaInterbancaria}</td>
                                      </tr>
                                    </g:each>
                                  </tbody>
                                </table>
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
                                <table class="table table-striped table-bordered table-hover">
                                  <thead>
                                    <tr>
                                      <th class="center">Banco</th>
                                      <th class="center">Numero de Cuenta</th>
                                      <th class="center">Beneficiario</th>
                                      <th class="center">Referencia</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <g:each in="${ficha}">
                                      <tr>
                                        <td class="center">${it.nombreDeBanco}</td>
                                        <td class="center">${it.numeroDeCuenta}</td>
                                        <td class="center">${it.beneficiario}</td>  
                                        <td class="center">${it.referencia}</td>
                                      </tr>
                                    </g:each>
                                  </tbody>
                                </table>
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
                                <table class="table table-striped table-bordered table-hover">
                                  <thead>
                                    <tr>
                                      <th class="center">Banco</th>
                                      <th class="center">Numero de Cuenta</th>
                                      <th class="center">Beneficiario</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <g:each in="${ficha}">
                                      <tr>
                                        <td class="center">${it.nombreDeBanco}</td>
                                        <td class="center">${it.numeroDeCuenta}</td>
                                        <td class="center">${it.beneficiario}</td>
                                      </tr>
                                    </g:each>
                                  </tbody>
                                </table>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>          
                <g:render template="pagosVencidos" modal="['pagoVencido':pagosVencido, 'pagoRechazo': pagosRechazados]" />
                <g:render template="pagosEnTiempo" modal="[pagoTiempo:pagosEnTiempo, pagoRealizar:pagosPorRealizar,pagoValidandon:pagosProcesados,pagosConciliados:pagoCorrectos]" />
                <div class="row-fluid">
                  <div class="span12 widget-container-span">
                    <div class="widget-box">
                      <div class="widget-header widget-header-small header-color-blue3 center">
                        <h5 class="bigger lighter">
                          <i class="icon-table"></i>
                          <strong> Estado de cuenta </strong>
                        </h5> 
                        <!--div class="widget-toolbar">
                          <button class="btn btn-success btn-small">
                            <i class="icon-cloud-download "></i>
                            Excel
                          </button>
                          <button class="btn  btn-danger  btn-small">
                            <i class="icon-cloud-download "></i>
                            PDF
                          </button>

                        </div-->
                      </div>

                      <div class="widget-body">
                        <div class="widget-main no-padding">
                          <div class="row-fluid"> 
                            <div class="span12">              
                              <g:render template="pagoMensual" modal="['pagoMensual':pagoMensual]" />
                              <g:render template="pagosPorRealizar" modal="['pagosPorRealizar':pagosPorRealizar]" />
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
