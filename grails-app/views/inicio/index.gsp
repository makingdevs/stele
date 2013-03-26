<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Inicio</title>
  </head>
  <body>
    <h1>Selecciona tu institución</h1>
    <g:select name="institucionId" from="${com.stele.Institucion.list()}" value="${id}" noSelection="['':'-Selecciona-']"/>
  </body>
</html>
