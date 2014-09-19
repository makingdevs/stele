<%@ page import="com.payable.PaymentStatus" %>
  <table class="table table-striped table-bordered table-hover">
    <thead style="background-color:whiteSmoke">
      <tr>
        <th>Nombre</th>
        <th>Concepto de pago</th>
        <th>Vencimiento</th>
        <th>Monto</th>
        <th>Descuento</th>
        <th>Recargo</th>
        <th>Total</th>
        <th>Estatus</th>
      </tr>
    </thead>
    <tbody>
      <g:findAll in="${pagos}" expr="it.paymentStatus == PaymentStatus.CREATED  ">
        <tr>
          <td><g:nombreDependiente idPago="${it.id}"></g:nombreDependiente></td>
          <td> ${it.paymentConcept} </td>
          <td> <g:formatDate format="dd/MM/yyyy" date="${it.dueDate}"/> </td>
          <td> $ ${it.paymentAmount} </td>
          <td> $ ${it.accumulatedDiscount ?: 0}</td>
          <td> $ ${it.accumulatedSurcharges ?: 0} </td>
          <td> $ ${it.paymentAmount - it.accumulatedDiscount}</td>
          <td> ${it.paymentStatus} </td>
            <sec:ifAllGranted roles="ROLE_PADRE_TUTOR">
              <g:if test="${it.paymentStatus == PaymentStatus.CREATED }">
                <td> <g:link controller="reciboPago" id="${it.id}" class="btn"> <i class="icon-upload-alt"></i></g:link> </td>
              </g:if>
            </sec:ifAllGranted>
        </tr>
      </g:findAll>
    </tbody>
  </table>
  
