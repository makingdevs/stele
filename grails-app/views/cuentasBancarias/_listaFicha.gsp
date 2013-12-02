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
        <td>Bancomer</td>
        <td>1234567890</td>
        <td>Instituto Makingdevs SC</td>
        <td>Los 2 primeros digitos el numero de colegiaturo msmatricula del alumno ejemplo 03-123454</td>
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