<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Preview</title>
  </head>
  <body>
    <div class="page-header">
      <h1>Listado de alumnos</h1>
      <g:link controller="esquemaDePago" action="paraCamada" params="[camada:camada]" class="btn btn-large btn-block btn-primary">Generar un pago para este grupo</g:link>
    </div>
    <div class="row">
      <div class="span12">
        <g:render template="/dependiente/list" model="[dependientes:dependientes]" />
      </div>
    </div>
  </body>
</html>
