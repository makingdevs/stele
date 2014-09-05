<input type="hidden" id="recargoId" name="recargoid" value="${recargoId}">
<g:if test="${recargos}">
<table class="table table-bordered table-striped">
  <thead>
    <tr>
      <th>Recargo</th>
      <th></th>
    </tr>
  </thead>
    <g:each in="${recargos}" var="recargo">
      <tr>
        <td>
            <span>
              ${recargo.porcentaje ? "%" : "\$"} 
            </span>
            ${recargo.porcentaje ?: recargo.cantidad}
        </td>  
        <td>
        </td>
      </tr>
    </g:each>
  <tbody>
  </tbody>
</table>
</g:if>
