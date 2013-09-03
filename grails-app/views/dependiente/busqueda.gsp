<%@ page import="com.stele.Turno" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Busqueda</title>
  </head>
  <body>

    <div class="page-header">
      <h1><i class="icon-tasks"></i> ·Busqueda Dependientes</h1>
    </div>
    <div class="row">
      <div class="span3" id="busquedaForm">
        <g:render template="busquedaForm" model="[turno:turno]" />
      </div>
      <div id="dependientes" class="span9" name="dependientes" >
        <g:render template="dependienteCar" />
      </div>
    </div>
  </body>
</html>
