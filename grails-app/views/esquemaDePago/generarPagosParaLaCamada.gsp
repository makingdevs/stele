<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Pagos Generados para la Camada</title>
  </head>
  <body>
  <header class="jumbotron subhead" id="overview">
    <div class="page-header">
      <h1>Pagos Generados para la Camada</h1>
      </p>
    </div>
  </header>
  <div class="row-fluid">
    <div class="span12">
      <g:render template='list' model="[pagos : pagos]" />
    </div>
  </div>
 
  </body>
</html>
