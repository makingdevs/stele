<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Inicio</title>
  </head>
  <body>
    <h1>Comienza aquí!</h1>

    <h2>Tres sencillos pasos</h2>

    <h3>1. Selecciona la institución:</h3>
    <g:select name="institucionId" from="${com.stele.Institucion.list()}" optionKey="id" optionValue="nombre" value="${institucionId}" noSelection="['':'-Selecciona-']" class="input-xxlarge"/>

    <h3>2. Descarga el archivo de datos:</h3>

    <h3>3. Sube nuevamente el archivo:</h3>
    <g:uploadForm action="upload">
      <input type="file" name="datosEscolares" />
      <br/><br/>
      <g:submitToRemote update="previsualizar" name="porevisualizar" value="Preview" class="btn btn-large btn-primary" />
      <input type="submit" class="btn btn-large btn-success" value="Subir mis datos" />
    </g:uploadForm> 
  </body>
</html>
