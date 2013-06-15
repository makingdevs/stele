<!DOCTYPE html>

<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Edición de datos</title>

    <r:require modules="telefono"/>

  </head>

  <body>
    <g:render template="header" model="[usuarioActual : usuarioActual]" />

    <div class="row">
      <div class="span12 label label-info">
        <h5>Información</h5>
      </div>
    </div>
    <br />

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span6">
          <g:form name="password" controller="perfil" action="actualizarPassword">
            <div class="control-group">
              <label for="" class="control-label">Nueva contraseña: </label>
              <div class="controls">
                <input type="password" class="input-xlarge" id="nuevaContrasenia" name="nuevaContrasenia" placeholder="Nueva contraseña">
              </div>
            </div>
            <div class="control-group">
              <label for="" class="control-label">Confirma contraseña: </label>
              <div class="controls">
                <input type="password" class="input-xlarge" id="confirmaContrasenia" name="confirmaContrasenia" placeholder="Confirma contraseña">
              </div>
            </div>

            <div class="form-actions" style="text-align:right;">
              <button type="submit" class="btn btn-primary">Guardar cambios</button>
              <a href="" class="btn">Cancelar</a>
            </div>
          </g:form>
        </div>

        <div class="span6">
          <g:formRemote name="telefonoAsync" update="listaTelefono" url="[controller:'telefono', action:'agregarTelefonoAsync']">
            <div id="listaTelefono">
              <g:render template="/telefono/list" model="[telefonos:usuarioActual.perfil.telefonos]" />
            </div>
          </g:formRemote>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="span12 label label-info">
        <h5>Información</h5>
      </div>
    </div>
    <br />
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span6">
          <g:render template="dependienteCard" collection="${usuarioActual.dependientes}" var="dependiente" />
        </div>
      </div>
    </div>
  </body>
</html>
