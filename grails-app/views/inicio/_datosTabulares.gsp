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
      <td>${d.usuario.perfil.nombre} ${d.usuario.perfil.apellidoPaterno} ${d.usuario.perfil.apellidoMaterno}</td>
      <td>${d.dependiente.perfil.nombre} ${d.dependiente.perfil.apellidoPaterno} ${d.dependiente.perfil.apellidoMaterno}</td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    </g:each>
  </tbody>
</table>
