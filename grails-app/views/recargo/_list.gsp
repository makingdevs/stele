<input type="hidden" id="recargoid" name="recargoid" value="${recargoId}">
<g:each in="${recargos}" var="recargo">
  <dl class="dl-horizontal">
    <g:if test="${recargo.porcentaje}">
      <dt>
        Recargo <span class="add-on">%</span>: 
      </dt>
      <dd>
        ${recargo.porcentaje}       
      </dd>
    </g:if>
    <g:elseif test="${recargo.cantidad}">
       <dt>
        Recargo <span class="add-on">$<span>: 
      </dt>
      <dd>
        ${recargo.cantidad}
      </dd>
    </g:elseif>
  </dl>
</g:each>
