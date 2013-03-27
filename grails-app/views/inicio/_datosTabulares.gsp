<table>
  <thead>
    <tr>
      <th>#</th>
      <th>Nombre del padre/tutor</th>
      <th>Nombre del estudiante</th>
      <th>Nivel</th>
      <th>Grado</th>
      <th>Grupo</th>
      <th>Turno</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${listaDeMapaDeDominios}" var="d" status="i">
    <tr>
      <td>${i+1}</td>
      <td>${d.usuario.nombre} ${d.usuario.apellidoPaterno} ${d.usuario.apellidoMaterno}</td>
      <td>${d.dependiente.nombre} ${d.dependiente.apellidoPaterno} ${d.dependiente.apellidoMaterno}</td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    </g:each>
  </tbody>
</table>
