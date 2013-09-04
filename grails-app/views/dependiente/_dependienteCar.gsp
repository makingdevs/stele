<%@ page import="com.stele.Turno" %>
  <div class="span3">
    <div class="thumbnail">
      <div class="caption">
        <h2>Dependientes</h2>
          <table class="table table-condensed">
            <tr>
              <td>Turno: </td>
              <td>${dependiente?.distribucionInstitucional?.turno?.unique()}</td>
            </tr>
            <tr>
              <td>Nivel: </td><td>${dependiente?.distribucionInstitucional?.nivelDeEstudio?.unique()}</td>
            </tr>
            <tr>
              <td>Grado: </td><td>${dependiente?.distribucionInstitucional?.grado?.unique()}</td>
            </tr>
            <tr>
              <td>Grupo: </td><td>${dependiente?.distribucionInstitucional?.grupo?.unique()}</td>
            </tr>
            <tr>
              <td>Dependientes: </td>
              <td>${dependiente?.size()}</td>
            </tr>
          </table>
          <p><g:link controller="dependiente" action="descripcionDependientes" params="[dependiente:"${dependiente?.id}"]" ><button type="button" class="btn btn-primary"><i class="icon-search icon-white"></i></button></g:link> </p>
      </div>
    </div>
  </div>
