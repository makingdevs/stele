<!DOCTYPE html>
<%@ page import="com.stele.EstatusDePago" %>
<html>
  <head>
    <meta name="layout" content="twitterBootstrap"/>
    <title>Informacion del pago</title>
    <r:require module="pagosParaCamada" />
  </head>

  <body>

  <div class="page-header">
    <h1><i class="icon-info"></i> · Informaci&oacuten del pago <small></small></h1>
  </div>
  <div class="row">
    <div class="span7">
      <iframe src="${pago.comprobanteDePago.url()}"  width="100%" height="450px" ></iframe>  
    </div>
    <div class="span4 well">
      <g:if test="${pago.estatusDePago == EstatusDePago.PROCESO }">
        <g:render template="conciliacion" model="[pago : pago, perfil : perfil]" />
      </g:if>
      <g:if test="${pago.estatusDePago == EstatusDePago.PAGADO }">
        <g:render template="detalle" model="[pago : pago, perfil : perfil]" />
      </g:if>
    </div>
  </div>
  </body>
</html>
