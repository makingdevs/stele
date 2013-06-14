<table width="100%" class="table table-condensed table-hover table-striped">
  <thead>
    <tr>
      <th>#</th>
      <th>Nombre del padre/tutor</th>
      <th>Matrícula</th>
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
      <td>Matricula</td>
      <td>${d.dependiente.perfil.nombre} ${d.dependiente.perfil.apellidoPaterno} ${d.dependiente.perfil.apellidoMaterno}</td>
      <td>${d.distribucionInstitucional.nivelDeEstudio}</td>
      <td>${d.distribucionInstitucional.grado}</td>
      <td>${d.distribucionInstitucional.grupo}</td>
      <td>${d.distribucionInstitucional.turno}</td>
    </tr>
    </g:each>
  </tbody>
</table>
