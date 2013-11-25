<%@ page import="com.payable.EstatusDePago" %>
<%@ page import="com.payable.TipoDePago" %>
<div class="container-fluid">
  <div class="row-fluid">
    <g:form id="conciliacion" name="conciliacion" controller="comprobante" action="validarComprobante">
      <dl>
        <dt>Nombre del Alumno :</dt><dd>${perfil.nombre} ${perfil.apellidoPaterno} ${perfil.apellidoMaterno}</dd>
        <dt>Concepto :</dt><dd> ${pago.conceptoDePago}</dd>
        <dt>Fecha que adjunto el comprobante :</dt><dd>${pago.lastUpdated.format('yyyy-MMM-dd')}</dd>
        <dt>Fecha Vencimiento :</dt><dd> ${pago.fechaDeVencimiento.format('yyyy-MMM-dd')}</dd>
        <dt>Total :</dt><dd> <i class="icon-dollar"></i>${pago.cantidadDePago}</dd>
      <sec:ifAllGranted roles="ROLE_DIRECTOR">
        
        <dt>Fecha de Pago: </dt>
          <dd>
            <div class"controls">
              <g:datePicker name="fechaPago" value="${new Date()}" precision="day" />
            </div>
          </dd>
        <dt>Tipo de Pago: </dt>
          <dd>
            <p>
              <g:select id="tipoDePago" name="tipoDePago" from="${TipoDePago.values()}" optionKey="key" />
            </p>
          </dd>
        <dt>Folio Banco</dt><dd><input type="text" id="folioBanco" name="folioBanco"></dd> 
      </dl>
      <input type="hidden" id="transactionId" name="transactionId" value="${pago.transactionId}">
        <div class="btn-group">
          <button type="submit" class="btn btn-success"><i class="icon-thumbs-up-alt"></i> Aprobar</button>
          <g:link controller="comprobante" action="rechazarPago" params="[transactionId: "${pago.transactionId}"]" ><button type="button" class="btn btn-danger"><i class="icon-thumbs-down-alt"></i> Rechazar</button></g:link>
        </div>
      </sec:ifAllGranted>
    </g:form>
  </div>
</div>