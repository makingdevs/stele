<%@ page import="com.payable.PaymentStatus" %>
<g:if test="${pagosRechazados}">
  <table class="table table-striped table-bordered table-hover">
    <thead style="background-color:whiteSmoke">
      <tr>
        <th>&nbsp;</th>
        <th>Nombre</th>
        <th>Concepto de pago</th>
        <th>Vencimiento</th>
        <th>Cantidad</th>
        <th>Fecha de Rechazo</th>
        <th>Estatus</th>
      </tr>
    </thead>
    <tbody>
      <g:each in="${pagosRechazados}"> 
        <tr>
          <sec:ifAllGranted roles="ROLE_DIRECTOR">
            <td align="justify"><g:link controller="comprobante" action="detalle" id="${it.id}" class="btn"> <i class="icon-zoom-in bigger-130"></i></g:link></td>
          </sec:ifAllGranted>
          <sec:ifAllGranted roles="ROLE_PADRE_TUTOR">
            <td align="justify"><g:link controller="reciboPago" id="${it.id}" class="btn"> <i class="icon-upload-alt"></i></g:link></td>
          </sec:ifAllGranted>
          <td><g:nombreDependiente idPago="${it.id}"></g:nombreDependiente></td>
          <td> ${it.paymentConcept} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.dueDate}"/> </td>
          <td> $ ${it.paymentAmount} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.lastUpdated}"/> </td>
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
