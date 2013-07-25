<%@ page import="com.stele.EstatusDePago" %>
<div class="container-fluid">
  <div class="row-fluid">
      <dl>
        <dt>Nombre del Alumno :</dt><dd>${perfil.nombre} ${perfil.apellidoPaterno} ${perfil.apellidoMaterno}</dd>
        <dt>Concepto :</dt><dd> ${pago.conceptoDePago}</dd>
        <dt>Fecha que adjunto el comprobante :</dt><dd>${pago.lastUpdated.format('yyyy-MMM-dd')}</dd>
        <dt>Fecha Vencimiento :</dt><dd> ${pago.fechaDeVencimiento.format('yyyy-MMM-dd')}</dd>
        <dt>Total :</dt><dd> <i class="icon-dollar"></i>${pago.cantidadDePago}</dd>
        <dt>Fecha de Pago: </dt><dd> ${pago.fechaDePago.format('yyyy-MMM-dd')}</dd>
        <dt>Tipo de Pago: </dt><dd>${pago.tipoDePago}</dd>
      </dl>
    </div>
  </div>
</div>