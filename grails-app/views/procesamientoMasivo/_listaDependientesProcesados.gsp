<table width="100%" class="table table-condensed table-hover table-striped">
  <thead>
    <tr>
      <th>#</th>
      <th>Nombre del padre/tutor</th>
      <th>Matrícula</th>
      <th>Nombre del estudiante</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${listaDeMapaDeDominios}" var="dependiente" status="i">
    <tr>
      <td>${i+1}</td>
      <td>${dependiente.usuario.perfil.nombre} ${dependiente.usuario.perfil.apellidoPaterno} ${dependiente.usuario.perfil.apellidoMaterno}</td>
      <td>${dependiente.matricula}</td>
      <td>${dependiente.perfil.nombre} ${dependiente.perfil.apellidoPaterno} ${dependiente.perfil.apellidoMaterno}</td>
    </tr>
    </g:each>
  </tbody>
</table>
