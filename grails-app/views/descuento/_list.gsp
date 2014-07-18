<input type="hidden" id="descuentos" name="descuentos" value="${descuentosIds}">
<g:each in="${descuentos?.sort({ it.id })}" var="descuento">
  <dl class="dl-horizontal">
    <dt>
      Nombre Descuento:  
    </dt>
    <dd>
      ${descuento?.nombreDeDescuento}
    </dd>
    <dt>
       Descuento: 
     </dt>
     <dd>
       <g:if test="${descuento?.cantidad}">
         ${"\$"+descuento?.cantidad}
       </g:if>
       <g:else>
         ${"%"+descuento?.porcentaje}
       </g:else>
    </dd>
  </dl>
</g:each>
