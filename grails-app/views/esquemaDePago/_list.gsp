<%@ page import="com.payable.PaymentStatus" %>
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
        <td> ${it.paymentType} </td>
        <td>${(new Date() - it.lastUpdated)}</td>
        <td> ${it.paymentStatus} </td>
      </tr>
  </g:findAll>
  </tbody>
</table>
