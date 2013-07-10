<table class="table table-bordered table-condensed">
  <thead style="background-color:whiteSmoke">
    <tr>
      <th>Concepto de pago</th>
      <th>Cantidad</th>
      <th>Fecha de pago</th>
      <th>Fecha de vencimeinto</th>
      <th>Tipo de pago</th>
      <th>Estatus</th>
      <th>&nbsp;</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${pagos}" var="p">
      <tr>
        <td> ${p.conceptoDePago} </td>
        <td> ${p.cantidadDePago} </td>
        <td> <g:formatDate format="yyyy-MM-dd" date="${p.fechaDePago}"/> </td>
        <td> <g:formatDate format="yyyy-MM-dd" date="${p.fechaDeVencimiento}"/> </td>
        <td> ${p.tipoDePago} </td>
        <td> ${p.estatusDePago} </td>
        <td> <g:link controller="reciboPago" id="${p.id}"> subir pago </g:link> </td>
      </tr>
    </g:each>
  </tbody>
</table>