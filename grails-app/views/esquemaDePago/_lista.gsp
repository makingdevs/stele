<div class="span7 widget-container-span">
  <div class="widget-box">
    <div class="widget-header widget-header-small header-color-blue">
      <h5 class="bigger lighter">
        <i class="icon-money"></i>
        Cobros
      </h5> 
    </div>
    <div class="widget-body">
      <div class="widget-main no-padding">
        <table class="table table-striped table-bordered table-hover">
          <thead>
            <tr>
              <th class="blue">Concepto</th>
              <th class="blue">Importe</th>
              <th class="pink">
                Descuento
              </th>
              <th class="pink">
                Importe
              </th>
              <th class="orange">Recargo</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <g:each in="${esquemasDePagos}">
              <tr>
                <td>${it.concepto.descripcion}</td>
                <td>$ ${it.cantidadDePago}/td>
                <td>${it.descuentos*.nombreDeDescuento}</td>
                <g:if test="${it.descuentos.first().cantidad}">
                  <td>$ ${it.descuentos*.cantidad.sum()}</td>
                </g:if>
                <g:elseif test="${it.descuentos.first().porcentaje}" >
                  <td>${it.descuentos*.porcentaje.sum()} %</td>
                </g:elseif>
                <g:if test="${it.recargo?.cantidad}">
                  <td>$ ${it.recargo.cantidad}</td>
                </g:if>
                <g:elseif test="${it.recargo?.porcentaje}">
                  <td>${it.recargo.porcentaje}%</td> 
                </g:elseif>
                <g:elseif test="${!it.recargo}">
                  <td>$ 0</td>
                </g:elseif>
                <td >
                  <div class="action-buttons center">
                    <a class="red" href="#">
                      <i class="icon-trash bigger-130"></i>
                    </a>
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