<table class="table table-condensed table-striped">
  <thead>
    <tr>
      <th>#</th>
      <th>Matrícula</th>
      <th>Nombre del alumno</th>
      <th>Correo del padre / tutor</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${dependientes}" var="d" status="i">
      <tr>
        <td>${i+1}</td>
        <td>${d.matricula}</td>
        <td>
          ${d.perfil.apellidoPaterno} ${d.perfil.apellidoMaterno} ${d.perfil.nombre}
        </td>
        <td>
          ${d.usuario.username}
        </td>
      </tr>
    </g:each>
  </tbody>
</table>
