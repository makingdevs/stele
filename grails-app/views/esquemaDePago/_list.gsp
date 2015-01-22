<%@ page import="com.payable.PaymentStatus" %>
<%@ page import="com.payable.PaymentType" %>
<table class="table">
  <thead style="background-color:whiteSmoke">
    <tr>
      <th>Concepto de pago</th>
      <th>Cantidad</th>
      <th>Vencimiento</th>
      <th>Fecha de pago</th>
      <th>Tipo de pago</th>
      <th>Días sin conciliar</th>
      <th>Estatus</th>
      <th>&nbsp;</th>
    </tr>
  </thead>
  <tbody>
  <g:findAll in="${pagos}" expr="it.paymentStatus == PaymentStatus.CREATED || it.paymentStatus == PaymentStatus.EXPIRED">
      <tr>
        <td> ${it.paymentConcept} </td>
        <td> $ ${it.paymentAmount} </td>
        <td> <g:formatDate format="yyyy-MM-dd" date="${it.dueDate}"/> </td>
        <td> <g:formatDate format="yyyy-MM-dd" date="${it.paymentDate}"/> </td>
        <td> ${it.paymentType == PaymentType.WIRE_TRANSFER ? 'Transferencia Bancaria' : 
			it.paymentType == PaymentType.REFERENCED_DEPOSIT ? 'Pago Referenciado' : 
            it.paymentType == PaymentType.CHECK ? 'Cheque' : 
            it.paymentType == PaymentType.CASH ? 'Efectivo' : 
            it.paymentType == PaymentType.TERMINAL ? 'Terminal' : ''} </td>
        <td>${(new Date() - it.lastUpdated)}</td>
        <td> ${it.paymentStatus == PaymentStatus.CREATED ? 'Creado' : 'Vencido'} </td>
      </tr>
  </g:findAll>
  </tbody>
</table>
