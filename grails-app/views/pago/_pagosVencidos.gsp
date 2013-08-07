<%@ page import="com.stele.EstatusDePago" %>
  <table class="table">
   <caption style="background-color:#FF6633">Pagos Pendientes hasta <font style="text-transform: capitalize;">${ new Date().format('MMMM')} </font> </caption>
   <thead style="background-color:#FF6633">
     <tr>
      <th>Concepto</th>
      <th>Fecha Limite</th>
      <th>Debes</th>
      <th>Recargos</th>
      <th>Total</th>
      <th>&nbsp;</th>
    </tr>     
   </thead>
    <g:each in="${pagos}" var="p">
      <tr class="info">
        <td>
          ${p.conceptoDePago}
        </td>
        <td id="inputError">
          <span style="color: Red;">
            <g:formatDate format="yyyy-MM-dd" date="${p.fechaDeVencimiento}"/>
          </span>
        </td>
        <td>
          <g:formatNumber number="${p.cantidadDePago}" format="\$ ###,##0.00" locale="es_MX"/>
        </td>
        <td>
          <g:if test="${p.recargos?.first()?.cantidad}">
            <g:formatNumber number="${p.recargos?.first()?.cantidad}" format="\$ ###,##0.00" locale="es_MX"/>
          </g:if>
          <g:elseif test="${p.recargos?.first()?.porcentaje}">
            <g:formatNumber number="${(p.recargos?.first()?.porcentaje / 100) * p.cantidadDePago}" format="\$ ###,##0.00" locale="es_MX"/>
          </g:elseif>
        </td>
        <td>
          <g:if test="${p.recargos?.first()?.cantidad}">
            <g:formatNumber number="${ p.cantidadDePago + p.recargos?.first()?.cantidad }" format="\$ ###,##0.00" locale="es_MX"/>
          </g:if>
          <g:elseif test="${p.recargos?.first()?.porcentaje}">
            <g:formatNumber number="${ p.cantidadDePago + ((p.recargos?.first()?.porcentaje / 100) * p.cantidadDePago) }" format="\$ ###,##0.00" locale="es_MX"/>
          </g:elseif>
        </td>
        <td>
          &nbsp;
        </td>
      </tr>
    </g:each>
  </table>