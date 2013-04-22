<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Edición de datos</title>

    <r:require modules="handlebars, backbone" />

  </head>

  <body>
    <div class="page-header">
      <h1>Alberto </h1>
      <h3>Avila Navarrete</h3>
    </div>

    <form action="edicion" class="form-horizontal">
      <div class="row">
        <div class="span12 label label-info">
          <h5>Cambio de contraseña</h5>
        </div>
      </div>
      <br />
      <div class="container-fluid">
        <div class="row-fluid">
          <div class="span6">
            <div class="control-group">
              <label for="contraseniaActual" class="control-label">Contraseña actual: </label>
              <div class="controls">
                <input type="text" class="input-xlarge" id="contraseniaActual" placeholder="Contraseña actual">
              </div>
            </div>
            <div class="control-group">
              <label for="" class="control-label">Nueva contraseña: </label>
              <div class="controls">
                <input type="text" class="input-xlarge" id="nuevaContrasenia" placeholder="Nueva contraseña">
              </div>
            </div>
            <div class="control-group">
              <label for="" class="control-label">Confirma contraseña: </label>
              <div class="controls">
                <input type="text" class="input-xlarge" id="confirmaContrasenia" placeholder="Confirma contraseña">
              </div>
            </div>
          </div>

          <div class="span4 offset2">
            <div class="alert alert-block alert-info">
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
          <div class="span6">

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

      <div class="row">
        <div class="span12 label label-info">
          <h5>Información del Contacto</h5>
        </div>
      </div>
      <br />
      <div class="container-fluid">
        <div class="row-fluid">
          <div class="span6">
            <table class="table table-bordered table-condensed">
              <thead style="background-color:whiteSmoke">
                <tr>
                  <th colspan="3" style="text-align:left; color:blue;"> Correo Electrónico </th>
                  <th style="border-left-style: none; text-align:right;"><i class="icon-plus-sign"></i></th>
                </tr>
                <tr>
                  <th>Principal</th>
                  <th>Tipo</th>
                  <th>Dirección</th>
                  <th>&nbsp;</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td></td>
                  <td>Personal</td>
                  <td>alberto@gmail.com</td>
                  <td style="text-align:center;">
                    <button class="btn btn-info"><i class="icon-edit icon-white"></i></button>
                    <button class="btn btn-danger"><i class="icon-trash icon-white"></i></button>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>

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
            <span class="pull-left" style="border: 1px red solid">
              <img class="media-object" src="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}" style="width: 114px; height: 114px;">
            </span>
            <div class="pull-right" style="border: 1px green solid">
              <dl class="dl-horizontal">
                <dt style="border: 1px red solid">Matricula : </dt>
                <dd style="border: 1px red solid">A201300018</dd>
                <dt style="border: 1px red solid">Nombre : </dt>
                <dd style="border: 1px red solid">Anali Avila Moreno</dd>
                <dt style="border: 1px red solid">Nivel : </dt>
                <dd style="border: 1px red solid">Kinder</dd>
                <dt style="border: 1px red solid">Grado : </dt>
                <dd style="border: 1px red solid">1ro.</dd>
                <dt style="border: 1px red solid">Grupo : </dt>
                <dd style="border: 1px red solid">"A"</dd>
              </dl>
            </div>
          </div>
        </div>
      </div>

      <div class="form-actions" style="text-align:right;">
        <button type="submit" class="btn btn-primary btn-large">Guardar cambios</button>
        <a href="" class="btn btn-large">Cancelar</a>
      </div>

    </form>
  </body>
</html>
