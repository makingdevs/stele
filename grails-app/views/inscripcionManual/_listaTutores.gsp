<g:if test="${tutor}">
  <table class="table table-striped table-bordered table-hover">
    <tr>
      <th>
        Nombre Tutor
      </th>
      <th>
        Telefono
      </th>
      <th>
        E-mail
      </th>
      <th>
        &nbsp;&nbsp;&nbsp;
      </th>
    </tr>
      <tbody>
        <g:formRemote name="tutorCoincidentesForm" id="tutorCoincidentesForm" url="[action:'parsearTutor',controller:'inscripcionManual']" update="tutorPart">
          <g:each in="${tutor}">
            <tr>
              <td>${it.perfil.nombreCompleto()}</td>
              <td>${it.perfil.telefonos}</td>
              <td>${it.username}</td>
              <td>
                <label>
                  <g:checkBox id="idTutor" name="idTutor" value="${it.id}" checked="false" />
                  <span class="lbl"></span>
                </label>
              </td>
            </tr>
          </g:each>
        </g:formRemote>
      </tbody>
    </table>
    <input type="button" id="tutorForm" name="tutorForm" class="btn btn-small" value="Listo" >
</g:if>