<input type="hidden" id="descuentosIds" value="${descuentosIds}">
<g:each in="${descuentos?.sort({ it.id })}" var="descuento">
  <dl class="dl-horizontal">
    <dt>
      Nombre Descuento : 
    </dt>
    <dd>
      ${descuento?.nombreDeDescuento}  <button><i class="icon-remove-sign icon-large"></i></button>
    </dd>
    <dt>
      Fecha Vencimiento : 
    </dt>
    <dd>
      ${descuento?.fechaDeVencimiento.format('yyyy-MM-dd')}  
    </dd>
  </dl>
</g:each>