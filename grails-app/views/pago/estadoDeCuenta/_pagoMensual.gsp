<table class="table">
   <caption>Movimientos a la fecha</caption>
   <thead style="background-color:whiteSmoke">
     <tr>
      <th>Mes</th>
      <th>Cargo</th>
      <th>Abono</th>
      <th>Detalle</th>
      <th>&nbsp;</th>
    </tr>     
   </thead>
    <g:each in="${pagosTiempo}" var="p">
      <tr class="info">
        <td>
          <g:formatDate format="MMMM" date="${p.lastUpdated}"/>
        </td>
        <td>
          <g:formatDate format="yyyy-MM-dd" date="${p.fechaDeVencimiento}"/>
        </td>
        <td>
          <g:formatNumber number="${p.cantidadDePago}" format="\$ ###,##0.00" locale="es_MX"/>
        </td>
        <td>
          <g:if test="${p.descuentoRealPorcentaje}" >
            <g:formatNumber number="${p.descuentoRealPorcentaje}" format="\$ ###,##0.00" locale="es_MX"/> ( ${p.sumaDescuentosPorcentaje} %)
          </g:if>
          <g:elseif test="${p.porcentajeEnBaseACantidad}" >
            <g:formatNumber number="${p.sumaDescuentosCantidad}" format="\$ ###,##0.00" locale="es_MX"/> ( ${p.porcentajeEnBaseACantidad} %)
          </g:elseif>
        </td>
        <td>
          <g:if test="${p.descuentoRealPorcentaje}" >
            <g:formatNumber number="${p.cantidadDePago - p.descuentoRealPorcentaje}" format="\$ ###,##0.00" locale="es_MX"/>  
          </g:if>  
          <g:elseif test="p.sumaDescuentosCantidad" >
            <g:formatNumber number="${p.cantidadDePago - p.sumaDescuentosCantidad}" format="\$ ###,##0.00" locale="es_MX"/>    
          </g:elseif>        
        </td>
        <td>
          &nbsp;
        </td>
      </tr>
    </g:each>
  </table>