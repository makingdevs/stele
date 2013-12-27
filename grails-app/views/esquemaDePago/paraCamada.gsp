<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require modules="bootstrap-js" />
    <r:require module="pagosParaCamada"/>
    <r:require module="generarPagos" />
    <r:require module="autocomplete" />
    <r:require module="bootstrapDatePicker" />
  </head>
  <body>
    <script type="text/javascript">
      $(document).ready(function(){
        $("#submitFormPayout").click(function(){
          $("#pagoGeneracion").submit();
        });
      });
      $(document).ready(function() {
        $('#datetimepicker1').datepicker({
          format : "dd/mm/yyyy",
          language : 'es',
          autoclose : true
        });
      });
      $(document).ready(function() {
        $('#datetimepicker2').datepicker({
          format : "dd/mm/yyyy",
          language : 'es',
          autoclose : true
        });
      });
    </script>
      <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
          <ul class="breadcrumb">
            <li>
              <i class="icon-home home-icon"></i>
              <a href="#">Colegio</a>
              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>
            <li>
              <a href="#">Inscripcion</a>
              <span class="divider">
                <i class="icon-angle-right arrow-icon"></i>
              </span>
            </li>
            <li class="active">Archivo</li>
          </ul><!--.breadcrumb-->
        </div>
        <div class="page-content">
          <div class="page-header position-relative">
            <h1>
              Inscripcion Archivo + Cobro
              <small>
                <i class="icon-double-angle-right"></i>
                Inscripcion Archivo de Alumnos y su Padre o Tutor, mas a gregar un cobro a los alumnos del archivo
              </small>
            </h1>
          </div>
          <div class="row-fluid">
            <div class="span12">
              <div class="widget-box">
                <div class="widget-header widget-header-blue widget-header-flat">
                </div>
                <div class="widget-body">
                  <div class="widget-main">
                    <div class="row-fluid">
                      <g:render template="menuArchivoPago" />
                      <hr />
                        <div class="step-content row-fluid  position-relative" id="step-container">
                          <div class="step-pane active" id="step5">
                            <div class="tabbable3">
                                <ul class="nav nav-tabs padding-18 tab-size-bigger" id="myTab3">
                                  <li class="active">
                                    <a data-toggle="tab" href="#faq-tab-111">
                                      <i class="orange icon-money   bigger-120"></i>
                                      Cobro Unitario
                                    </a>
                                  </li>
                                  <li>
                                    <a data-toggle="tab" href="#faq-tab-222">
                                      <i class="blue icon-retweet   bigger-120"></i>
                                      Cobro Recurrente
                                    </a>
                                  </li>
                                  <li>
                                    <a data-toggle="tab" href="#faq-tab-333">
                                      <i class="green icon-tag  bigger-120"></i>
                                      Descuento
                                    </a>
                                  </li>
                                  <li>
                                    <a data-toggle="tab" href="#faq-tab-444">
                                      <i class="red icon-sort-by-attributes icon-flip-vertical   bigger-120"></i>
                                      Recargo
                                    </a>
                                  </li>
                                </ul>
                                <div class="tab-content">
                                  <div id="faq-tab-111" class="tab-pane active">
                                    <g:form id="pagoGeneracion" name="pagoGeneracion" controller="esquemaDePago" action="generarPagoParaLaCamada" >
                                    <input type="hidden" id="camada" name="camada" value="${camada}">
                                    <input type="hidden" id="listaDependientes" name="listaDependientes" value="${flash.dependientes}">
                                        <div class="alert alert-info">
                                          <button class="close" data-dismiss="alert" type="button">
                                            <i class="icon-remove"></i>
                                          </button>
                                          <strong>Nota! </strong>
                                            Solo puede seleccionar un concepto cobro unitario o recurrente
                                          <br>
                                        </div>
                                      <div class="row-fluid">
                                        <div class="span5">
                                          <div class="control-group">
                                          <label class="control-label" for="txtConcepto">Concepto</label>
                                          <div class="controls">
                                            <div class="input-prepend">
                                              <input type="hidden" id="urlConcepto" value="${g.createLink(action:'obtenerEsquemaDePagoPorConcepto', controller:'esquemaDePago')}" />
                                              <input type="text" id="conceptoDePago" class="typeahead" data-provide="typeahead" name="conceptoDePago" placeholder="Concepto" autocomplete="off" >
                                              <span class="add-on">
                                                <i class="icon-edit"></i>
                                              </span>
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
                                              <input type="text" id="cantidadDePago" name="cantidadDePago" placeholder="0.0">
                                            </div>  
                                          </div>
                                          </div>
                                          <div class="control-group">
                                          <label class="control-label" for="txtConcepto">Fecha Vencimiento</label>
                                          <div class="controls">
                                            <div id="datetimepicker2" class="input-append date" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
                                              <input id="fechaDeVencimiento" name="fechaDeVencimiento" data-format="yyyy-mm-dd" type="text"></input>
                                              <span class="add-on">
                                                <i class="icon-calendar"></i>
                                              </span>
                                            </div>
                                          </div>
                                          </div>  
                                          </div>
                                        <div class="span3">
                                          <input type="hidden" id="idRecargo" name="idRecargo">
                                          <input type="hidden" id="idsDescuentos" name="idsDescuentos">
                                          <label class="hidden" id="labelRecargoCantidad">Recargo Cantidad</label><input class="hidden" id="cantidadRecargo" name="cantidadRecargo" readonly>
                                          <label class="hidden" id="labelRecargoPorcentaje">Recargo Porcentaje</label><input class="hidden" id="recargoPorcentaje" name="recargoPorcentaje" readonly>
                                          <label class="hidden" id="labelDescuentos">Descuentos </label><input class="hidden" id="nombreDescuentos" name="nombreDescuentos" readonly>
                                        </div>
                                        <div class="span3">
                                          <div id="descuentoCreado">
                                            <g:render template="/descuento/list", model="[:]" />
                                          </div>
                                          <div id="recargoCreado" name="recargoCreado">
                                            <g:render template="/recargo/list" />
                                          </div>
                                        </div>
                                      </div>
                                  </div>
                                  <div id="faq-tab-222" class="tab-pane">
                                      <div class="row-fluid">
                                        <div class="span11">
                                          <div class="alert alert-info">
                                            <button class="close" data-dismiss="alert" type="button">
                                              <i class="icon-remove"></i>
                                            </button>
                                            <strong>Nota! </strong>
                                              Solo puede seleccionar un concepto cobro recurrente o unitario
                                            <br>
                                          </div>
                                          <div class="span4">
                                            <div class="control-group">
                                              <label class="control-label" for="txtConcepto">Concepto</label>
                                              <div class="controls">
                                                <div class="input-prepend">
                                                  <input type="text" id="conceptoDePagoRecurrente" class="typeahead" data-provide="typeahead" name="conceptoDePagoRecurrente" placeholder="Concepto" autocomplete="off" >
                                                  <span class="add-on">
                                                    <i class="icon-edit"></i>
                                                  </span>
                                                </div>          
                                              </div>
                                            </div>
                                            <div class="control-group">
                                              <label class="control-label" for="txtConcepto"> Dias Vencimiento  </label>
                                              <div class="controls">
                                                <div class="input-prepend">
                                                  <g:select  id="diasVencimientoPago" name="diasVencimientoPago" from="${1..30}" noSelection="['':'- Dia -']"/>
                                                </div>
                                              </div>
                                            </div>
                                            <div class="control-group">
                                              <label class="control-label" for="numCantidadDePagoRecurrente">Importe</label>
                                              <div class="controls">
                                                <div class="input-prepend">
                                                  <span class="add-on">
                                                    <i class="icon-usd"></i>
                                                  </span>
                                                  <input type="text" id="cantidadDePagoRecurrente" name="cantidadDePagoRecurrente" placeholder="0.0">
                                                </div>  
                                              </div>
                                            </div> 
                                          </div>
                                          <div class="span2">
                                            <label class="hidden" id="labelRecargoCantidad1">Recargo Cantidad</label><input class="hidden" id="  cantidadRecargo1" name="cantidadRecargo1" readonly>
                                            <label class="hidden" id="labelRecargoPorcentaje1">Recargo Porcentaje</label><input class="hidden" id="recargoPorcentaje1" name="recargoPorcentaje1" readonly>
                                            <label class="hidden" id="labelDescuentos1">Descuentos </label><input class="hidden" id="nombreDescuentos1" name="nombreDescuentos1" readonly>
                                          </div>
                                          <div class="span2">
                                            <div id="descuentoCreado3">
                                              <g:render template="/descuento/list", model="[:]" />
                                            </div>
                                            <div id="recargoCreado3" name="recargoCreado">
                                              <g:render template="/recargo/list" />
                                            </div>
                                          </div> 
                                        </div>
                                        <div class="span11">
                                          <div class="span2">
                                            <label>
                                              <span class="lbl  blue"> <strong> Meses </strong> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="0" checked="${false}" />
                                              <span class="lbl"> Enero </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="1" checked="${false}" />
                                              <span class="lbl"> Febrero</span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="2" checked="${false}" />
                                              <span class="lbl"> Marzo</span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="3" checked="${false}" />
                                              <span class="lbl"> Abril</span>
                                            </label>  
                                          </div>    
                                          <div class="span2">
                                            <label>
                                              <span class="lbl orange"> Doble </span>
                                            </label>                                
                                            <label>
                                              <g:checkBox name="pagoDoble" value="0" checked="${false}"  /> 
                                              <span class="lbl"> <br> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="pagoDoble" value="1" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="pagoDoble" value="2" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="pagoDoble" value="3" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
                                            </label>
                                          </div>
                                          <div class="span2">
                                            <label>
                                              <span class="lbl  blue"> <strong> Meses </strong> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="4" checked="${false}" />
                                              <span class="lbl"> Mayo </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="5" checked="${false}" />
                                              <span class="lbl"> Junio </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="6" checked="${false}" />
                                              <span class="lbl"> Julio</span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="7" checked="${false}" />
                                              <span class="lbl"> Agosto</span>
                                            </label>  
                                          </div>    
                                          <div class="span2">
                                            <label>
                                              <span class="lbl orange"> Doble </span>
                                            </label>                                
                                            <label>
                                              <g:checkBox name="pagoDoble" value="4" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="pagoDoble" value="5" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="pagoDoble" value="6" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="pagoDoble" value="7" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
                                            </label>
                                          </div>
                                          <div class="span2">
                                            <label>
                                              <span class="lbl  blue"> <strong> Meses </strong> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="8" checked="${false}" />
                                              <span class="lbl"> Septiembre </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="9" checked="${false}" />
                                              <span class="lbl"> Octubre </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="10" checked="${false}" />
                                              <span class="lbl"> Noviembre</span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="11" checked="${false}" />
                                              <span class="lbl"> Dicciembre </span>
                                            </label>  
                                          </div>    
                                          <div class="span1">
                                            <label>
                                              <span class="lbl orange"> Doble </span>
                                            </label>                                
                                            <label>
                                              <g:checkBox name="pagoDoble" value="8" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="pagoDoble" value="9" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="pagoDoble" value="10" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="pagoDoble" value="11" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
                                            </label>
                                          </div>
                                        </div>
                                      </div>
                                    </g:form>
                                  </div>
                                  <div id="faq-tab-333" class="tab-pane">
                                    <div class="row-fluid">
                                      <div class="span12">
                                        <div class="alert alert-info">
                                          <button class="close" data-dismiss="alert" type="button">
                                            <i class="icon-remove"></i>
                                          </button>
                                          <strong>Nota! </strong>
                                            Solo puede seleccionar importe o porcentaje de descuento <br>
                                          <strong>Nota! </strong>
                                            Por fecha de vencimiento o dias antes de vencer el pago
                                          <br>
                                        </div>
                                      </div>
                                      <g:form class="form-horizontal" name="descuentosForm" url="[controller:'descuento', action:'nuevo']" id="descuentosForm" >
                                        <div class="span4">
                                        <p></p><p></p>
                                        <div class="control-group">
                                          <label class="control-label" for="txtConcepto"> Descuento </label>
                                          <div class="controls">
                                              <input type="hidden" id="urlDescuento" value="${g.createLink(action:'obtenerDescuentosInstitucion', controller:'descuento')}" />
                                            <div class="input-prepend">
                                              <input type="text" id="nombreDeDescuento" name="nombreDeDescuento" class="typeahead2" data-provide="typeahead" placeholder="Nombre" autocomplete="off">
                                              <span class="add-on">
                                                <i class="icon-edit"></i>
                                              </span>
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
                                              <input class="input-medium" id="cantidad" name="cantidad" type="text" placeholder="0.0">
                                            </div>
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="txtConcepto">Fecha Vencimiento</label>
                                          <div class="controls">
                                            <div id="datetimepicker1" class="input-append date" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
                                              <input data-format="yyyy-mm-dd" id="fechaDeVencimiento" name="fechaDeVencimiento" type="text"></input>
                                              <span class="add-on">
                                                <i class="icon-calendar"></i>
                                              </span>
                                            </div>
                                          </div>
                                        </div>             
                                        </div>
                                        <div class="span4">
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
                                        <div class="control-group">
                                            <div class="input-append">          
                                              <label class="control-label" for="txtConcepto"> Procentaje </label>
                                              <div class="controls">
                                                <input class="input-mini" id="porcentaje" name="porcentaje" type="text" placeholder="0.0">
                                                <span class="add-on">%</span>
                                              </div>
                                            </div>
                                        </div>
                                        <div class="contro-group">
                                          <div class="controls">
                                            <input class="btn btn-primary" type="submit" id="descuentoButton" value ="Crear Descuento">
                                          </div>
                                        </div>
                                        </div>
                                        <div class="span3">
                                         <div id="descuentoCreado2">
                                            <g:render template="/descuento/list", model="[:]" />
                                          </div>
                                        </div>
                                      </g:form>
                                    </div>
                                  </div>
                                  <div id="faq-tab-444" class="tab-pane">
                                    <div class="row-fluid">
                                      <div class="span12">
                                            <div class="alert alert-info">
                                            <button class="close" data-dismiss="alert" type="button">
                                              <i class="icon-remove"></i>
                                            </button>
                                            <strong>Nota! </strong>
                                              Solo puede seleccionar un concepto cobro recurrente o unitario
                                            <br>
                                          </div>
                                      </div>
                                      <g:form name="recargoForm" url="[controller:'recargo', action: 'nuevo']" id="recargoForm">
                                      <div class="span6">
                                          <div class="control-group">
                                            <label class="control-label" for="txtConcepto">Importe</label>
                                            <div class="controls">
                                              <div class="input-prepend">
                                                <span class="add-on">
                                                  <i class="icon-usd"></i>
                                                </span>                 
                                                <input class="input-mini" id="cantidad" name="cantidad" type="text" placeholder="0.0">
                                              </div>
                                            </div>
                                          </div>
                                          <div class="control-group">
                                            <label class="control-label" for="txtConcepto">Porcentaje</label>
                                            <div class="controls">
                                              <div class="input-append">
                                                <input class="input-mini" id="porcentaje" name="porcentaje" type="text" placeholder="0.0">
                                                <span class="add-on">%</span>
                                              </div>
                                            </div>
                                          </div>
                                          <div class="contro-group">
                                          <div class="controls">
                                            <input class="btn btn-primary" type="submit" id="recargoButton" value ="Crear Recargo">
                                          </div>
                                        </div>
                                      </div>
                                      <div class="span5">
                                        <div id="recargoCreado2" name="recargoCreado2">
                                            <g:render template="/recargo/list" />
                                        </div>
                                      </div>
                                      </g:form>
                                    </div><!--/row-->
                                  </div>  
                                </div>
                            </div>
                          </div>
                        </div>
                      <hr />
                    </div>
                  </div><!--/widget-main-->
                </div><!--/widget-body-->
              </div><!--/widget-box-->
            </div><!--/.span-->
          </div><!--/.row-fluid-->
        </div><!--/.page-content-->

        <div class="ace-settings-container" id="ace-settings-container">
          <div class="ace-settings-box" id="ace-settings-box">
            <div>
              <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
              <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
            </div>
            <div>
              <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
              <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
            </div>
            <div>
              <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
              <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
            </div>
            <div>
              <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
              <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
            </div>
          </div>
        </div><!--/#ace-settings-container-->
    </div><!--/.main-content-->


      <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-small btn-inverse">
      <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
   
  </body>
</html>