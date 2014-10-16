<input type="hidden" id="recargoId" name="recargoId" value="${recargo?.id}">
<g:if test="${recargo}">
<table class="table hidden">
  <thead>
    <tr>
      <th>Recargo</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
        <span>
          ${recargo.percentage ? "%" : "\$"} 
        </span>
          ${recargo.percentage ?: recargo.amount}
      </td>  
      <td style="width:10px;">
        <g:link class="deleteRecargo" controller="recargo" action="deleteRecargo" params="[id:recargo.id]">
          <i class="icon-trash bigger-130"></i>
        </g:link>
      </td>
    </tr>  
  </tbody>
</table>
</g:if>
<g:if test="${message}">
  <div class="alert alert-error">
    ${message}
  </div>
</g:if>
