<div class="row-fluid">
  <div class="span12 widget-container-span">
    <div class="widget-box">
      <div class="widget-header widget-header-small header-color-red3">
        <h5 class="bigger lighter">
          <i class="icon-warning-sign"></i>
          Pagos Vencidos
        </h5> 
        <div class="widget-toolbar">
          <i class="icon-usd"></i>                  
          <strong> cantidad total </strong>                  
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
              <g:each in="${pagoVencido}">
                <tr>
                  <td class="">${it.conceptoDePago}</td>
                  <td class="">${it.fechaDeVencimiento}</td>
                  <td class="">$ ${it.cangtidadDePago }</td>
                  <td class="">$ ${it.recargosAcumulados}</td>
                  <td class="">$ ${it.cantidadDePago + it.recargosAcumulados}</td>
                  <td width="70"><span class="label label-important arrowed-in">Vencidos</span></td>
                  <td class="center" width="140"> 
                    <button class="btn btn-mini btn-purple">Adjunte comprobante...</button>
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