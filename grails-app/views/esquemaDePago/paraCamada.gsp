<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Esquema de pago</title>
    <r:require module="pagosParaCamada"/>
    <r:require module="generarPagos" />
    <r:require module="autocomplete" />
  </head>

  <body>
    <script type="text/javascript">
    function modelHide(){
      $('#recargoModal').modal('hide');
    }
    </script>

    <div class="page-header">
      <h1><i class="icon-dollar"></i> · Crear un pago <small>con un esquema</small></h1>
    </div>
    <br />

    <div class="container-fluid">
      <div class="row-fluid">
          <g:form id="pagoGeneracion" name="pagoGeneracion" controller="esquemaDePago" action="generarPagoParaLaCamada" >
            <input type="hidden" id="camada" name="camada" value="${camada}">
            <div class="row-fluid">
              <div class="span6">
                <div class="control-group">
                  <label for="conceptoDePago" class="control-label">Concepto: </label>
                  <div class="controls">
                    <input type="text" id="conceptoDePago" class="typeahead" data-provide="typeahead" name="conceptoDePago" placeholder="Concepto" autocomplete="off" >
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
              </div>

              <div class="span6">
                <div id="descuentoCreado">
                  <g:render template="/descuento/list", model="[:]" />
                </div>
                <div id="recargoCreado" name="recargoCreado">
                  <g:render template="/recargo/list" />
                </div>
              </div>
            </div>
            <div class="control-group">
              <label for="fechaDeVencimiento" class="control-label">Fecha de vencimiento: </label>
              <div class="controls">
                <g:datePicker name="fechaDeVencimiento" value="${new Date()}" precision="day" />
              </div>
            </div>

            <div class="control-group">
                <a href="#descuentoModal" role="button" class="btn btn-info" data-toggle="modal">Agregar descuento</a>
                <a href="#recargoModal" role="button" class="btn btn-info" data-toggle="modal" align="right">Agregar Recargo</a>
            </div>

            <g:link controller="camada" action="show" params="[camada:camada]">Ver lista de alumnos</g:link>
            <div class="form-actions" style="text-align:right;">
              <button type="submit" class="btn btn-primary btn-large" >Generar pagos</button>
            </div>
          </g:form>
      </div>
    </div>

    <div id="descuentoModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="descuentoLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="descuentoLabel">Datos del descuento</h3>
      </div>

      <g:form class="form-horizontal" name="descuentosForm" url="[controller:'descuento', action:'nuevo']" id="descuentosForm" >
        <div class="modal-body">
          <g:render template="/descuento/nuevoDescuento" />
        </div>
        <div class="modal-footer">
          <button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
          <button class="btn btn-primary" id="aplicarDescuentoBtn">Aplicar descuento</button>
        </div>
      </g:form>

    </div>

    <div id="recargoModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="recargoLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="recargoLabel">Datos del recargo</h3>
      </div>

      <g:formRemote name="recargoForm" update="recargoCreado" url="[controller:'recargo', action: 'nuevo']" onComplete="modelHide();">
        <div class="modal-body">
          <g:render template="/recargo/nuevoRecargo" />
        </div>
        <div class="modal-footer">
           <button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
          <button type="submit" class="btn btn-primary" >Generar Recargo</button>
        </div>
      </g:formRemote>
    </div>


  </body>
</head>
