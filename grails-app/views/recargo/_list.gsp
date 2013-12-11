<input type="hidden" id="recargoid" name="recargoid" value="${recargoId}">
<g:each in="${recargos}" var="recargo">
  <dl class="dl-horizontal">
    <g:if test="${recargo.porcentaje}">
      <dt>
        Porcentaje : 
      </dt>
      <dd>
        ${recargo.porcentaje} <span class="add-on">%</span>
      </dd>
    </g:if>
    <g:elseif test="${recargo.cantidad}">
       <dt>
        Cantidad : 
      </dt>
      <dd>
      <input id="recargoCantidad" name="recargoCantidad" readonly value="${recargo.cantidad}">
      </dd>
    </g:elseif>
  </dl>
</g:each>