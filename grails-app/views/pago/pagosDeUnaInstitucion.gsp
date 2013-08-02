<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Pagos Institucion</title>
  </head>

  <body>

  <div class="page-header">
    <h1><i class="icon-dollar"></i> · Pagos de la Instituci&oacuten   <small>    ${usuario.instituciones.nombre}</small></h1>
  </div>
  <div class="row-fluid">
    <div class="span12">
      <g:render template="list" model="[pagos : pagosInstitucion, count:pagosCount]" />
    </div>
  </div>

  </body>
</html>
