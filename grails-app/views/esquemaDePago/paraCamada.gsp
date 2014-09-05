<html>
  <head>
    <meta name="layout" content="colegio"/>
    <r:require module="paraCamada" />
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
          </li>
          <li>
            <a href="#">Inscripción</a>
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
            <g:if test="${flash.message}">
              <input type="hidden" name="message" value="${flash.message}"/>
              ${flash.message}
            </g:if>
            <g:else>
              Inscripción Archivo + Cobro
            </g:else>
            <small>
              <i class="icon-double-angle-right"></i>
              <g:if test="${flash.message}">
                Registrar un cobro unitario o por bloque
              </g:if>
              <g:else>
                Inscripción Archivo de Alumnos y su Padre o Tutor, más a gregar un cobro a los alumnos del archivo
              </g:else>
            </small>
          </h1>
        </div>
          
        <div class="row-fluid">
          <div class="span12">
            <div class="widget-box">
              <div class="widget-header widget-header-blue widget-header-flat"></div>              
              <div class="widget-body">
                <div class="widget-main">
                  <div class="row-fluid">
                    <g:render template="menuArchivoPago" />
                    <hr />
                    <div align="center" id="imagenCarga" class="hidden">
                      <img class="prev" aling="center"  width="60" height="60" src="${resource(dir: 'images', file: 'loading.gif')}" alt="Previous" /> CARGANDO
                    </div>
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
                              <g:if test="${flash.message}">
                                <input type="hidden" name="message" value="${flash.message}"/>
                              </g:if>
                              
                              <input type="hidden" name="camada" value="${camada}" >
                              <input type="hidden" name="listaDependientes" value="${flash.dependientes}">
                              <div class="alert alert-info">
                                <button class="close" data-dismiss="alert" type="button">
                                  <i class="icon-remove"></i>
                                </button>
                                <strong>Nota! </strong>
                                  Sólo puede seleccionar un concepto: cobro unitario o recurrente
                                <br>
                              </div>
                              
                              <div class="row-fluid">
                                
                                <div class="span5">
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto">Concepto</label>
                                    <div class="controls">
                                      <input type="hidden" id="urlConcepto" value="${g.createLink(action:'obtenerEsquemaDePagoPorConcepto', controller:'esquemaDePago')}" />
                                      <div class="input-prepend">
                                        <input type="text" id="conceptoDePago" class="typeahead2" data-provide="typeahead" name="conceptoDePago" placeholder="Concepto" autocomplete="off" >
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
                                        <input type="text" class="cantidadDePago" id="cantidadDePago" name="cantidadDePago" placeholder="0.0">
                                      </div>  
                                    </div>
                                  </div>
                                        
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto">Fecha Vencimiento</label>
                                    <div class="controls">
                                      <div  class="input-append date">
                                        <input id="fechaDeVencimiento" name="fechaDeVencimiento" type="text" class="form-control vencimiento"/>
                                        <span class="add-on">
                                          <i class="icon-calendar"></i>
                                        </span>
                                      </div>
                                    </div>
                                  </div>  
                                </div><!--/ span5 -->
                                
                                <div class="span4">
                                  
                                  <input type="hidden" id="idRecargo" name="idRecargo">
                                  
                                  <input type="hidden" id="idsDescuentos" name="idsDescuentos">                                  
                                  
                                  <label class="hidden cantidadRecargo" >Recargo Cantidad</label>
                                  <input class="hidden cantidadRecargo" id="cantidadRecargo" name="cantidadRecargo" readonly>
                                  
                                  <label class="hidden porcentajeRecargo">Recargo Porcentaje</label>
                                  <input class="hidden porcentajeRecargo" id="porcentajeRecargo" name="recargoPorcentaje" readonly>
                                  
                                  <div class="descuentosDiv">
                                    <!-- TODO Poner estilo en un archivo .css -->
                                    <table class="table hidden cuTable" style="table-layout:fixed;width:100%;word-wrap:break-word;margin-top:10px;">
                                      <thead>
                                        <tr>
                                          <th>Descuento</th>
                                          <th>Importe</th>
                                          <th>Fecha de Vencimiento</th>
                                        </tr>
                                      </thead>
                                      <tbody class="cobroUnitarioDescuentosTableBody">
                                      </tbody>
                                    </table>
                                  </div>
                                
                                </div>
                                
                                <div class="span2">
                                  <div class="descuentoCreado">
                                    <g:render template="/descuento/list", model="[:]" />
                                  </div>
                                  
                                  <div class="recargoCreado" name="recargoCreado">
                                    <g:render template="/recargo/list" />
                                  </div>
                                </div>

                              </div>
                            </g:form>
                          </div>
                          <div id="faq-tab-222" class="tab-pane">
                            <g:form id="pagoGeneracionrecurrente" name="pagoGeneracionrecurrente" controller="esquemaDePago" action="generarPagoParaLaCamada" >
                              <input type="hidden" name="camada" value="${camada}">
                              <input type="hidden" name="listaDependientes" value="${flash.dependientes}">
                              <div class="alert alert-info">
                                <button class="close" data-dismiss="alert" type="button">
                                  <i class="icon-remove"></i>
                                </button>
                                <strong>Nota! </strong>
                                  Sólo puede seleccionar un concepto: cobro unitario o recurrente
                                <br>
                              </div>

                              <div class="row-fluid">
                                <div class="span5">
                                  <div class="control-group">
                                    <label class="control-label" for="txtConcepto">Concepto</label>
                                    <div class="controls">
                                      <div class="input-prepend">
                                        <input type="text" id="conceptoDePagoRecurrente" class="typeahead2" data-provide="typeahead" name="conceptoDePagoRecurrente" placeholder="Concepto" autocomplete="off" >
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
                                        <input type="text" id="cantidadDePagoRecurrente" class="cantidadDePago" name="cantidadDePagoRecurrente" placeholder="0.0">
                                      </div>
                                    </div>
                                  </div> 
                                </div>

                                <div class="span4">
                                  <label class="hidden cantidadRecargoRecurrente">Recargo Cantidad</label>
                                    
                                  <input class="hidden cantidadRecargoRecurrente" name="cantidadRecargo1" readonly>
                                    
                                  <label class="hidden porcentajeRecargoRecurrente">Recargo Porcentaje</label>

                                  <input class="hidden porcentajeRecargoRecurrente" name="recargoPorcentaje1" readonly>

                                  <div class="descuentosDiv">

                                    <table class="table hidden crTable" style="table-layout:fixed;width:100%;word-wrap:break-word;margin-top:10px;">
                                      <thead>
                                        <tr>
                                          <th>Descuento</th>
                                          <th>Importe</th>
                                          <th>Fecha de Vencimiento</th>
                                        </tr>
                                      </thead>
                                      <tbody class="cobroRecurrenteDescuentosTableBody">
                                      </tbody>
                                    </table>

                                  </div>
                                </div>

                                  <div class="span2">
                                    <div  class="descuentoCreado">
                                      <g:render template="/descuento/list", model="[:]" />
                                    </div>
                                    <div class="recargoCreado" name="recargoCreado">
                                      <g:render template="/recargo/list" />
                                    </div>
                                  </div>                                
                              </div>
                              <div class="row-fluid">
                                <div class="span11">
                                  <div class="span2">
                                    <label>
                                      <span class="lbl  blue"> <strong> Meses </strong> </span>
                                    </label>
                                    <label>
                                      <g:checkBox name="meses" value="7" checked="${false}" />
                                    <span class="lbl"> Agosto</span>
                                    </label>
                                    <label>
                                      <g:checkBox name="meses" value="8" checked="${false}" />
                                      <span class="lbl">Septiembre </span>
                                    </label>
                                    <label>
                                      <g:checkBox name="meses" value="9" checked="${false}" />
                                      <span class="lbl"> Octubre </span>
                                    </label>
                                    <label>
                                      <g:checkBox name="meses" value="10" checked="${false}" />
                                      <span class="lbl"> Noviembre</span>
                                    </label>
                                  </div>
                                  
                                  <div class="span2">
                                    <label>
                                      <span class="lbl orange"> Doble </span>
                                    </label>           
                                    <label>
                                      <g:checkBox name="pagoDoble" value="7" checked="${false}"  />
                                      <span class="lbl"> <br> </span>
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
                                          </div>
                                          <div class="span2">
                                            <label>
                                              <span class="lbl  blue"> <strong> Meses </strong> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="11" checked="${false}" />
                                              <span class="lbl"> Diciembre </span>
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
                                          </div>    
                                          <div class="span2">
                                            <label>
                                              <span class="lbl orange"> Doble </span>
                                            </label>                                
                                            <label>
                                              <g:checkBox name="pagoDoble" value="11" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
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
                                          </div>
                                          <div class="span2">
                                            <label>
                                              <span class="lbl  blue"> <strong> Meses </strong> </span>
                                            </label>
                                            <label>
                                              <g:checkBox name="meses" value="3" checked="${false}" />
                                              <span class="lbl"> Abril</span>
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
                                          </div>    
                                          <div class="span1">
                                            <label>
                                              <span class="lbl orange"> Doble </span>
                                            </label>                                
                                            <label>
                                              <g:checkBox name="pagoDoble" value="3" checked="${false}"  />
                                              <span class="lbl"> <br> </span>
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
                                          </div>
                                        </div>
                                      </div>
                                    </g:form>
                                  </div>
                                  
                                  <div id="faq-tab-333" class="tab-pane">
                                    <div class="alert alert-info">
                                      <button class="close" data-dismiss="alert" type="button">
                                        <i class="icon-remove"></i>
                                      </button>
                                      <strong>Nota! </strong>
                                        Sólo puede seleccionar importe o porcentaje de descuento <br>
                                      <strong>Nota! </strong>
                                        Por fecha de vencimiento o dias antes de vencer el pago
                                      <br>
                                    </div>
                                    <div class="row-fluid">    
                                      <g:form class="form-horizontal" name="descuentoForm" url="[controller:'descuento', action:'nuevo']" id="descuentoForm" >
                                        <div class="span5">
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
                                            <div class="input-append date">
                                              <input id="fechaDeVencimientoDesc" name="fechaDeVencimiento" type="text" class="form-control"></input>
                                              <span class="add-on">
                                                <i class="icon-calendar"></i>
                                              </span>
                                            </div>
                                          </div>
                                        </div>             
                                        </div>
                                        <div class="span3">
                                        <div class="control-group">
                                            <div class="input-prepend"> 

                                              <label class="control-label" for="txtConcepto"> Dias antes </label> 
                                              <div class="controls">
                                                <div class="input-prepend">
                                                  <g:select name="diasPreviosParaCancelarDescuento" id="diasPreviosParaCancelarDescuento" from="${1..30}" noSelection="['':'- Dia -']"/>
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
                                            <input class="btn btn-primary" type="submit" id="descuentoButton" name="descuentoButton" value ="Crear Descuento">
                                          </div>
                                        </div>
                                        </div>
                                        <div class="span2">
                                         <div class="descuentoCreado">
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
                                              Sólo puede seleccionar un concepto cobro recurrente o unitario
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
                                                <input class="input-mini" id="recCantidad" name="cantidad" type="text" placeholder="0.0">
                                              </div>
                                            </div>
                                          </div>
                                          <div class="control-group">
                                            <label class="control-label" for="txtConcepto">Porcentaje</label>
                                            <div class="controls">
                                              <div class="input-append">
                                                <input class="input-mini" id="recPorcentaje" name="porcentaje" type="text" placeholder="0.0">
                                                <span class="add-on">%</span>
                                              </div>
                                            </div>
                                          </div>
                                          <div class="contro-group">
                                          <div class="controls">
                                            <input class="btn btn-primary" type="button" id="recargoButton" value ="Crear Recargo">
                                          </div>
                                        </div>
                                      </div>
                                      <div class="span5">
                                        <div class="recargoCreado" name="recargoCreado2">
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
    </div><!--/.main-content-->


      <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-small btn-inverse">
      <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>

    <script id="descuento-template" type="text/x-handlebars-template">
    {{#if this}}
      {{#each this}}
      <tr>
        <td>{{descuento}}</td>
        <td>{{cantidad}}</td>
        <td style="padding-left:0px;">
          <input type="text" class="expiracionDescuento" style="width:100%;" name="fechasDeExpiracionDescuento[{{@index}}]" />
          <input type="hidden" value="{{id}}" name="idDescuento[{{@index}}]" />
        </td>
      </tr>    
      {{/each}}
    {{else}}
      <tr>
        <td colspan="3">
          El concepto no tiene descuentos.
        </td>
      </tr> 
    {{/if}}
    </script>

  </body>
</html>
