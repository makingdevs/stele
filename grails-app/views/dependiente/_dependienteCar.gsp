<%@ page import="com.stele.Turno" %>
<g:if test="${dependiente}">
  <div class="span3">
      <div class="thumbnail">
        <div class="caption">
          <h2>Dependientes</h2>
            <table class="table table-condensed">
                <tr>
                  <td>Turno: </td>
                  <td>${dependiente.distribucionInstitucional.turno}</td>
                </tr>
                <tr>
                  <td>Nivel: </td><td>${dependiente.distribucionInstitucional.nivelDeEstudio}</td>
                </tr>
                <tr>
                  <td>Grado: </td><td>${dependiente.distribucionInstitucional.grado}</td>
                </tr>
                <tr>
                  <td>Grupo: </td><td>${dependiente.distribucionInstitucional.grupo}</td>
                </tr>
                <tr>
                  <td>Dependientes: </td>
                  <td>${dependiente.size()}</td>
                </tr> 
                <tr>
                  <td><g:link controller="dependiente" action="descripcionDependientes" params="[dependiente:"${dependiente.id}"]" ><button type="button" class="btn btn-primary"><i class="icon-search icon-white"></i></button></g:link> </td>
                  <td>&nbsp;</td>
                  <td><g:link controller="esquemaDePago" action="paraCamada" params="[camada:'${institucion.replaceAll(" ","_") + "_" + new Date().format("dd_MM_yy_HH_mm")}']" class="btn btn-primary   btn-success">
                    <i class="icon-dollar"></i>
                    </g:link>
                  </td>
                </tr>
         </table>
        </div>
      </div>
  </div>
</g:if>
