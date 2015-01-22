<%@ page import="com.payable.PaymentStatus" %>
<g:if test="${pagosConciliados}">
  <table class="table table-striped table-bordered table-hover">
    <thead style="background-color:whiteSmoke">
      <tr>
        <th>&nbsp;</th>
        <th>Nombre</th>
        <th>Concepto de pago</th>
        <th>Vencimiento</th>
        <th>Cantidad</th>
        <th>Fecha de pago</th>
        <th>Estatus</th>
      </tr>
    </thead>
    <tbody>
       <g:each in="${pagosConciliados}"> 
        <tr class="success"> 
          <td align="justify"><g:link controller="comprobante" action="detalle" id="${it.id}" class="btn"> <i class="icon-zoom-in bigger-130"></i></g:link></td>
          <td><g:nombreDependiente idPago="${it.id}"></g:nombreDependiente></td>
          <td> ${it.paymentConcept} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.dueDate}"/> </td>
          <td> $ ${it.paymentAmount} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.paymentDate}"/> </td>
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
