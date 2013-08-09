<!DOCTYPE html>

<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Estado de Cuenta</title>
  </head>

  <body>

    <div class="page-header">
      <h1><i class="icon-info"></i> · Estado de Cuenta</h1>
    </div>

    <div class="row">
      <div class="span5">
        <g:render template="/perfil/header" model="[usuarioActual : usuarioActual]" />
      </div>
    </div>
    <div class="row-fluid">
      <div>
        <g:render template="/estadoDeCuenta/pagosVencidos" model="[pagos: pagosVencidos]"/>
      </div>
      <p>     
      </p>
      <div>
        <g:render template="/estadoDeCuenta/pagosEnTiempo" model="[pagosTiempo: pagosEnTiempo]"/>
      </div>
      <div>
        <g:render template="/estadoDeCuenta/pagosPorRealizar" model="[pagosRealizar: pagosPorRealizar]"/>
      </div>
      <div class="span6">
        <g:render template="/estadoDeCuenta/pagoMensual" model="[pagosMensuales: pagosMensuales]"/>
      </div>
    </div>


  </body>
</html>
