<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require modules="validarEsquemaDePago" /> 
    <r:script>
      $(function() {
        $("#descuentosForm").submit(function(event){
          event.stopPropagation();
          var url = $(this).attr('action');
          var data = $(this).serialize()
          var descuentosIds = $("input#descuentos").val();
          $.ajax({
            type: "POST",
            url: url + "?descuentosIds=" + descuentosIds,
            data: data,
            success: function(data) {
              $("#descuentoCreado").html(data)
              $("#descuentoCreado2").html(data)
            }
          });
          return false;
        });
      });
      $("#recargoForm").submit(function(event){
        event.stopPropagation();
        var url = $(this).attr('action');
        var data = $(this).serialize()
        var recargoid = $("input#recargoid").val();
        $.ajax({
          type: "POST",
          url: url + "?recargoid=" + recargoid,
          data: data,
          success: function(data) {
            $("#recargoCreado").html(data)
            $("#recargoCreado2").html(data)
          }
        });
        return false;
      });
    </r:script>
  </head>
  <body>
    <div class="main-content">
      <div class="breadcrumbs" id="breadcrumbs">
        <ul class="breadcrumb">
          <li>
            <i class="icon-home home-icon"></i>
            <a href="#">Colegio</a>
            <span class="divider">
              <i class="icon-angle-right arrow-icon"></i>
            </span>
            <li class="active">Conciliacion</li>
          </ul><!--.breadcrumb-->
        </div>
        <div class="page-content">
          <div class="page-header position-relative">
            <h1>
              Esquemas de Cobro
              <small>
                <i class="icon-double-angle-right"></i>
              </small>
            </h1>
          </div>
          <div class="row-fluid">
            <div class="span12">
                <div class="row-fluid">
                  <div class="span5 widget-container-span">
                    <div class="widget-box">
                      <div class="widget-header widget-header-small header-color-blue2">
                        <h5 class="smaller">Esquema de Cobro</h5>
                        <div class="widget-toolbar no-border">
                          <ul class="nav nav-tabs" id="myTab">
                            <li class="active">
                              <a data-toggle="tab" href="#cobro">Cobro</a>
                            </li>
                            <li>
                              <a data-toggle="tab" href="#descuento">Descuento</a>
                            </li>
                            <li>
                              <a data-toggle="tab" href="#recargo">Recargo</a>
                            </li>
                          </ul>
                        </div>
                      </div>
                      <div class="widget-body">
                        <div class="widget-main padding-6">
                          <div class="tab-content">
                              <div id="cobro" class="tab-pane in active">
                                <g:form id="esquemaDePagoForm" name="esquemasDePago" url="[controller: 'esquemaDePago', action: 'crearEsquemaDePago']">
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto">Concepto</label>
                                    <div class="controls">
                                      <div class="input-prepend">
                                        <input id="nombreConcepto" name="nombreConcepto" class="input-large " type="text" placeholder="Datos del cobro" >
                                      </div>
                                    </div>
                                  </div>                          
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto">Importe</label>
                                    <div class="controls">
                                      <div class="input-prepend">
                                        <span class="add-on">
                                          <i class="icon-usd"></i>
                                        </span>
                                        <input id="importeEsquemaDePago" name="importeEsquemaDePago" class="input-medium " type="text" placeholder="importe" >
                                      </div>  
                                    </div>
                                  </div> 
                                  <div id="descuentoCreado" name="descuentoCreado">
                                    <g:render template="/descuento/list", model="[:]" />
                                  </div>
                                  <div class="control-group">
                                    <div id="recargoCreado" name="recargoCreado" class="controls">
                                      <g:render template="/recargo/list" />
                                    </div>
                                  </div>
                                  <div class="widget-toolbox padding-8 clearfix">
                                    <input class="btn btn-mini btn-success pull-right" type="submit" id="crearEsquema" value ="Agregar">
                                  </div>
                                </g:form>
                              </div>
                            <div id="descuento" class="tab-pane">
                              <div class="alert alert-info">
                                <button class="close" data-dismiss="alert" type="button">
                                  <i class="icon-remove"></i>
                                </button>
                                <strong>Nota! </strong>
                                Solo puede llenar importe o porcentaje<br>
                              </div>
                                <g:form class="form-horizontal" name="descuentosForm" url="[controller:'descuento', action:'nuevo']" id="descuentosForm" >
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto"> Descuento </label>
                                    <div class="controls">
                                      <div class="input-prepend">
                                        <input id="form-field-mask-2" class="input-large"id="nombreDeDescuento" name="nombreDeDescuento" type="text" placeholder="descuento" >
                                      </div>  
                                    </div>
                                  </div>                                
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto"> Importe </label>
                                    <div class="controls">
                                      <div class="input-prepend"> 
                                        <span class="add-on">
                                          <i class="icon-usd"></i>
                                        </span>
                                        <input id="form-field-mask-2" class="input-medium " id="cantidad" name="cantidad" type="text" placeholder="importe" >
                                      </div>
                                    </div>
                                  </div>
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto"> Porcentaje </label>
                                    <div class="controls">
                                      <div class="input-prepend"> 
                                        <input id="form-field-mask-2" class="input-mini" id="porcentaje" name="porcentaje" type="text" placeholder="porcentaje" >
                                        <span class="add-on">%</span>
                                      </div>
                                    </div>
                                  </div>
                                  <div class="control-group">
                                    <div class="input-prepend"> 
                                      <label class="control-label" for="txtConcepto"> Dias antes </label> 
                                      <div class="controls">
                                        <div class="input-prepend">
                                          <g:select name="diasPreviosParaCancelarDescuento" from="${1..30}" noSelection="['':'- Dia -']"/>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                  <div class="contro-group">
                                    <div class="controls">
                                      <input class="btn btn-mini btn-success pull-right" type="submit" id="descuentoButton" value ="Crear Descuento">
                                    </div>
                                  </div>
                                </g:form>
                                <div id="descuentoCreado2" name="descuentoCreado2">
                                    <g:render template="/descuento/list", model="[:]" />
                                </div>
                            </div>
                            <div id="recargo" class="tab-pane">
                              <div class="alert alert-info">
                                <button class="close" data-dismiss="alert" type="button">
                                  <i class="icon-remove"></i>
                                </button>
                                <strong>Nota! </strong>
                                Solo puede llenar importe o porcentaje
                              </div>
                              <g:form name="recargoForm" id="recargoForm" url="[controller:'recargo', action: 'nuevo']">
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto">Importe</label>
                                    <div class="controls">
                                      <div class="input-prepend">
                                        <span class="add-on">
                                          <i class="icon-usd"></i>
                                        </span>           
                                        <input id="form-field-mask-2" class="input-medium " id="cantidad" name="cantidad" type="text" placeholder="importe " >
                                      </div>
                                    </div>
                                  </div>
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto">Porcentaje</label>
                                    <div class="controls">
                                      <div class="input-append">
                                        <input  id="form-field-mask-2" class="input-mini" id="porcentaje" name="porcentaje" type="text"  />
                                        <span class="add-on">%</span>
                                      </div>
                                    </div>
                                  </div>
                                  <div class="contro-group" >
                                    <div class="controls">
                                      <input class="btn btn-mini btn-success pull-right" type="submit" id="recargoButton" value ="Crear Recargo">
                                    </div>
                                  </div>
                              </g:form>
                              <div class="control-group">
                                <div id="recargoCreado2" name="recargoCreado" class="controls">
                                  <g:render template="/recargo/list" />
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="span7 widget-container-span" id="listaEsquemas">
                   <g:render template="lista", model="[esquemasDePagos: esquemasDePagos]"/>
                  </div>
                </div>    
  </body>
</html>
