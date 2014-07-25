<input type="hidden" id="descuentos" name="descuentos" value="${descuentosIds}">
<g:if test="${descuentos}">
<table class="table table-striped table-bordered table-hover">
  <thead>
    <tr>
      <th>Nombre</th>
      <th>Descuento</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${descuentos?.sort({ it.id })}" var="descuento">
      <tr>
        <td>${descuento?.nombreDeDescuento}</td>
        <td><g:if test="${descuento?.cantidad}">
              <span class="add-on">$</span>${descuento?.cantidad}
            </g:if>
            <g:else>
              <span class="add-on">%</span>${descuento?.porcentaje}
            </g:else>
        </td>
      </tr>
    </g:each>    
  </tbody>
</table>
</g:if>