<g:if test="${descuentos}">
<table class="table table-striped table-bordered table-hover">
  <thead>
    <tr>
      <th>Nombre</th>
      <th>Descuento</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${descuentos?.sort({ it.id })}" var="descuento" status="i">
      <tr>
        <td>
          <input type="hidden" name="descuento" value="${descuento?.id}" />  
          ${descuento?.nombreDeDescuento}</td>
        <td><g:if test="${descuento?.cantidad}">
              <g:formatNumber number="${descuento?.cantidad}" type="currency" />
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
