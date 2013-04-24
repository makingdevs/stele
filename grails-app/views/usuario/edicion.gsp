<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Edición de datos</title>

    <r:require modules="handlebars, backbone" />

    <r:script>
      var PerfilModel = Backbone.Model.extend({
        url : function() {
          return "http://localhost:8080/stele/usuario/obtenerPerfilUsuario/";
        }
      });

      var PerfilView = Backbone.View.extend({
        render: function() {
          var template = Handlebars.compile($("#encabezadoUsuario").html());
          var html     = template(this.model);
          this.$el.html( html );
          return this;
        }
      });

      var modelo = new PerfilModel;
      modelo.fetch({ 
        success : function(model, response, options) { 
          console.log(response.nombreTutor);
          var perfilView = new PerfilView({model : response});
          $('#encabezadoContainer').html(perfilView.render().el);
        }
      }) 

    </r:script>

  </head>

  <body>

    <g:render template="header" />
    <div id="encabezadoContainer" >
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

            <div class="media">
              <span class="pull-left">
                <img class="media-object" src="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}" style="width: 114px; height: 114px;">
              </span>
              <div class="media-body">
                <p><strong>Matricula :</strong> <small> A201300018 </small></p>
                <p><strong>Nombre :</strong> <small> Anali Avila Moreno </small></p>
                <p><strong>Nivel :</strong> <small> Kinder </small></p>
                <p><strong>Grado :</strong> <small> 1ro. </small></p>
                <p><strong>Grupo :</strong> <small> "A" </small></p>
              </div>
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
