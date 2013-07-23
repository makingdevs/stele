
<!DOCTYPE html>

<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Informacion del pago</title>
  </head>

  <body>

  <div class="page-header">
    <h1><i class="icon-info"></i> Informaci&oacuten del pago <small></small></h1>
  </div>
  <div class="row">
    <div class="span7">
      <iframe src="${info.comprobanteDePago.url()}"  width="680px" height="250px" ></iframe>  
    </div>
    <div class="span4">
      <pre align="center"><small>Concepto :</small><strong> ${info.conceptoDePago}</strong></pre>
      <pre align="center"><small>Fecha que adjunto el comprobante : </small>${info.lastUpdated.format('yyyy-MMM-dd')}</pre>
      <pre align="center"><small>Fecha Vencimiento : ${info.fechaDeVencimiento.format('yyyy-MMM-dd')}</small></pre>
      <pre align="center"><small>Total : <i class="icon-dollar"></i>${info.cantidadDePago}</small></pre>
      <pre align="center"><small>Estatus del comprobante : ${info.estatusDePago}</small></pre>
      <g:if test="${info.estatusDePago} == 'Validando'">
        <div class="span6">
          <button type="button" class="btn btn-success">Aprobar</button>
          <button type="button" class="btn btn-danger">Rechazar</button>
        </div>
      </g:if>
    </div>
  </div>
    
  </body>
</html>
