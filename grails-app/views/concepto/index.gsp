<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Concepto de pago</title>
  </head>

  <body>

    <div class="page-header">
      <h1>Concepto de pago</h1>
    </div>
    <br />

    <g:form controller="concepto" action="nuevo" class="form-horizontal">

      <div class="control-group">
        <label for="" class="control-label">Concepto : </label>
        <div class="controls">
          <input type="text" id="concepto" name="concepto" class="input-xxlarge" placeholder="Concepto">
        </div>
      </div>

      <div class="control-group">
        <div class="controls">
          <button type="submit" class="btn btn-large btn-primary">Guardar cambios</button>
        </div>
      </div>
    </g:form>


  </body>
</head>
