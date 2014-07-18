<input type="hidden" id="descuentos" name="descuentos" value="${descuentosIds}">
<g:each in="${descuentos?.sort({ it.id })}" var="descuento">
  <dl class="dl-horizontal">
    <dt>
      Nombre Descuento:  
    </dt>
    <dd>
      ${descuento?.nombreDeDescuento}
    </dd>
  </dl>
</g:each>