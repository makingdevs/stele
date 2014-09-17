<g:if test="${discounts}">
<table class="table table-striped table-bordered table-hover">
  <thead>
    <tr>
      <th>Nombre</th>
      <th>Descuento</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${discounts?.sort({ it.id })}" var="discount" status="i">
      <tr>
        <td>
          <input type="hidden" name="discount" value="${discount?.id}" />  
          ${discount?.discountName}</td>
        <td><g:if test="${discount?.amount}">
              <g:formatNumber number="${discount?.amount}" type="currency" />
            </g:if>
            <g:else>
              <span class="add-on">%</span>${discount?.percentage}
            </g:else>
        </td>
      </tr>
    </g:each>    
  </tbody>
</table>
</g:if>
