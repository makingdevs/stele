<%@ page import="com.makingdevs.TipoDeTelefono" %>
<h4>Mis teléfonos de contacto</h4>
<table class="table">
  <thead>
    <tr>
      <th>Principal</th>
      <th>Tipo</th>
      <th>Lada</th>
      <th>Numero</th>
      <th>Ext</th>
      <th>&nbsp;</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${telefonos?.sort({ it.id })}" var="t">
      <tr>
        <td>
          <g:if test="${t.principal}">
            <i class="icon-ok"></i>
          </g:if>
        </td>
        <td> 
          <g:if test="${t.tipoDeTelefono == TipoDeTelefono.CASA}">
            <i class="icon-phone-sign"></i> 
          </g:if>
          <g:if test="${t.tipoDeTelefono == TipoDeTelefono.CELULAR}">
            <i class="icon-mobile-phone"></i> 
          </g:if>
          <g:if test="${t.tipoDeTelefono == TipoDeTelefono.TRABAJO}">
            <i class="icon-briefcase"></i> 
          </g:if>
          <g:if test="${t.tipoDeTelefono == TipoDeTelefono.RECADOS}">
            <i class="icon-phone"></i> 
          </g:if>
          ${t.tipoDeTelefono}
        </td>
        <td> ${t.lada} </td>
        <td> ${t.numeroTelefonico} </td>
        <td> ${t.extension} </td>
        <td style="text-align:center;">
          <div class="btn-group">
            <g:remoteLink id="${t.id}" class="btn btn-warning"><i class="icon-edit icon-white"></i></g:remoteLink>
            <g:remoteLink id="${t.id}" class="btn btn-danger"><i class="icon-trash icon-white"></i></g:remoteLink>
          </div>
        </td>
      </tr>
    </g:each>
    <tr id="agregar">
      <td>
        <label class="checkbox">
          <g:checkBox name="principal" />
        </label>
      </td>
      <td>
        <g:select class="input-small" name="tipoDeTelefono" from="${TipoDeTelefono.values()}" optionKey="key"/>
      </td>
      <td>
        <input type="text" class="input-mini" maxlength="3" name="lada"></input>
      </td>
      <td>
        <input type="text" class="input-small" maxlength="10" name="numeroTelefonico"></input>
      </td>
      <td>
        <input type="text" class="input-mini" maxlength="6" name="extension"></input>
      </td>
      <td style="text-align:center;">
        <button class="btn btn-primary">
          <i class="icon-plus-sign icon-white"></i>
        </button>
      </td>
    </tr>
  </tbody>
</table>
