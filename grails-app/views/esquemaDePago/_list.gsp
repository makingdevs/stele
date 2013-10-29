<%@ page import="com.payable.EstatusDePago" %>
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
  <g:findAll in="${pagos}" expr="it.estatusDePago == EstatusDePago.CREADO  ">
      <tr>
        <td> ${it.conceptoDePago} </td>
        <td> $ ${it.cantidadDePago} </td>
        <td> <g:formatDate format="yyyy-MM-dd" date="${it.fechaDeVencimiento}"/> </td>
        <td> <g:formatDate format="yyyy-MM-dd" date="${it.fechaDePago}"/> </td>
        <td> ${it.tipoDePago} </td>
        <td>${(new Date() - it.lastUpdated)}</td>
        <td> ${it.estatusDePago} </td>
      </tr>
  </g:findAll>
  </tbody>
</table>