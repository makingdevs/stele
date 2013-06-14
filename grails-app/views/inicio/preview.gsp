<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Preview</title>
  </head>
  <body>
    <div class="page-header">
      <h1>Confirma esta información.</h1>
    </div>
    <h2>Distribución organizacional</h2>
    <g:each in="${estructuraInstitucional}" var="distribucionDeCicloEscolar">
      <g:render template="distribucionOrganizacional" model="[
      distribucionDeCicloEscolar:distribucionDeCicloEscolar,
      alumnosPorNivel:alumnosPorNivel[distribucionDeCicloEscolar.key],
      alumnosPorGrado:alumnosPorGrado[distribucionDeCicloEscolar.key],
      alumnosPorTurno:alumnosPorTurno[distribucionDeCicloEscolar.key]
      ]" />
    </g:each>
    <div class="row-fluid">
      <g:link class="btn btn-large btn-primary" controller="procesamientoMasivo" params="[institucionId:institucionId]">
        Procesar y confirmar información
      </g:link>
    </div>
    <h2>Muestra de datos a registrar</h2>
    <g:render template="datosTabulares" model="[listaDeMapaDeDominios:listaDeMapaDeDominios]" />
  </body>
</html>
