<%@ page import="com.payable.PaymentStatus" %>
  <table class="table table-striped table-bordered table-hover">
    <thead style="background-color:whiteSmoke">
      <tr>
        <th>Nombre</th>
        <th>Concepto de pago</th>
        <th>Vencimiento</th>
        <th>Cantidad</th>
        <th class="text-info">Recargo</th>
        <th class="text-info">Total</th>
        <th>Días sin conciliar</th>
        <th>&nbsp;</th>
      </tr>
    </thead>
    <tbody>
       <g:findAll in="${pagos}" expr="it.paymentStatus == PaymentStatus.EXPIRED">
        <tr>
          <td><g:nombreDependiente idPago="${it.id}"></g:nombreDependiente></td>
          <td> ${it.paymentConcept} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.dueDate}"/> </td>
          <td> $ ${it.paymentAmount} </td>
          <td> ${it.accumulatedSurcharges} </td>
          <td> ${it.paymentAmount + it.accumulatedSurcharges} </td>
          <td>${(new Date() - it.lastUpdated)}</td>
        </tr>
    </g:findAll>
    </tbody>
  </table>
