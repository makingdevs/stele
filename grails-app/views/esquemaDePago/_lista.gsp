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
          <g:each in="${paymentSchemes}">
            <tr>
              <td>${it.concept.description}</td>
              <td>$ ${it.paymentAmount}</td>
              <td>${it.discounts*.discountName}</td>
              <td>$ <g:mostrarCantidadTotal idsDescuentos="${it.discounts*.id}" cantidadDePago="${it.paymentAmount}"></g:mostrarCantidadTotal> </td>
              <g:if test="${it.surcharge?.amount}">
                <td>$ ${it?.surcharge?.amount}</td>
              </g:if>
              <g:elseif test="${it.surcharge?.percentage}">
                <td>${it?.surcharge?.percentage}%</td> 
              </g:elseif>
              <g:elseif test="${!it.surcharge}">
                <td>$ 0</td>
              </g:elseif>
              <td>
                <g:link controller="esquemaDePago" action="eliminarEsquemaDePago" params="[id:it.id]">
                    <i class="icon-trash bigger-130"></i>
                </g:link>
              </td>            
            </tr>
          </g:each>
        </tbody>  
      </table>
    </div>
  </div>
</div>
