<%@ page import="com.payable.EstatusDePago" %>
  <table class="table table-striped table-bordered table-hover">
    <thead style="background-color:whiteSmoke">
      <tr>
        <th>&nbsp;</th>
        <th>Concepto de pago</th>
        <th>Vencimiento</th>
        <th>Cantidad</th>
        <th>Fecha de Rechazo</th>
        <th>Estatus</th>
      </tr>
    </thead>
    <tbody>
       <g:findAll in="${pagos}" expr="it.estatusDePago == EstatusDePago.RECHAZADO  ">
        <tr>
          <sec:ifAllGranted roles="ROLE_DIRECTOR">
            <td align="justify"><g:link controller="comprobante" action="detalle" id="${it.id}" class="btn"> <i class="icon-zoom-in bigger-130"></i></g:link></td>
          </sec:ifAllGranted>
          <sec:ifAllGranted roles="ROLE_PADRE_TUTOR">
            <td align="justify"><g:link controller="reciboPago" id="${it.id}" class="btn"> <i class="icon-upload-alt"></i></g:link></td>
          </sec:ifAllGranted>

          <td> ${it.conceptoDePago} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.fechaDeVencimiento}"/> </td>
          <td> $ ${it.cantidadDePago} </td>
          <td> <g:formatDate format="yyyy-MM-dd" date="${it.lastUpdated}"/> </td>
          <td> ${it.estatusDePago} </td>
        </tr>
    </g:findAll>
    </tbody>
  </table>