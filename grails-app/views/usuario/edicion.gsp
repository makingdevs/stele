<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Edición de datos</title>
  </head>

  <body>
    <form action="edicion" class="form-horizontal">
      <div class="row">
        <div class="span12 label label-info">
          <h5>Cambio de contraseña</h5>
        </div>
      </div>
      <br />
      <div class="container-fluid">
        <div class="row-fluid">
          <div class="span5">

            <div class="control-group">
              <label for="contraseniaActual" class="control-label">Contraseña actual: </label>
              <div class="controls">
                <input type="text" id="contraseniaActual" placeholder="Contraseña actual">
              </div>
            </div>
            <div class="control-group">
              <label for="" class="control-label">Nueva contraseña: </label>
              <div class="controls">
                <input type="text" id="nuevaContrasenia" placeholder="Nueva contraseña">
              </div>
            </div>
            <div class="control-group">
              <label for="" class="control-label">Confirma contraseña: </label>
              <div class="controls">
                <input type="text" id="confirmaContrasenia" placeholder="Confirma contraseña">
              </div>
            </div>
          </div>

          <div class="span4">
            <div class="alert alert-block alert-info" style="margin-top:15%">
              <p class="text-center">
                <strong> En caso de que olvide su contraseña se enviará mail a su correo principal </strong>
               </p>
            </div>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="span12 label label-info">
          <h5>Información personal</h5>
        </div>
      </div>
      <br />
      <div class="container-fluid">
        <div class="row-fluid">
          <div class="span5">

            <div class="control-group">
              <label for="nombre" class="control-label">Nombre: </label>
              <div class="controls">
                <input type="text" id="nombre" placeholder="Nombre">
              </div>
            </div>
            <div class="control-group">
              <label for="apellidoPaterno" class="control-label">Apellido Paterno: </label>
              <div class="controls">
                <input type="text" id="apellidoPaterno" placeholder="Apellido Paterno">
              </div>
            </div>
            <div class="control-group">
              <label for="apellidoMaterno" class="control-label">Apellido Materno: </label>
              <div class="controls">
                <input type="text" id="apellidoMaterno" placeholder="Apellido Materno">
              </div>
            </div>
          </div>

          <div class="span4">
            <div class="control-group">
              <label for="foto" class="control-label">Sube tu foto: </label>
              <div class="controls">
                <input type="file" id="foto">
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  </body>
</html>
