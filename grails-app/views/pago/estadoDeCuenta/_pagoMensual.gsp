<table class="table">
   <caption>Movimientos a la fecha</caption>
   <thead style="background-color:whiteSmoke">
     <tr>
      <th>Mes</th>
      <th>Cargo</th>
      <th>Abono</th>
      <th>&nbsp;</th>
    </tr>     
   </thead>
    <g:each in="${pagosMensuales}" var="p">
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
          &nbsp;
        </td>
      </tr>
    </g:each>
  </table>