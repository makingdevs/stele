<!DOCTYPE html>

<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Pagos de usuario</title>
  </head>

  <body>
   <g:render template="../perfil/header" model="[usuarioActual : usuario]" />

   <div class="row">
      <div class="span12 label label-info">
        <h5>Mis pagos</h5>
      </div>
    </div>
    <br />

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span12">
          <g:render template="list" model="[pagos : pagosDeUsuario]" />
        </div>
      </div>
    </div>

  </body>
</html>
