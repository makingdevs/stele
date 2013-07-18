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
          addRemoveLinks : true,
          uploadMultiple : false,

          complete : function(file) {
            $("span.dz-message").hide("slow");
          },

          error : function(file, errorMessage, xhr) {
            $("span.dz-message").show("slow");
          },

          success : function(file, data){
            console.log(data);
          } 

        };

      });
    </r:script>

  </head>

  <body>

    <input type="hidden" value="${createLink(controller:'reciboPago', action:'subirArchivo', id: pago.id)}" id="url" />

    <div class="page-header">
      <h1>Pago por concepto de : ${pago?.conceptoDePago}</h1>
      <h1>Por la cantidad : ${pago?.cantidadDePago}</h1>
    </div>
    <br />

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span4">
          <div id="dropzone" class="dropzone text-center" style="min-height: 350px; background: rgba(0, 0, 0, 0.03); padding: 23px; cursor: pointer;">
            <span class="dz-message" >
              <br /> <br /> <br /> <br /> <br />
              <h1> <b>Arrastra aquí</b> <br /> <small>(o da click)</small> </h1>
            </span>
          </div>
        </div>
      </div>
    <div>

  </body>

</html>
