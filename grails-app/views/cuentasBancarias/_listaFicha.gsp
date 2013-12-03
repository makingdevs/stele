<table id="sample-table-1" class="table table-striped table-bordered table-hover">
  <thead >
    <tr>
      <th>Banco</th>
      <th>Cuenta</th>
      <th>Beneficiario</th>
      <th>Referencia</th>   
      <th></tr>
  </thead>
  <tbody>
  <g:each in="${ficha}" >
      <tr>
        <td>${it.nombreDeBanco}</td>
        <td>${it.numeroDeCuenta}</td>
        <td>${it.beneficiario}</td>
        <td>${it.referencia}</td>
        <td >
          <div class="action-buttons center">
            <g:remoteLink id="${it.id}" class="danger" controller="cuentasBancarias" action="borrarCuentaFicha" update="listaFicha">
              <i class="icon-trash bigger-130"></i>
            </g:remoteLink>
          </div>
        </td>
      </tr>             
    </g:each>
  </tbody>
</table>