<table class="table table-bordered table-condensed">
  <thead style="background-color:whiteSmoke">
    <tr>
      <th>Concepto</th>
      <th>Cantidad</th>
      <th>Fecha de pago</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${pagos}" var="p">
      <tr>
        <td> ${p.conceptoDePago} </td>
        <td> ${p.cantidadDePago} </td>
        <td> ${p.fechaDePago} </td>
      </tr>
    </g:each>
  </tbody>
</table>