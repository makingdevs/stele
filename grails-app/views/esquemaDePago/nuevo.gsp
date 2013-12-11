<html>
  <head>
    <meta name="layout" content="colegio"/>
    <title></title>
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
              <form class="form-horizontal">
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
                              <div class="control-group">
                                <label class="control-label" for="txtConcepto">Concepto</label>
                                <div class="controls">
                                  <div class="input-prepend">
                                    <input id="form-field-mask-2" class="input-large " type="text" placeholder="Datos del cobro" >
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
                                    <input id="form-field-mask-2" class="input-medium " type="text" placeholder="importe" >
                                  </div>  
                                </div>
                              </div>  
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
                                        <input id="form-field-mask-2" class="input-large" type="text" placeholder="descuento" >
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
                                        <input id="form-field-mask-2" class="input-medium " type="text" placeholder="importe" >
                                      </div>
                                    </div>
                                  </div>
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto"> Porcentaje </label>
                                    <div class="controls">
                                      <div class="input-prepend"> 
                                        <input id="form-field-mask-2" class="input-mini " type="text" placeholder="porcentaje" >
                                        <span class="add-on">%</span>
                                      </div>
                                    </div>
                                  </div>
                                  <div class="control-group">
                                    <div class="input-prepend"> 
                                      <label class="control-label" for="txtConcepto"> Dias antes </label> 
                                      <div class="controls">
                                        <div class="input-prepend">
                                          <g:select name="diasVencimientoPago" from="${1..30}" noSelection="['':'- Dia -']"/>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                  <div class="contro-group">
                                    <div class="controls">
                                      <input class="btn btn-primary" type="submit" id="descuentoButton" value ="Crear Descuento">
                                    </div>
                                  </div>
                                </g:form>
                            </div>
                            <div id="recargo" class="tab-pane">
                              <div class="alert alert-info">
                                <button class="close" data-dismiss="alert" type="button">
                                  <i class="icon-remove"></i>
                                </button>
                                <strong>Nota! </strong>
                                Solo puede llenar importe o porcentaje
                              </div>
                              <g:formRemote name="recargoForm" update="recargoCreado" url="[controller:'recargo', action: 'nuevo']">
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto">Importe</label>
                                    <div class="controls">
                                      <div class="input-prepend">
                                        <span class="add-on">
                                          <i class="icon-usd"></i>
                                        </span>           
                                        <input id="form-field-mask-2" class="input-medium " type="text" placeholder="importe " >
                                      </div>
                                    </div>
                                  </div>
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto">Porcentaje</label>
                                    <div class="controls">
                                      <div class="input-append">
                                        <input  id="form-field-mask-2" class="input-mini " type="text"  />
                                        <span class="add-on">%</span>
                                      </div>
                                    </div>
                                  </div>
                                  <div class="contro-group">
                                    <div class="controls">
                                      <input class="btn btn-primary" type="submit" id="recargoButton" value ="Crear Recargo">
                                    </div>
                                  </div>
                              </g:formRemote>
                            </div>
                          </div>
                        </div>
                        <div class="widget-toolbox padding-8 clearfix">
                          <button class="btn btn-mini btn-success pull-right">
                            Agregar
                            <i class="icon-arrow-right icon-on-right"></i>
                          </button>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="span7 widget-container-span">
                    <div class="widget-box">
                      <div class="widget-header widget-header-small header-color-blue">
                        <h5 class="bigger lighter">
                          <i class="icon-money"></i>
                          Cobros
                        </h5> 
                      </div>
                      <div class="widget-body">
                        <div class="widget-main no-padding">
                          <table class="table table-striped table-bordered table-hover">
                            <thead>
                              <tr>
                                <th class="blue">Concepto</th>
                                <th class="blue">Importe</th>
                                <th class="pink">
                                  Descuento
                                </th>
                                <th class="pink">
                                  Importe
                                </th>
                                <th class="orange">Recargo</th>
                                <th></th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <td>Teatro de titeles pradres de familia</td>
                                <td>$1,000</td>
                                <td>Por pronto pago</td>
                                <td>$100</td>
                                <td>5%</td> 
                                <td >
                                  <div class="action-buttons center">
                                    <a class="red" href="#">
                                      <i class="icon-trash bigger-130"></i>
                                    </a>
                                  </div>
                                </td>                                   
                              </tr>
                              <tr>
                                <td>Teatro de titeles pradres de familia</td>
                                <td>$1,000</td>
                                <td>Por pronto pago</td>
                                <td>$100</td>
                                <td>5%</td> 
                                <td >
                                  <div class="action-buttons center">
                                    <a class="red" href="#">
                                      <i class="icon-trash bigger-130"></i>
                                    </a>
                                  </div>
                                </td>                                   
                              </tr>
                            </tbody>  
                          </table>
                        </div>
                      </div>
                    </div>
                  </div><!--/span-->
                </div>    
  </body>
</html>