<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Inicio</title>
  </head>
  <body>
    <g:uploadForm controller="inicio" action="preview"> 
      <h1>Comienza aquí!</h1>
      <h2>Tres sencillos pasos</h2>
      <h3>1. Selecciona la institución:</h3>
      <g:select name="institucionId" from="${instituciones}" optionKey="id" optionValue="nombre" value="${institucionId}" class="input-xxlarge"/>
      <h3>2. Descarga la plantilla para subir tu información:</h3>
      <a class="btn btn-large" href="${resource(dir: 'template', file: 'plantilla.xls')}">
        <i class="icon-file"></i> Plantilla de alumnos
      </a>
      <h3>3. Sube nuevamente el archivo:</h3>
      <input type="file" name="datosEscolares" />
      <br/><br/>
      <input type="submit" class="btn btn-large btn-success" value="Subir mis datos" />
    </g:uploadForm> 
  </body>
</html>
