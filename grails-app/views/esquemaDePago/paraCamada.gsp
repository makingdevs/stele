<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Esquema de pago</title>
  </head>

  <body>

    <div class="page-header">
      <h1>Esquema de pago</h1>
    </div>
    <br />

    <div class="container-fluid">
      <div class="row-fluid">

        <g:form name="pagoGeneracion" controller="esquemaDePago" action="paraCamada">
          <input type="hidden" id="camada" name="camada" value="${camada}">

          <div class="control-group">
            <label for="" class="control-label">Concepto: </label>
            <div class="controls">
              <input type="text" id="concepto" name="concepto" placeholder="Concepto">
            </div>
          </div>

          <div class="control-group">
            <label for="" class="control-label">Monto: </label>
            <div class="controls">
              <input type="text" id="monto" name="monto" placeholder="Monto">
            </div>
          </div>

          <div class="form-actions" style="text-align:right;">
            <button type="submit" class="btn btn-primary btn-large" >Generar esquema</button>
          </div>
        </g:form>

      </div>
    </div>

  </body>
</head>
