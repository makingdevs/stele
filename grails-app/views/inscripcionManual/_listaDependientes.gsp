<g:if test="${dependientes}">
  <table class="table table-striped table-bordered table-hover">
    <tr>
      <th>
        Nombre Alumno
      </th>
      <th>
        Grado y Grupo 
      </th>
      <th>
        Matricula
      </th>
      <th>
        Turno
      </th>
      <th>
        &nbsp;&nbsp;&nbsp;
      </th>
    </tr>
      <tbody>
        <g:form name="dependientesCoincidentesForm" id="dependientesCoincidentesForm" url="[action:'parsearDependiente',controller:'inscripcionManual']" >
          <g:each in="${dependientes}">
            <tr>
              <td>${it.perfil.nombreCompleto()}</td>
              <td><g:ubicacionDependiente idDependiente="${it.id}"> </g:ubicacionDependiente></td>
              <td>${it.matricula}</td>
              <td><g:turnoDependiente idDependiente="${it.id}"></g:turnoDependiente></td>
              <td>
                <label>
                  <g:checkBox id="idDependiente" name="idDependiente" value="${it.id}" checked="false" />
                  <span class="lbl"></span>
                </label>
              </td>
            </tr>
          </g:each>
        </g:form>
      </tbody>
    </table>
    <input type="button" id="alumnosForm" class="btn btn-small" value="Listo" >
</g:if>