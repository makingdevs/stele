<%@ page import="com.stele.EstatusDePago" %>
<div class="container-fluid">
  <div class="row-fluid">
    <g:form id="conciliacion" name="conciliacion" controller="comprobante" action="validarComprobante">
      <dl>
        <dt>Nombre del Alumno :</dt><dd>${perfil.nombre} ${perfil.apellidoPaterno} ${perfil.apellidoMaterno}</dd>
        <dt>Concepto :</dt><dd> ${pago.conceptoDePago}</dd>
        <dt>Fecha que adjunto el comprobante :</dt><dd>${pago.lastUpdated.format('yyyy-MMM-dd')}</dd>
        <dt>Fecha Vencimiento :</dt><dd> ${pago.fechaDeVencimiento.format('yyyy-MMM-dd')}</dd>
        <dt>Total :</dt><dd> <i class="icon-dollar"></i>${pago.cantidadDePago}</dd>
        <dt>Fecha de Pago: </dt>
          <dd>
            <div class"controls">
              <g:datePicker name="fechaDeVencimiento" value="${new Date()}" precision="day" />
            </div>
          </dd>
        <dt>Tipo de Pago: </dt>
          <dd>
            <p>
            <select class="selectpicker" name="tipoPago">
              <option values="TRANSFERENCIA_BANCARIA">Transferencia Bancaria</option>
              <option value="FICHA_REFERENCIADA">Ficha Referenciada</option>
              <option value="CHEQUE_FICHA">Cheque Ficha</option> 
              <option value="EFECTIVO">Efectivo</option>    
              <option value="TERMINAL">Terminal</option>   
            </select>
            </p>
          </dd>
        <dt>Folio Banco</dt><dd><input type="text" id="folioBanco" name="folioBanco"></dd> 
      </dl>
        <div class="btn-group">
          <button type="submit" class="btn btn-success"><i class="icon-thumbs-up-alt"></i> Aprobar</button>
          <button type="button" class="btn btn-danger"><i class="icon-thumbs-down-alt"></i> Rechazar</button>
        </div>
    </g:form>
  </div>
</div>