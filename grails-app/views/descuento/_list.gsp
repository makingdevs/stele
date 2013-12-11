<input type="hidden" id="descuentos" name="descuentos" value="${descuentosIds}">
<g:each in="${descuentos?.sort({ it.id })}" var="descuento">
  <dl class="dl-horizontal">
    <dt>
      Nombre Descuento : 
    </dt>
    <dd>
      <input type="text" class="descuento" value="${descuento?.nombreDeDescuento}" readonly>
    </dd>
  </dl>
</g:each>