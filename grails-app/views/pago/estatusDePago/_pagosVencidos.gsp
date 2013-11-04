<%@ page import="com.payable.EstatusDePago" %>
  <table class="table table-striped table-bordered table-hover">
    <thead style="background-color:whiteSmoke">
      <tr>
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
          <td> ${it.conceptoDePago} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.fechaDeVencimiento}"/> </td>
          <td> $ ${it.cantidadDePago} </td>
          <td> ${it.recargosAcumulados} </td>
          <td> ${it.cantidadDePago + it.recargosAcumulados} </td>
          <td>${(new Date() - it.lastUpdated)}</td>
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
