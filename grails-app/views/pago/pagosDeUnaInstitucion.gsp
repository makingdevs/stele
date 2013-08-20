<html>
<head>
  <meta name="layout" content="twitterBootstrap"/>
  <title>Pagos Institucion</title>
</head>

  <body>

    <div class="page-header">
      <h1><i class="icon-dollar"></i> · Pagos de la Instituci&oacuten   <small>    ${usuario.instituciones.nombre}</small></h1>
    </div>
    <div class="row-fluid">
      <div class="span12">
        <ul class="nav nav-tabs">
          <li><a href="#procesado" data-toggle="tab">Procesados</a></li>
          <li><a href="#rechazado" data-toggle="tab">Rechazados</a></li>
          <li><a href="#vencido" data-toggle="tab">Vencidos</a></li>
          <li><a href="#creado" data-toggle="tab">Creados</a></li>
        </ul>
        <div class="tab-content">
          <div class="tab-pane active" id="procesado"><g:render template="estatusDePago/pagosProcesados" model="[pagos:pagosInstitucion]"/></div>
          <div class="tab-pane" id="rechazado"><g:render template="estatusDePago/pagosRechazados" model="[pagos:pagosInstitucion]"/></div>
          <div class="tab-pane" id="vencido"><g:render template="estatusDePago/pagosVencidos" model="[pagos:pagosInstitucion]"/></div>
          <div class="tab-pane" id="vencido">...3</div>
        </div>
      </div>
    </div>

  </body>
</html>
