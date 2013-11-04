<!DOCTYPE html>

<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Pagos de usuario</title>
  </head>

  <body>

  <div class="page-header">
    <h1><i class="icon-dollar"></i> · Mis pagos <small></small></h1>
  </div>

  <g:render template="/perfil/header" model="[usuarioActual : usuario]" />
  <hr/>

  <div class="row-fluid">
    <div class="span12">
      <g:render template="estatusDePago/pagosCreados" model="[pagos : pagosDeUsuario.pagosPorRealizar]" />
    </div>
  </div>

  </body>
</html>
