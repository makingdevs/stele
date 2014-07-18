<input type="hidden" id="descuentos" name="descuentos" value="${descuentosIds}">
<g:each in="${descuentos?.sort({ it.id })}" var="descuento">
  <dl class="dl-horizontal">
    <dt>
      Nombre:  
    </dt>
    <dd>
      ${descuento?.nombreDeDescuento}&nbsp;&nbsp;&nbsp;&nbsp;Descuento:
      <g:if test="${descuento?.cantidad}">
        <span class="add-on">$</span>${descuento?.cantidad}
      </g:if>
      <g:else>
        <span class="add-on">%</span>${descuento?.porcentaje}
      </g:else>
    </dd>
  </dl>
</g:each>
