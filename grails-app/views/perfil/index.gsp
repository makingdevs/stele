<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Edición de datos</title>

  </head>

  <body>
    <g:render template="header" model="[usuarioActual : usuarioActual]" />

    <div class="row">
      <div class="span12 label label-info">
        <h5>Cambio de contraseña</h5>
      </div>
    </div>
    <br />
    <g:form name="password" controller="perfil" action="actualizarPassword">
      <div class="container-fluid">
        <div class="row-fluid">
          <div class="span6">
              <div class="control-group">
                <label for="contraseniaActual" class="control-label">Contraseña actual: </label>
                <div class="controls">
                  <input type="password" class="input-xlarge" name="contraseniaActual" placeholder="Contraseña actual">
                </div>
              </div>
              <div class="control-group">
                <label for="" class="control-label">Nueva contraseña: </label>
                <div class="controls">
                  <input type="password" class="input-xlarge" name="nuevaContrasenia" placeholder="Nueva contraseña">
                </div>
              </div>
              <div class="control-group">
                <label for="" class="control-label">Confirma contraseña: </label>
                <div class="controls">
                  <input type="password" class="input-xlarge" name="confirmaContrasenia" placeholder="Confirma contraseña">
                </div>
              </div>
          </div>

          <div class="span4 offset2">
            <div class="alert alert-block alert-info">
              <p class="text-center">
                <strong> En caso de que olvide su contraseña se enviará un mail a su correo principal </strong>
               </p>
            </div>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="span12 label label-info">
          <h5>Información personal </h5>
        </div>
      </div>
      <br />
      <div class="container-fluid">
        <div class="row-fluid">
          <div class="span6">
            <table class="table table-bordered table-condensed">
              <thead style="background-color:whiteSmoke">
                <tr>
                  <th colspan="5" style="text-align:left; color:blue;"> Teléfono </th>
                  <th style="border-left-style: none; text-align:right;"><i class="icon-plus-sign"></i></th>
                </tr>
                <tr>
                  <th>Principal</th>
                  <th>Tipo</th>
                  <th>Lada</th>
                  <th>Numero</th>
                  <th>Ext</th>
                  <th>&nbsp;</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td></td>
                  <td>Casa</td>
                  <td>55</td>
                  <td>1234567890</td>
                  <td></td>
                  <td style="text-align:center;">
                    <button class="btn btn-info"><i class="icon-edit icon-white"></i></button>
                    <button class="btn btn-danger"><i class="icon-trash icon-white"></i></button>
                  </td>
                </tr>
              </tbody>
            </table>
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

      <div class="form-actions" style="text-align:right;">
        <button type="submit" class="btn btn-primary btn-large">Guardar cambios</button>
        <a href="" class="btn btn-large">Cancelar</a>
      </div>
    </g:form>
  </body>
</html>
