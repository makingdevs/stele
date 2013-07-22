<%@ page import="com.stele.EstatusDePago" %>
<table class="table">
  <thead style="background-color:whiteSmoke">
    <tr>
      <th>Concepto de pago</th>
      <th>Cantidad</th>
      <th>Vencimiento</th>
      <th>Fecha de pago</th>
      <th>Tipo de pago</th>
      <th>Estatus</th>
      <th>&nbsp;</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${pagos}" var="p">
      <tr>
        <td> ${p.conceptoDePago} </td>
        <td> $ ${p.cantidadDePago} </td>
        <td> <g:formatDate format="yyyy-MM-dd" date="${p.fechaDeVencimiento}"/> </td>
        <td> <g:formatDate format="yyyy-MM-dd" date="${p.fechaDePago}"/> </td>
        <td> ${p.tipoDePago} </td>
        <td> ${p.estatusDePago} </td>
          <g:if test="${p.estatusDePago == EstatusDePago.CREADO }">
            <td> <g:link controller="reciboPago" id="${p.id}" class="btn"> <i class="icon-upload-alt"></i></g:link> </td>
          </g:if>
          <g:elseif test="${p.estatusDePago == EstatusDePago.PROCESO }">
            <td><g:link class="btn" controller="comprobante" action="show" id="${p.id}"><i class="icon-search"></i></g:link>
            <g:link class="btn"><i class="icon-ok"></i></g:link>
            <g:link class="btn"><i class="icon-remove"></i></g:link></td>
          </g:elseif>
          <g:elseif test="${p.estatusDePago == EstatusDePago.PAGADO }">
            <td><g:link class="btn"><i class="icon-search"></i></g:link></td>
          </g:elseif>
          <g:elseif test="${p.estatusDePago == EstatusDePago.RECHAZADO }">
            <td><g:link class="btn"><i class="icon-upload-alt"></i></g:link></td>
          </g:elseif>
          <g:elseif test="${p.estatusDePago == EstatusDePago.CANCELADO }">
          </g:elseif>

      </tr>
    </g:each>
  </tbody>
</table>