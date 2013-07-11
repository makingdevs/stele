<table class="table">
  <thead style="background-color:whiteSmoke">
    <tr>
      <th>Concepto de pago</th>
      <th>Cantidad</th>
      <th>Vencimiento</th>
      <th>Fecha de pago</th>
      <th>Tipo de pago</th>
      <th>Estatus</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${pagos}" var="p">
      <tr>
        <td> ${p.conceptoDePago} </td>
        <td> $ ${p.cantidadDePago} </td>
        <td> <g:formatDate format="yyyy-MM-dd" date="${p.fechaDePago}"/> </td>
        <td> <g:formatDate format="yyyy-MM-dd" date="${p.fechaDeVencimiento}"/> </td>
        <td> ${p.tipoDePago} </td>
        <td> ${p.estatusDePago} </td>
      </tr>
    </g:each>
  </tbody>
</table>