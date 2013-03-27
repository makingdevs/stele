<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Preview</title>
  </head>
  <body>
    <div class="page-header">
      <h1>Confirma esta información.</h1>
    </div>
    <h2>Distribución organizacional</h2>
    <g:render template="distribucionOrganizacional" model="" />
    <h2>Muestra de datos a registrar</h2>
    <g:render template="datosTabulares" model="[listaDeMapaDeDominios:listaDeMapaDeDominios]" />
  </body>
</html>
