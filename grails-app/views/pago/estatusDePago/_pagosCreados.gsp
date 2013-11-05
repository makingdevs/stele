<%@ page import="com.payable.EstatusDePago" %>
  <table class="table table-striped table-bordered table-hover">
    <thead style="background-color:whiteSmoke">
      <tr>
        <th>Nombre</th>
        <th>Concepto de pago</th>
        <th>Vencimiento</th>
        <th>Monto</th>
        <th>Descuento</th>
        <th>Recargo</th>
        <th>Total</th>
        <th>Estatus</th>
      </tr>
    </thead>
    <tbody>
      <g:findAll in="${pagos}" expr="it.estatusDePago == EstatusDePago.CREADO  ">
        <tr>
          <td><g:nombreDependiente idPago="${it.id}"></g:nombreDependiente></td>
          <td> ${it.conceptoDePago} </td>
          <td> <g:formatDate format="dd/MM/yyyy" date="${it.fechaDeVencimiento}"/> </td>
          <td> $ ${it.cantidadDePago} </td>
          <td> $ ${it.descuentoAplicable ?: 0}</td>
          <td> $ ${it.recargosAcumulados ?: 0} </td>
          <td> $ ${it.cantidadDePago - it.descuentoAplicable}</td>
          <td> ${it.estatusDePago} </td>
            <sec:ifAllGranted roles="ROLE_PADRE_TUTOR">
              <g:if test="${it.estatusDePago == EstatusDePago.CREADO }">
                <td> <g:link controller="reciboPago" id="${it.id}" class="btn"> <i class="icon-upload-alt"></i></g:link> </td>
              </g:if>
            </sec:ifAllGranted>
        </tr>
      </g:findAll>
    </tbody>
  </table>
  