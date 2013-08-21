<%@ page import="com.stele.EstatusDePago" %>
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
            <g:if test="${it.estatusDePago == EstatusDePago.CREADO }">
              <td> <g:link controller="reciboPago" id="${it.id}" class="btn"> <i class="icon-upload-alt"></i></g:link> </td>
            </g:if>
            <g:elseif test="${it.estatusDePago == EstatusDePago.PROCESO }">
              <td><g:link class="btn" controller="comprobante" action="show" id="${it.id}"><i class="icon-search"></i></g:link>
              <g:link class="btn"><i class="icon-ok"></i></g:link>
              <g:link class="btn"><i class="icon-remove"></i></g:link></td>
            </g:elseif>
            <g:elseif test="${it.estatusDePago == EstatusDePago.PAGADO }">
              <td><g:link controller="comprobante" action="show" id="${it.id}" class="btn"><i class="icon-search"></i></g:link></td>
            </g:elseif>
            <g:elseif test="${it.estatusDePago == EstatusDePago.RECHAZADO }">
              <td><g:link controller="reciboPago" id="${it.id}" class="btn"> <i class="icon-upload-alt"></i></g:link></td>
            </g:elseif>
            <g:elseif test="${it.estatusDePago == EstatusDePago.CANCELADO }">
            </g:elseif>
        </tr>
      </g:findAll>
    </tbody>
  </table>
  