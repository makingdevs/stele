<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Recibo de pagos</title>

    <r:require module="upload" />

    <r:script>
      $(function() {
        var urlValue = $("input#url").val() 

        Dropzone.options.dropzone = {
          url : urlValue,
          maxFilesize : .5,
          addRemoveLinks : false
        };
      });
    </r:script>

  </head>

  <body>

    <input type="hidden" value="${createLink(controller:'reciboPago', action:'subirArchivo', id: pago.id)}" id="url" />

    <div class="page-header">
      <h1><class="icon-info"></i> · Subir Pago</h1>
    </div>
    <div class="row">
      <div class="span4">
        <small>Pago por concepto de : <h4>${pago?.conceptoDePago} </h4></small>
        <small>Por la cantidad :  <h4> <i class="icon-dollar"></i> ${pago?.cantidadDePago}</h4></small>
      </div>
      <div class="span6">
        <div id="dropzone" class="dropzone">
        </div>
      </div>
    </div>

  </body>

</html>
