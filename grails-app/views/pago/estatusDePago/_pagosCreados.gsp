<%@ page import="com.payable.PaymentStatus" %>
<g:if test="${pagosCreados}">
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
      <g:each in="${pagosCreados}"> 
        <tr>
          <td><g:nombreDependiente idPago="${it.id}"></g:nombreDependiente></td>
          <td> ${it.paymentConcept} </td>
          <td> <g:formatDate format="dd/MM/yyyy" date="${it.dueDate}"/> </td>
          <td> $ ${it.paymentAmount} </td>
          <td> $ ${it.accumulatedDiscount ?: 0}</td>
          <td> $ ${it.accumulatedSurcharges ?: 0} </td>
          <td> $ ${it.paymentAmount - it.accumulatedDiscount}</td>
          <td> ${it.paymentStatus == PaymentStatus.CREATED ? 'Creado' :
                 it.paymentStatus == PaymentStatus.PROCESS ? 'Verificado' :
                 it.paymentStatus == PaymentStatus.EXPIRED ? 'Vencido' :
                 it.paymentStatus == PaymentStatus.PAID ? 'Pagado' :
                 it.paymentStatus == PaymentStatus.REJECTED ? 'Rechazado' :
                 it.paymentStatus == PaymentStatus.CANCELED ? 'Cancelado' : ''} </td>
            <sec:ifAllGranted roles="ROLE_PADRE_TUTOR">
              <g:if test="${it.paymentStatus == PaymentStatus.CREATED }">
                <td> <g:link controller="reciboPago" id="${it.id}" class="btn"> <i class="icon-upload-alt"></i></g:link> </td>
              </g:if>
            </sec:ifAllGranted>
        </tr>
      </g:each>
    </tbody>
  </table>
</g:if> 
