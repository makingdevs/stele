<%@ page import="com.payable.PaymentStatus" %>
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
       <g:findAll in="${pagos}" expr="it.paymentStatus == PaymentStatus.PAID">
        <tr class="success"> 
          <td align="justify"><g:link controller="comprobante" action="detalle" id="${it.id}" class="btn"> <i class="icon-zoom-in bigger-130"></i></g:link></td>
          <td><g:nombreDependiente idPago="${it.id}"></g:nombreDependiente></td>
          <td> ${it.paymentConcept} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.dueDate}"/> </td>
          <td> $ ${it.paymentAmount} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.paymentDate}"/> </td>
          <td> ${it.paymentStatus} </td>
          <td>&nbsp;</td>
        </tr>
      </g:findAll>
    </tbody>
  </table>
