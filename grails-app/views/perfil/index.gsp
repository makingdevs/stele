<!DOCTYPE html>

<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Edición de datos</title>
    <r:require modules="telefono"/>
  </head>

  <body>

  <div class="page-header">
    <h1><i class="icon-info"></i> · Información general <small>Datos personales</small></h1>
  </div>

  <div class="row">
    <div class="span5">
      <g:render template="header" model="[usuarioActual : usuarioActual]" />
      <hr/>
      <g:form name="password" controller="perfil" action="actualizarPassword">

        <div class="control-group">
          <label for="" class="">Nueva contraseña: </label>
          <div class="controls">
            <input type="password" id="nuevaContrasenia" name="nuevaContrasenia" placeholder="Nueva contraseña">
          </div>
        </div>
        <div class="control-group">
          <label for="" class="">Confirma contraseña: </label>
          <div class="controls">
            <input type="password" id="confirmaContrasenia" name="confirmaContrasenia" placeholder="Confirma contraseña">
          </div>
        </div>
        <div class="form-actions" style="text-align:right;">
          <button type="submit" class="btn btn-primary">Actualizar contraseña</button>
        </div>
        
      </g:form>
    </div>

    <div class="span6 ">
      <g:formRemote name="telefonoAsync" update="listaTelefono" url="[controller:'telefono', action:'agregarTelefonoAsync']">
        <div id="listaTelefono">
          <g:render template="/telefono/list" model="[telefonos:usuarioActual.perfil.telefonos]" />
        </div>
      </g:formRemote>
    </div>
  </div>

  <sec:ifAnyGranted roles="ROLE_PADRE_TUTOR">

  <div class="page-header">
    <h2>Mis dependientes</h2>
  </h5>
  <hr />
  
  <div class="row-fluid">
    <div class="span6">
      <g:render template="dependienteCard" collection="${usuarioActual.dependientes}" var="dependiente" />
    </div>
    <div>
      <g:render template="/pago/pagosVencidos" model="[pagos: pagosVencidos]"/>
    </div>
    <p>     
    </p>
    <div>
      <g:render template="/pago/pagosEnTiempo" model="[pagosTiempo: pagosEnTiempo]"/>
    </div>
  </div>

  </sec:ifAnyGranted>

  </body>
</html>
