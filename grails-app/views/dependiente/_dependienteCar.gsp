<%@ page import="com.stele.Turno" %>
  <div class="span3">
    <g:findAll in="${dependiente}" expr="it.distribucionInstitucional.turno == Turno.MATUTINO" >
      <div class="thumbnail">
        <div class="caption">
          <h2>Dependientes</h2>
            <table class="table table-condensed">
                <tr>
                  <td>Turno: </td>
                  <td>${it?.distribucionInstitucional?.turno}</td>
                </tr>
                <tr>
                  <td>Nivel: </td><td>${it?.distribucionInstitucional?.nivelDeEstudio}</td>
                </tr>
                <tr>
                  <td>Grado: </td><td>${it?.distribucionInstitucional?.grado}</td>
                </tr>
                <tr>
                  <td>Grupo: </td><td>${it?.distribucionInstitucional?.grupo}</td>
                </tr>
                <tr>
                  <td>Dependientes: </td>
                  <td></td>
                </tr> 
                <tr>
                  <td><g:link controller="dependiente" action="descripcionDependientes" params="[dependiente:"${it?.id}"]" ><button type="button" class="btn btn-primary"><i class="icon-search icon-white"></i></button></g:link> </td>
                </tr>
         </table>
        </div>
      </div>
    </g:findAll>
    <g:findAll in="${dependiente}" expr="it.distribucionInstitucional.turno == Turno.VESPERTINO" >
      <div class="thumbnail">
        <div class="caption">
          <h2>Dependientes</h2>
            <table class="table table-condensed">
                <tr>
                  <td>Turno: </td>
                  <td>${it?.distribucionInstitucional?.turno}</td>
                </tr>
                <tr>
                  <td>Nivel: </td><td>${it?.distribucionInstitucional?.nivelDeEstudio}</td>
                </tr>
                <tr>
                  <td>Grado: </td><td>${it?.distribucionInstitucional?.grado}</td>
                </tr>
                <tr>
                  <td>Grupo: </td><td>${it?.distribucionInstitucional?.grupo}</td>
                </tr>
                <tr>
                  <td>Dependientes: </td>
                  <td></td>
                </tr> 
                <tr>
                  <td><g:link controller="dependiente" action="descripcionDependientes" params="[dependiente:"${it?.id}"]" ><button type="button" class="btn btn-primary"><i class="icon-search icon-white"></i></button></g:link> </td>
                </tr>
         </table>
        </div>
      </div>
    </g:findAll>
  </div>
