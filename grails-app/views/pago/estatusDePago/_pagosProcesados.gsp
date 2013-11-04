<%@ page import="com.payable.EstatusDePago" %>
  <table class="table table-striped table-bordered table-hover">
    <thead style="background-color:whiteSmoke">
      <tr>
        <th>&nbsp;</th>
        <th>Concepto de pago</th>
        <th>Cantidad</th>
        <th>Vencimiento</th>
        <th>Días sin conciliar</th>
        <th>Estatus</th>
      </tr>
    </thead>
    <tbody>
   <g:findAll in="${pagos}" expr="it.estatusDePago == EstatusDePago.PROCESO  ">
        <tr class="info">
          <g:if test="${it.estatusDePago == EstatusDePago.PROCESO }">
            <td align="justify"><g:link class="btn" controller="comprobante" action="show" id="${it.id}"><i class="icon-file-text-alt bigger-130"></i></g:link>
          </g:if>  
          <td> ${it.conceptoDePago} </td>
          <td> $ ${it.cantidadDePago} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.fechaDeVencimiento}"/> </td>
          <td>${(new Date() - it.lastUpdated)}</td>
          <td> ${it.estatusDePago} </td>          
        </tr>
    </g:findAll>
    </tbody>
  </table>
