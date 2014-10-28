<div class="row-fluid">    
  <%-- TODO Externalizar estilo css a un archivo .css --%>
  <g:form id="pagoGeneracionrecurrente" name="pagoGeneracionrecurrente" controller="esquemaDePago" action="generarPagoParaLaCamada" style="margin-bottom:0px">
    <div class="span3">
      <input type="hidden" name="camada" value="${camada}" />
      <input type="hidden" id="recargoRecurrente" name="idRecargo" />
      <input type="hidden" name="listaDependientes" value="${listaDependientes}" />

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
        <label class="control-label" for="txtConcepto"> Día del mes de vencimiento</label>
        <div class="controls">
          <div class="input-prepend">
            <g:select  id="diasVencimientoPago" name="diasVencimientoPago" from="${1..lastDayOfTheMonth}" noSelection="['':'- Dia -']"/> 
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

      <div class="descuentosIdsRecurrente">
      </div>
      
      <div class="meses">
      </div>

      <div class="cobroDoble">      
      </div>

    </div>
    
    <div class="span6 discountsFromPaymentSchemaRecurrente" style="display:none">      
      <div class="row-fluid">
        <div class="descuentosDiv span8">
          <!-- TODO Poner estilo en un archivo .css -->
          <table class="table" style="table-layout:fixed;width:100%;word-wrap:break-word;margin-top:10px;">
            <thead>
              <tr>
                <th>Descuento</th>
                <th>Importe</th>
                <th>Día de Vencimiento</th>
              </tr>
            </thead>
            <tbody class="cobroRecurrenteDescuentosTableBody">
            </tbody>
          </table>
          <script id="descuentoRecurrente-template" type="text/x-handlebars-template">
            {{#if this}}
            {{#each this}}
            <tr>
              <td>{{descuento}}</td>
              <td>{{cantidad}}</td>
              <td style="padding-left:0px;">
                <g:select disabled="${true}" class="diaVencimientoDescuento" name="diasVencimientoDescuento[{{@index}}]" from="[]" noSelection="['':'- Dia -']" style="width:100%;"/>                    
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
          <script id="diaVencimiento-template" type="text/x-handlebars-template">
            <option value="{{number}}">{{number}}</option>  
          </script>
        </div>
        <div class="recargosRecurrentesDiv  span3">
        <!-- TODO Poner estilo en un archivo .css -->
          <table class="table hidden rTable" style="margin-top:10px;">
            <thead>
              <tr>
                <th>Recargo</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>
                  <p class="hidden cantidadRecargoRecurrente" id="cantidadRecargoRecurrente"><span class="hidden cantidadRecargoRecurrente" >$</span></p>
                  <p class="hidden porcentajeRecargoRecurrente" id="porcentajeRecargoRecurrente"><span class="hidden porcentajeRecargoRecurrente">%</span></p>
                </td>
              </tr>
            </tbody>          
          </table>
        </div>
      </div>
    </div>   
  </g:form>

  <div class="span6 tabsRecurrente">
    <div id="tabsRecurrente">
      <ul class="nav nav-tabs padding-10">
        <li class="active">
          <a data-toggle="tab" href="#faq-tab-555">
            <i class="green icon-tag bigger-120"></i>
            Descuento
          </a>
        </li>
        <li>
          <a data-toggle="tab" href="#faq-tab-666">
            <i class="red icon-sort-by-attributes icon-flip-vertical bigger-120"></i>
            Recargo
          </a>
        </li>
      </ul>
      <div class="tab-content">
        <div id="faq-tab-555" class="tab-pane active">
          <div class="alert alert-info">
            <button class="close" data-dismiss="alert" type="button">
              <i class="icon-remove"></i>
            </button>
            <strong>Nota! </strong>
              Sólo puede seleccionar importe o porcentaje de descuento <br>
            <strong>Nota! </strong>
              Seleccionar fecha de vencimiento o dias antes de vencer el pago
            <br/>
          </div>
          <div class="row-fluid">
            <g:form url="[controller:'descuento', action:'nuevo']" name="descuentoRecurrenteForm" id="descuentoRecurrenteForm">
            <div class="span6">
              <div class="control-group">
                <label class="control-label" for="txtConcepto"> Descuento </label>
                <div class="controls">
                  <input type="hidden" id="urlDescuento" value="${g.createLink(action:'obtenerDescuentosInstitucion',controller:'descuento')}" />
                  <div class="input-prepend">
                    <input type="text" id="nombreDeDescuentoRecurrente" name="discountName" class="typeahead2" data-provide="typeahead" placeholder="Nombre" autocomplete="off">
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
                    <input class="input-medium" id="cantidadRecurrente" name="amount" type="text" placeholder="0.0">
                  </div>
                </div>
              </div>

              <div class="control-group">
                <label class="control-label" for="txtConcepto">Día de Vencimiento</label>
                <div class="controls">
                <div class="input-prepend diaVencimientoDescuentoDiv">                  
                  <g:select disabled="${true}" id="diaVencimientoDescuento" class="diaVencimientoDescuento" name="diaVencimientoDescuento" from="[]" noSelection="['':'- Dia -']" /> 
                </div>
                </div>                
              </div>              
            </div>

            <div class="span6">
              <div class="control-group">
                <div class="input-prepend">
                  <label class="control-label" for="txtConcepto"> Dias antes </label> 
                  <div class="controls">
                    <div class="input-prepend">
                      <g:select id="diasPreviosParaCancelarDescuentoRecurrente" name="previousDaysForCancelingDiscount" from="${0..lastDayOfTheMonth}" noSelection="['':'- Dia -']"/>
                    </div>
                  </div>
                </div>
              </div>
              
              <div class="control-group">
                <div class="input-append">
                  <label class="control-label" for="txtConcepto"> Procentaje </label>
                  <div class="controls">
                    <input type="text" class="input-mini" id="porcentajeRecurrente" name="percentage" placeholder="0.0">
                    <span class="add-on">%</span>
                  </div>
                </div>
              </div>

              <div class="contro-group">
                <div class="controls">
                  <input class="btn btn-primary" type="submit" id="descuentoRecurrenteButton" name="descuentoButton" value ="Crear Descuento">
                </div>
              </div>
            </div>
            <div class="descuentosIdsRecurrente">
            </div>
            </g:form>
          </div>
        </div>
      
          <div id="faq-tab-666" class="tab-pane">
            <div class="row-fluid">
              <g:form name="recargoRecurrenteForm" url="[controller:'recargo',action:'nuevo']" id="recargoRecurrenteForm">
              <div class="span6">                
                <div class="control-group">
                  <label class="control-label" for="txtConcepto">Importe</label>
                  <div class="controls">
                    <div class="input-prepend">
                      <span class="add-on">
                        <i class="icon-usd"></i>
                      </span>
                      <input class="input-mini" id="recargoRecurrenteCantidad" name="amount" type="text" placeholder="0.0">
                    </div>
                  </div>
                </div>                
                <div class="control-group">
                  <label class="control-label" for="txtConcepto">Porcentaje</label>
                  <div class="controls">
                    <div class="input-append">
                      <input class="input-mini" id="recargoRecurrentePorcentaje" name="percentage" type="text" placeholder="0.0">
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

              <div class="span4">
                <div class="listaRecargosRecurrentes">                  
                </div>
              </div>              
              </g:form>
            </div>
          </div>
        </div>
      
      </div>
    </div>

    <div class="span3">
      <div class="descuentoRecurrenteCreado">
        <g:render template="/descuento/list", model="[:]" />
      </div>    
    </div>        

</div>
  
<div class="row-fluid">
  <div class="span11">    
    <div class="span2">
      <label>
        <span class="lbl  blue"> <strong> Meses </strong> </span>
      </label>
      <g:each var="i" in="${0..3}">
        <label>
          <g:checkBox name="meses" value="${(i+7) % 12}" checked="${false}" />
          <span class="lbl">${months[i]}</span>
        </label>
      </g:each>
    </div>
                                  
    <div class="span2">
      <label>
        <span class="lbl orange"> Doble </span>
      </label>
      <g:each var="i" in="${0..3}">
        <label>
          <g:checkBox name="pagoDoble" value="${(i+7) % 12}" checked="${false}"  />
          <span class="lbl"> <br> </span>
        </label>          
      </g:each>
    </div>
                                          
    <div class="span2">
      <label>
        <span class="lbl  blue"> <strong> Meses </strong> </span>
      </label>
        
      <g:each var="i" in="${4..7}">
        <label>
          <g:checkBox name="meses" value="${(i+7) % 12}" checked="${false}" />
            <span class="lbl">${months[i]}</span>
        </label>
      </g:each>
    </div>
      
    <div class="span2">
      <label>
        <span class="lbl orange"> Doble </span>
      </label>

      <g:each var="i" in="${4..7}">
        <label>
          <g:checkBox name="pagoDoble" value="${(i+7) % 12}" checked="${false}" />
            <span class="lbl"> <br> </span>
        </label>
      </g:each>
    </div>
      
    <div class="span2">
      <label>
        <span class="lbl  blue"> <strong> Meses </strong> </span>
      </label>
      <g:each var="i" in="${8..11}">
        <label>
          <g:checkBox name="meses" value="${(i+7) % 12}" checked="${false}" />
          <span class="lbl">${months[i]}</span>
        </label>
      </g:each>
    </div>
      
    <div class="span1">
      <label>
        <span class="lbl orange"> Doble </span>
      </label>
      <g:each var="i" in="${8..11}">
      <label>
        <g:checkBox name="pagoDoble" value="${(i+7) % 12}" checked="${false}" />
          <span class="lbl"> <br> </span>
      </label>
      </g:each>
    </div>
  </div>
</div>

<script id="meses-template" type="text/x-handlebars-template">
  {{#each this}}
    <input type="hidden" value="{{mes}}" name="meses"/>
  {{/each}}
</script>
<script id="cobroDoble-template" type="text/x-handlebars-template">
  {{#each this}}
    <input type="hidden" value="{{mes}}" name="pagoDoble"/>
  {{/each}}
</script>



