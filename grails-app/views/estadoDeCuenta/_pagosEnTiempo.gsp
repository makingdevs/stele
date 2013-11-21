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
              <g:each in="${pagosEnTiempo}">
                <tr>
                  <td>${it.conceptoDePago}</td>
                  <td>01-Nov-2013</td>
                  <td>$ ${it.descuentoAplicable}</td>
                  <td>$ ${it.cantidadDePago - it.descuentoAplicable}</td>
                  <td>${it.fechaDeVencimiento.format('dd-MMM-yyyy')}</td>
                  <td>$ ${it.cantidadDePago}</td>      
                  <td width="70"><span class="label label-info arrowed-in">Pendiente</span></td>
                  <td class="center" width="140">
                    <g:link controller="reciboPago" id="${it.id}" class="btn btn-mini btn-purple">
                      Adjunte Comprobante
                    </g:link>
                  </td>
                </tr>
              </g:each>
              <g:each in="${pagosPorRealizar}">
                <tr>
                  <td>${it.conceptoDePago}</td>
                  <td>01-Nov-2013</td>
                  <td>$ ${it.descuentoAplicable}</td>
                  <td>$ ${it.cantidadDePago - it.descuentoAplicable}</td>
                  <td>${it.fechaDeVencimiento.format('dd-MMM-yyyy')}</td>
                  <td>$ ${it.cantidadDePago}</td>      
                  <td width="70"><span class="label label-info arrowed-in">Pendiente</span></td>
                  <td class="center" width="140"> 
                    <g:link controller="reciboPago" id="${it.id}" class="btn btn-mini btn-purple">Adjunte Comprobante</g:link>
                  </td>
                </tr>
              </g:each>
              <g:each in="${pagosProcesados}">
                <tr>
                  <td>${it.conceptoDePago}</td>
                  <td>01-Nov-2013</td>
                  <td>$ ${it.descuentoAplicable}</td>
                  <td>$ ${it.cantidadDePago - it.descuentoAplicable}</td>
                  <td>${it.fechaDeVencimiento.format('dd-MMM-yyyy')}</td>
                  <td>$ ${it.cantidadDePago}</td>      
                  <td width="70"><span class="label label-warning arrowed-in">Revision</span></td>
                  <td class="center" width="140"> 
                  </td>
                </tr>
              </g:each>
              <g:each in="${pagoCorrectos}">
                <tr>
                  <td>${it.conceptoDePago}</td>
                  <td>01-Nov-2013</td>
                  <td>$ ${it.descuentoAplicable}</td>
                  <td>$ ${it.cantidadDePago - it.descuentoAplicable}</td>
                  <td>${it.fechaDeVencimiento.format('dd-MMM-yyyy')}</td>
                  <td>$ ${it.cantidadDePago}</td>      
                  <td width="70"><span class="label label-success arrowed-in">Pagado</span></td>
                  <td class="center" width="140">
                  </td>
                </tr>
              </g:each>
            </tbody>  
          </table>
        </div>
      </div>
    </div>
  </div><!--/span-->
</div>