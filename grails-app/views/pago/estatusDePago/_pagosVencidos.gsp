<%@ page import="com.payable.EstatusDePago" %>
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
       <g:findAll in="${pagos}" expr="it.estatusDePago == EstatusDePago.VENCIDO  ">
        <tr>
          <td><g:nombreDependiente idPago="${it.id}"></g:nombreDependiente></td>
          <td> ${it.conceptoDePago} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.fechaDeVencimiento}"/> </td>
          <td> $ ${it.cantidadDePago} </td>
          <td> ${it.recargosAcumulados} </td>
          <td> ${it.cantidadDePago + it.recargosAcumulados} </td>
          <td>${(new Date() - it.lastUpdated)}</td>
        </tr>
    </g:findAll>
    </tbody>
  </table>
