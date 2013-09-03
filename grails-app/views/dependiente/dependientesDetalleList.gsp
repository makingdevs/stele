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
      <div class="span5" id="busquedaForm">
        <g:render template="busquedaForm" model="[turno:turno]" />
      </div>
      <div id="dependientes" class="span7" name="dependientes" >
        <g:render template="dependienteCar" />
      </div>
    </div>
  </body>
</html>
