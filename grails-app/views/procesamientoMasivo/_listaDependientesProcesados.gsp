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
    <g:each in="${listaDeMapaDeDominios}" var="dependiente" status="i">
    <tr>
      <td>${i+1}</td>
      <td>${dependiente.usuario.perfil.nombre} ${dependiente.usuario.perfil.apellidoPaterno} ${dependiente.usuario.perfil.apellidoMaterno}</td>
      <td>${dependiente.matricula}</td>
      <td>${dependiente.perfil.nombre} ${dependiente.perfil.apellidoPaterno} ${dependiente.perfil.apellidoMaterno}</td>
      <td>${dependiente.historialAcademico.distribucionInstitucional.nivelDeEstudio[0]}</td>
      <td>${dependiente.historialAcademico.distribucionInstitucional.grado[0]}</td>
      <td>${dependiente.historialAcademico.distribucionInstitucional.grupo[0]}</td>
      <td>${dependiente.historialAcademico.distribucionInstitucional.turno[0]}</td>
    </tr>
    </g:each>
  </tbody>
</table>
