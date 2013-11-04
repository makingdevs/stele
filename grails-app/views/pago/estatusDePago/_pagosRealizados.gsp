<%@ page import="com.payable.EstatusDePago" %>
  <table class="table table-striped table-bordered table-hover">
    <thead style="background-color:whiteSmoke">
      <tr>
        <th>Concepto de pago</th>
        <th>Vencimiento</th>
        <th>Cantidad</th>
        <th>Fecha de pago</th>
        <th>Estatus</th>
        <th>&nbsp;</th>
      </tr>
    </thead>
    <tbody>
       <g:findAll in="${pagos}" expr="it.estatusDePago == EstatusDePago.PAGADO  ">
        <tr class="success"> 
          <td> ${it.conceptoDePago} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.fechaDeVencimiento}"/> </td>
          <td> $ ${it.cantidadDePago} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.fechaDePago}"/> </td>
          <td> ${it.estatusDePago} </td>
          <td>&nbsp;</td>
        </tr>
      </g:findAll>
    </tbody>
  </table>
