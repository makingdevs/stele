<g:if test="${flash.message}">
  <input type="hidden" name="message" value="${flash.message}"/>
</g:if>
  
<div class="row-fluid">    
  <g:form id="cobroUnitarioForm" name="cobroUnitarioForm" controller="esquemaDePago" action="generarPagoParaLaCamada" >
    <div class="span3">
      <input type="hidden" name="camada" value="${camada}" />
      <input type="hidden" id="recargoUnitario" name="idRecargo" />
      <input type="hidden" name="listaDependientes" value="${listaDependientes}">

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
        <label class="control-label" for="cantidadDePago">Importe</label>
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
        <label class="control-label" for="fechaDeVencimiento">Fecha Vencimiento</label>
        <div class="controls">
          <div  class="input-append date">
            <input id="fechaDeVencimiento" name="fechaDeVencimiento" type="text" class="form-control vencimiento"/>
            <span class="add-on">
              <i class="icon-calendar"></i>
            </span>
          </div>
        </div>
      </div>

      <div class="descuentosIdDiv">
      </div>

    </div><!--/ span3 -->
    <div class="span6 discountsFromPaymentSchema">      
      <div class="row-fluid">
        <div class="descuentosDiv span8">
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
      
        <div class="recargosDiv span3">
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
                  <p class="hidden cantidadRecargo" id="cantidadRecargo"><span class="hidden cantidadRecargo" >$</span></p>
                  <p class="hidden porcentajeRecargo" id="porcentajeRecargo" name="recargoPorcentaje"><span class="hidden porcentajeRecargo">%</span></p>
                </td>
              </tr>
            </tbody>          
          </table>
        </div>
      </div>
    </div>
  </g:form>

    <div class="span6 tabs">
      <div id="tabsUnitario">
        <ul class="nav nav-tabs padding-10">
          <li class="active">
            <a data-toggle="tab" href="#faq-tab-333">
              <i class="green icon-tag bigger-120"></i>
              Descuento
            </a>
          </li>
          <li>
            <a data-toggle="tab" href="#faq-tab-444">
              <i class="red icon-sort-by-attributes icon-flip-vertical bigger-120"></i>
              Recargo
            </a>
          </li>
        </ul>
        <div class="tab-content">
          <div id="faq-tab-333" class="tab-pane active">
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
              
              <g:form url="[controller:'descuento', action:'nuevo']" name="descuentoUnitarioForm" id="descuentoUnitarioForm">
              <div class="span6">
                <div class="control-group">
                  <label class="control-label" for="txtConcepto"> Descuento </label>
                  <div class="controls">
                    <input type="hidden" id="urlDescuento" value="${g.createLink(action:'obtenerDescuentosInstitucion',controller:'descuento')}" />
                    <div class="input-prepend">
                      <input type="text" id="nombreDeDescuento" name="discountName" class="typeahead2" data-provide="typeahead" placeholder="Nombre" autocomplete="off">
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
                      <input class="input-medium" id="cantidad" name="amount" type="text" placeholder="0.0">
                    </div>
                  </div>
                </div>

                <div class="control-group">
                  <label class="control-label" for="txtConcepto">Fecha Vencimiento</label>
                  <div class="controls">                  
                    <div class="input-append date">
                      <input type="text" id="fechaDeVencimientoDesc" name="expirationDacontrol" />
                      <span class="add-on">
                        <i class="icon-calendar"></i>
                      </span>
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
                        <g:select name="previousDaysForCancelingDiscount" id="diasPreviosParaCancelarDescuento" from="${0..lastDayOfTheMonth}" noSelection="['':'- Dia -']"/>
                      </div>
                    </div>
                  </div>
                </div>
              
                <div class="control-group">
                  <div class="input-append">
                    <label class="control-label" for="txtConcepto"> Procentaje </label>
                    <div class="controls">
                      <input type="text" class="input-mini" id="porcentaje" n  placeholder="0.0">
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
              <div class="descuentosIdDiv">                
              </div>
              </g:form>
              
            </div>
          </div>
          <div id="faq-tab-444" class="tab-pane">
            <div class="row-fluid">            
              <g:form name="recargoForm" url="[controller:'recargo',action:'nuevo']" id="recargoForm">
              <div class="span6">                
                <div class="control-group">
                  <label class="control-label" for="txtConcepto">Importe</label>
                  <div class="controls">
                    <div class="input-prepend">
                      <span class="add-on">
                        <i class="icon-usd"></i>
                      </span>
                      <input class="input-mini" id="recCantidad" name="amount" type="text" placeholder="0.0">
                    </div>
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="txtConcepto">Porcentaje</label>
                  <div class="controls">
                    <div class="input-append">
                      <input class="input-mini" id="recPorcentaje" name="percentage" type="text" placeholder="0.0">
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
                <div class="listaRecargos">                  
                </div>
              </div>
              </g:form> 
            </div>
          </div>
        </div>
        <input type="hidden" id="idsDescuentos" name="idsDescuentos">
      </div>
    </div>
    <div class="span3">      
      <div class="descuentoCreado">
        <g:render template="/descuento/list", model="[:]" />
      </div>
    </div>
</div>



