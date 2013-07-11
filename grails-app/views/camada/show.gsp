<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Preview</title>
  </head>
  <body>

    <div class="page-header">
      <h1><i class="icon-tasks"></i> · Alumnos <small>Lista de dependientes</small></h1>
    </div>
    <div class="row">
      <div class="span4"></div>
      <div class="span5 offset8">
        <g:link controller="esquemaDePago" action="paraCamada" params="[camada:camada]" class="btn btn-large btn-success">
          <i class="icon-dollar"></i> Generar un pago para este grupo
        </g:link>
      </div>
    </div>
    <hr/>
    <div class="row">
      <div class="span12">
        <g:render template="/dependiente/list" model="[dependientes:dependientes]" />
      </div>
    </div>
  </body>
</html>
