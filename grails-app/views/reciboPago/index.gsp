<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Recibo de pagos</title>

    <r:require module="upload" />

    <r:script>
      $(function() {

        var urlValue = $("input#url").val() 
        Dropzone.options.myAwesomeDropzone = false;

        $("#dropzone").dropzone({
          url : urlValue,
          maxFilesize : .5
        });

      });
    </r:script>

  </head>

  <body>

    <input type="hidden" value="${createLink(controller:'reciboPago', action:'subirArchivo')}" id="url" />

    <div class="page-header">
      <h1>Pago por concepto de : ${pago?.conceptoDePago}</h1>
      <h1>Por la cantidad : ${pago?.cantidadDePago}</h1>
    </div>
    <br />

    <div class="container">

      <div id="dropzone" style="width: 360px; height: 270px;" class="text-center">
        <span class="dz-message" >
          Arrastra aquí para subir <br /> (o da click)
        </span>
      </div>

    <div>

  </body>

</html>
