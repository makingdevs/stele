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

  <div class="row-fluid">
    <div class="span6">
      <g:render template="dependienteCard" collection="${usuarioActual.dependientes}" var="dependiente" />
    </div>
    <div>
      <g:render template="/pago/estadoDeCuenta/pagosVencidos" model="[pagos: pagosVencidos]"/>
    </div>
    <p>     
    </p>
    <div>
      <g:render template="/pago/estadoDeCuenta/pagosEnTiempo" model="[pagosTiempo: pagosEnTiempo]"/>
    </div>
    <div>
      <g:render template="/pago/estadoDeCuenta/pagosPorRealizar" model="[pagosRealizar: pagosPorRealizar]"/>
    </div>
    <div>
      <g:render template="/pago/estadoDeCuenta/pagoMensual" model="[pagosMensuales: pagosMensuales]"/>
    </div>
  </div>


  </body>
</html>
