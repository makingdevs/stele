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
              <th class="center">Detalle</th>
            </tr>
          </thead>
          <tbody>
            <g:each in="${pagosPorRealizar}">
              <tr>
              <td class="">${it.key.capitalize()}</td>
              <td class="">$ ${it.value*.cantidadDePago.sum()}</td>
              <td>
                <div class="action-buttons center">
                  <g:link controller="estadoDeCuenta" action="detalleEstadoDeCuentaMensual" params='[mes:"${it.key}", ids: "${it.value*.id}"]'>
                    <i class="icon-zoom-in bigger-130"></i>
                  </g:link>
                </div>
              </td>     
              </tr>
            </g:each>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div><!--/span--> 