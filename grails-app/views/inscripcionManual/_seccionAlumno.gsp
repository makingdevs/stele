<%@ page import="com.stele.CicloEscolar" %>
<%@ page import="com.stele.NivelDeEstudio" %>

<h3 class="header smaller lighter orange">
  Alumno
  <small> >>Datos del Alumno</small>
</h3>
<div class="control-group">
  <label class="control-label" for="txtNombreAlumno">Alumno</label>
  <div class="controls">
    <span class="input-icon">
      <input type="text" id="nombreAlumno" name="nombreAlumno" placeholder="nombre" value="${action?.dependiente?.perfil?.nombre}" />
    </span>
    <span class="input-icon">
      <input type="text" id="apellidoPaternoAlumno" name="apellidoPaternoAlumno" placeholder="apellido paterno" value="${action?.dependiente?.perfil?.apellidoPaterno}" />
    </span>
    <span class="input-icon">
      <input type="text" id="apellidoMaternoAlumno" name="apellidoMaternoAlumno" placeholder="apellido materno" value="${action?.dependiente?.perfil?.apellidoMaterno}" />
    </span>
  </div>
</div>
<div class="control-group">
  <label class="control-label" for="selectCiclo">Ciclo escolar</label>
  <div class="controls">
  <select>
    <option value="2013/2014">2013/2014</option>
    <option value="2014/2015">2014/2015</option>
  </select>
  </div>
</div>
    <table class="table table-condensed" border="0"  cellpadding="0" cellspacing="0">
      <td>
        <div class="control-group">
          <div class="controls">
            <label>Ubicación académica</label>
            <g:if test="${action?.distribucionInstitucional?.nivelDeEstudio}">
              <g:select id="nivelDeEstudio" name="nivelDeEstudio" from="${NivelDeEstudio.values()}" value="${action?.distribucionInstitucional?.nivelDeEstudio.key}" optionKey="key" />
            </g:if>
            <g:else>
              <g:select id="nivelDeEstudio" name="nivelDeEstudio" from="${NivelDeEstudio.values()}" noSelection="['':'-Nivel-']" optionKey="key" />
            </g:else>
          </div>
        </div>
      </td>
      <td>
        <div class="control-group">
          <div class="controls">
            <label>Grado</label>
            <span class="form-field-select">
              <input id="grado" name="grado" type="text" placeholder="Grado" value="${action?.distribucionInstitucional?.grado}">
            </span>
          </div>
        </div>
      </td>
      <td>
        <div class="control-group">
          <div class="controls">
            <label>Grupo</label>
            <span class="form-field-select-1">
              <input id="grupo" name="grupo" type="text" placeholder="Grupo" value="${action?.distribucionInstitucional?.grupo}">
            </span>
          </div>
        </div>
      </td>
    </table>

<div class="row-fluid">
  <div class="span4">
    <div class="control-group">
      <label class="control-label" for="selectGrupo">Turno</label>
      <div class="controls">
        <g:radioGroup id="turno" name="turno" labels="['Matutino','Vespertino']" values="['Matutino','Vespertino']" value="${action?.distribucionInstitucional?.turno}" >
          <p>${it.radio} <g:message code="${it.label}" /></p>
        </g:radioGroup>
      </div>
    </div>
  </div>
  <div class="control-group">
    <div class="controls">
      <label>Matrícula</label>
      <span class="form-field-select-1">
        <input type="text" id="matricula" name="matricula" placeholder="matrícula" value="${action?.dependiente?.matricula}" />
      </span>
    </div>
  </div>
</div>
