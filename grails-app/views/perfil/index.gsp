<!DOCTYPE html>
<%@ page import="com.stele.TipoDeTelefono" %>

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
            <table class="table table-bordered table-condensed">
              <thead style="background-color:whiteSmoke">
                <tr>
                <th colspan="6" style="text-align:left; vertical-align:middle; color:blue;"> 
                    Teléfono 
                  </th>
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
                <g:each in="${usuarioActual.perfil?.telefonos?.sort({ it.id })}" var="t">
                  <tr>
                    <td> ${t.principal} </td>
                    <td> ${t.tipoDeTelefono} </td>
                    <td> ${t.lada} </td>
                    <td> ${t.numeroTelefonico} </td>
                    <td> ${t.extension} </td>
                    <td style="text-align:center;">
                      <div class="btn-group">
                        <g:remoteLink id="${t.id}" class="btn btn-warning"><i class="icon-edit icon-white"></i></g:remoteLink>
                        <g:remoteLink id="${t.id}" class="btn btn-danger"><i class="icon-trash icon-white"></i></g:remoteLink>
                      </div>
                    </td>
                  </tr>
                </g:each>
                <tr id="agregar">
                  <td>
                    <label class="checkbox">
                      <g:checkBox name="principal" />
                    </label>
                  </td>
                  <td>
                    <g:select class="input-small" name="tipoDeTelefono" from="${TipoDeTelefono.values()}" optionKey="key"/>
                  </td>
                  <td>
                    <input type="text" class="input-mini" maxlength="3" name="lada"></input>
                  </td>
                  <td>
                    <input type="text" class="input-small" maxlength="10" name="numeroTelefonico"></input>
                  </td>
                  <td>
                    <input type="text" class="input-mini" maxlength="6" name="extension"></input>
                  </td>
                  <td style="text-align:center;">
                    <button class="btn btn-primary">
                      <i class="icon-plus-sign icon-white"></i>
                    </button>
                  </td>
                </tr>
              </tbody>
            </table>
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
