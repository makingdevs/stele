<%@ page import="com.stele.Turno" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Detalle Dependiente</title>
  </head>
  <body>

    <div class="page-header">
      <h1><i class="icon-tasks"></i> ·Busqueda Dependientes</h1>
    </div>
    <div class="row">
      <div class="span12">
        <table class="table">
          <thead style="background-color:whiteSmoke">
           <tr>
            <th>Turmo</th>
            <th>Nivel</th>
            <th>Grado</th>
            <th>Grupo</th>
            <th>Nombre</th>
          </tr>     
         </thead>
          <g:each in="${dependiente}" var="d">
            <tr class="info">
             <td>
               ${d?.distribucionInstitucional?.turno}
             </td>
             <td>
               ${d?.distribucionInstitucional?.nivelDeEstudio}
             </td>
             <td>
               ${d?.distribucionInstitucional?.grado}
             </td>
             <td>
               ${d?.distribucionInstitucional?.grupo}
             </td>
             <td>
               ${d?.dependiente.perfil.nombre} ${d?.dependiente.perfil.apellidoPaterno} 
             </td>
            </tr>
          </g:each>
        </table>
    </div>
  </body>
</html>
