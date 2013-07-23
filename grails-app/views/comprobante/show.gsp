<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Informacion del pago</title>
  </head>

  <body>

  <div class="page-header">
    <h1><i class="icon-info"></i> · Informaci&oacuten del pago <small></small></h1>
  </div>
  <div class="row">
    <div class="span7">
      <iframe src="${pago.comprobanteDePago.url()}"  width="100%" height="450px" ></iframe>  
    </div>
    <div class="span4 well">
      <dl>
      <dt>Concepto :</dt><dd> ${pago.conceptoDePago}</dd>
      <dt>Fecha que adjunto el comprobante :</dt><dd>${pago.lastUpdated.format('yyyy-MMM-dd')}</dd>
      <dt>Fecha Vencimiento :</dt><dd> ${pago.fechaDeVencimiento.format('yyyy-MMM-dd')}</dd>
      <dt>Total :</dt><dd> <i class="icon-dollar"></i>${pago.cantidadDePago}</dd>
      <dt>Estatus del comprobante :</dt><dd> ${pago.estatusDePago}</dd>
      </dl>
      <g:if test="${pago.estatusDePago} == 'Validando'">
        <div class="btn-group">
          <button type="button" class="btn btn-success"><i class="icon-thumbs-up-alt"></i> Aprobar</button>
          <button type="button" class="btn btn-danger"><i class="icon-thumbs-down-alt"></i> Rechazar</button>
        </div>
      </g:if>
    </div>
  </div>
    
  </body>
</html>
