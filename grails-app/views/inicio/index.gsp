<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Inicio</title>
  </head>
  <body>
  ${instituciones}
    <g:uploadForm controller="inicio" action="preview"> 
      <h1>Comienza aquí!</h1>
      <h2>Tres sencillos pasos</h2>
      <h3>1. Selecciona la institución:</h3>
      <g:select name="institucionId" from="${instituciones}" optionKey="id" optionValue="nombre" value="${institucionId}" class="input-xxlarge"/>
      <h3>2. Descarga el archivo de datos:</h3>
      <h3>3. Sube nuevamente el archivo:</h3>
      <input type="file" name="datosEscolares" />
      <br/><br/>
      <input type="submit" class="btn btn-large btn-success" value="Subir mis datos" />
    </g:uploadForm> 
  </body>
</html>
