<!DOCTYPE html>

<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Edición de datos</title>
    <r:require modules="telefono"/>
  </head>

  <body>

  <div class="page-header">
    <h1><i class="icon-info"></i> · Información general <small>Datos personales</small></h1>
  </div>

  <div class="row">
    <div class="span5">
      <g:render template="header" model="[usuarioActual:usuarioActual]"/>
      <hr/>
      <g:render template="passwordUpdate" model="[usuarioActual:usuarioActual]"/>
    </div>

    <div class="span6 ">
      <g:render template="/telefono/list" model="[telefonos:usuarioActual.perfil.telefonos]" />
    </div>
  </div>

  </body>
</html>
