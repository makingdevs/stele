<%@ page import="com.payable.EstatusDePago" %>
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
       <g:findAll in="${pagos}" expr="it.estatusDePago == EstatusDePago.PAGADO  ">
        <tr class="success"> 
          <td align="justify"><g:link controller="comprobante" action="detalle" id="${it.id}" class="btn"> <i class="icon-zoom-in bigger-130"></i></g:link></td>
          <td><g:nombreDependiente idPago="${it.id}"></g:nombreDependiente></td>
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
