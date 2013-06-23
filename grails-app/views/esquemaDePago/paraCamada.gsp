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

        <g:formRemote name="pagoGeneracion" url="[controller: 'esquemaDePago', action: 'generarPagoParaLaCamada']" update="totals">
          <input type="hidden" id="camada" name="camada" value="${camada}">

          <div class="control-group">
            <label for="conceptoDePago" class="control-label">Concepto: </label>
            <div class="controls">
              <input type="text" id="conceptoDePago" name="conceptoDePago" placeholder="Concepto">
            </div>
          </div>

          <div class="control-group">
            <label for="cantidadDePago" class="control-label">Monto: </label>
            <div class="controls">
              <div class="input-prepend input-append">
                <span class="add-on">$</span>
                <input type="text" id="cantidadDePago" name="cantidadDePago" placeholder="0.0">
              </div>
            </div>
          </div>

          <div class="control-group">
            <label for="fechaDeVencimiento" class="control-label">Fecha de vencimiento: </label>
            <div class="controls">
              <g:datePicker name="fechaDeVencimiento" value="${new Date()}" precision="day" />
            </div>
          </div>

          <g:link controller="camada" action="show" params="[camada:camada]">Ver lista de alumnos</g:link>

          <div class="form-actions" style="text-align:right;">
            <button type="submit" class="btn btn-primary btn-large" >Generar esquema</button>
          </div>
        </g:formRemote>

        <div id="totals">
          <g:render template="listaDePagosGenerados" model="['pagosGenerados' : pagosGenerados]" />
        </div>


      </div>
    </div>

  </body>
</head>
