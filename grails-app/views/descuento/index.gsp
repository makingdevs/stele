<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Descuento de pagos</title>
  </head>

  <body>

    <div class="page-header">
      <h1>Descuentos</h1>
    </div>
    <br />

    <g:form controller="descuento" action="nuevo" class="form-horizontal">

      <g:render template="/descuento/nuevoDescuento" />

      <div class="control-group">
        <div class="controls">
          <button type="submit" class="btn btn-large btn-primary">Guardar cambios</button>
        </div>
      </div>
    </g:form>

</div>

  </body>
</head>
