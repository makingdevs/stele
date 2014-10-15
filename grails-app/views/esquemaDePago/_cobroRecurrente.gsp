<g:form id="pagoGeneracionrecurrente" name="pagoGeneracionrecurrente" controller="esquemaDePago" action="generarPagoParaLaCamada" >
  <input type="hidden" name="camada" value="${camada}">
  <input type="hidden" name="listaDependientes" value="${listaDependientes}">
  <div class="alert alert-info">
    <button class="close" data-dismiss="alert" type="button">
      <i class="icon-remove"></i>
    </button>
    <strong>Nota! </strong>
      Sólo puede seleccionar un concepto: cobro unitario o recurrente<br>
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
</g:form>
                            