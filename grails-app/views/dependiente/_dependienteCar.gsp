<%@ page import="com.stele.Turno" %>
<g:findAll in="${dependiente}" expr="it.distribucionInstitucional?.turno == Turno.MATUTINO">
  <div class="span3">
    <div class="thumbnail">
      <div class="caption">
        <h2>Dependientes</h2>
          <table class="table table-condensed">
            <tr>
              <td>Turno: </td>
              <td>${it.distribucionInstitucional.turno}</td>
            </tr>
            <tr>
              <td>Nivel: </td><td>${it.distribucionInstitucional.nivelDeEstudio}</td>
            </tr>
            <tr>
              <td>Grado: </td><td>${it.distribucionInstitucional.grado}</td>
            </tr>
            <tr>
              <td>Grupo: </td><td>${it.distribucionInstitucional.grupo}</td>
            </tr>
            <tr>
              <td>Dependientes: </td>
              <td>${it.size()}</td>
            </tr>
          </table>
          <p><a href="#" class="btn btn-primary"><i class="icon-search icon-white"></i></a> </p>
      </div>
    </div>
  </div>
</g:findAll>
