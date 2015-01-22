<%@ page import="com.payable.PaymentStatus" %>
<g:if test="${pagosEnProceso}">
  <table class="table table-striped table-bordered table-hover">
    <thead style="background-color:whiteSmoke">
      <tr>
        <th>&nbsp;</th>
        <th>Nombre </th>
        <th>Concepto de pago</th>
        <th>Cantidad</th>
        <th>Vencimiento</th>
        <th>Días sin conciliar</th>
        <th>Estatus</th>
      </tr>
    </thead>
    <tbody>
   <g:each in="${pagosEnProceso}" > 
        <tr class="info">
          <g:if test="${it.paymentStatus == PaymentStatus.PROCESS}">
            <td align="justify"><g:link class="btn" controller="comprobante" action="show" id="${it.id}"><i class="icon-file-text-alt bigger-130"></i></g:link>
          </g:if>  
          <td><g:nombreDependiente idPago="${it.id}"></g:nombreDependiente></td>
          <td> ${it.paymentConcept} </td>
          <td> $ ${it.paymentAmount} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.dueDate}"/> </td>
          <td>${(new Date() - it.lastUpdated)}</td>
          <td> ${it.paymentStatus == PaymentStatus.CREATED ? 'Creado' :
                 it.paymentStatus == PaymentStatus.PROCESS ? 'Verificado' :
                 it.paymentStatus == PaymentStatus.EXPIRED ? 'Vencido' :
                 it.paymentStatus == PaymentStatus.PAID ? 'Pagado' :
                 it.paymentStatus == PaymentStatus.REJECTED ? 'Rechazado' :
                 it.paymentStatus == PaymentStatus.CANCELED ? 'Cancelado' : ''} </td>          
        </tr>
    </g:each>
    </tbody>
  </table>
</g:if>
