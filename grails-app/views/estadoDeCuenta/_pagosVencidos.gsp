<div class="row-fluid">
  <div class="span12 widget-container-span">
    <div class="widget-box">
      <div class="widget-header widget-header-small header-color-red3">
        <h5 class="bigger lighter">
          <i class="icon-warning-sign"></i>
          Pagos Vencidos
        </h5> 
        <div class="widget-toolbar">              
        </div>
      </div>
      <div class="widget-body">
        <div class="widget-main no-padding">
          <table class="table table-striped table-bordered table-hover">
            <thead>
              <tr>
                <th>Concepto</th>
                <th>F. Vencido</th>
                <th>Debes</th>
                <th>Recargo</th>
                <th>Total</th>
                <th></th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <g:each in="${pagosVencido}">
                <tr>
                  <td class="">${it.conceptoDePago}</td>
                  <td class="">${it.fechaDeVencimiento.format('dd-MM-yyyy')}</td>
                  <td class="">$ ${it.cantidadDePago }</td>
                  <td class="">$ ${it.recargosAcumulados}</td>
                  <td class="">$ ${it.cantidadDePago + it.recargosAcumulados}</td>
                  <td width="70"><span class="label label-important arrowed-in">Vencidos</span></td>
                  <td class="center" width="140"> 
                    <g:if test="${!flash.ventanilla}">
                      <g:link controller="reciboPago" id="${it.id}" class="btn btn-mini btn-purple">
                        Adjunte Comprobante
                      </g:link>
                    </g:if>
                    <g:elseif test="${flash.ventanilla}">
                      <g:link controller="reciboPago" id="${it.id}" class="btn btn-minier btn-success">
                        Pagar
                      </g:link>
                    </g:elseif>
                  </td>
                </tr>
              </g:each>
              <g:each in="${pagosRechazados}">
                <tr>
                  <td class="">${it.conceptoDePago}</td>
                  <td class="">${it.fechaDeVencimiento.format('dd-MM-yyyy')}</td>
                  <td class="">$ ${it.cantidadDePago }</td>
                  <td class="">$ ${it.recargosAcumulados}</td>
                  <td class="">$ ${it.cantidadDePago + it.recargosAcumulados}</td>
                  <td width="70"><span class="label label-important arrowed-in">Rechazados</span></td>
                  <td class="center" width="140"> 
                    <g:if test="${!flash.ventanilla}">
                      <g:link controller="reciboPago" id="${it.id}" class="btn btn-mini btn-purple">
                        Adjunte Comprobante
                      </g:link>
                    </g:if>
                    <g:elseif test="${flash.ventanilla}">
                      <g:link controller="reciboPago" id="${it.id}" class="btn btn-minier btn-success">
                        Pagar
                      </g:link>
                    </g:elseif>
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