<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Inicio</title>
    <script language="javascript">
      function check() {
        if (document.layout.datosEscolares.value == '') {
          alert('No existe un archivo pra procesar !!');
          return false;
        } 
      }
    </script>
  </head>
  <body>
    <div class="page-header">
      <h1><i class="icon-road"></i> · Comienza aquí !</h1>
    </div>
    <g:uploadForm name="layout" controller="inicio" action="preview" onsubmit="return check()">   
      <div class="container">   
        <div class="row-fluid">  
          <div class="span8"> 
            <h2>Tres sencillos pasos</h2>
            <h3>1. Selecciona la institución:</h3>
            <g:select name="institucionId" from="${instituciones}" optionKey="id" optionValue="nombre" value="${institucionId}" class="input-xxlarge"/>
            <h3>2. Descarga la plantilla para subir tu información:</h3>
            <a class="btn btn-large" href="${resource(dir: 'template', file: 'plantilla.xls')}">
              <i class="icon-file"></i> Plantilla de alumnos
            </a>
            <h3>3. Sube nuevamente el archivo:</h3>
            <input type="file" name="datosEscolares" />
            <hr/>
            <button type="submit" class="btn btn-large btn-success" >
              <i class="icon-upload"></i> Subir mis datos
            </button>
          </div>
          <div class="span4">
            <h2>Inscripción manual</h2>
            <p>
            <p> 
              <a href="${createLink(controller: 'inscripcionManual')}">
                <button class="btn btn-large btn btn-primary" type="button"><i class="icon-pencil"></i> Inscripción</button>
              </a>
            </p>
          </div>
        </div>
      </div>
    </g:uploadForm> 
  </body>
</html>
