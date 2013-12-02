<table id="sample-table-1" class="table table-striped table-bordered table-hover">
  <thead >
    <tr>
      <th>Banco</th>
      <th>Cuenta</th>
      <th>Beneficiario</th>
      <th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${cheque}" >
      <tr>
        <td>${it.nombreDeBanco}</td>
        <td>${it.numeroDeCuenta}</td>
        <td>${it.beneficiario}</td>
        <td >
          <div class="action-buttons center">
            <a class="red" href="#">
              <i class="icon-trash bigger-130"></i>
            </a>
          </div>
        </td>
      </tr>
    </g:each>
  </tbody>
</table>