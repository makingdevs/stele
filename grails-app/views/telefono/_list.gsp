<%@ page import="com.stele.TipoDeTelefono" %>

<table class="table table-bordered table-condensed">
  <thead style="background-color:whiteSmoke">
    <tr>
    <th colspan="6" style="text-align:left; vertical-align:middle; color:blue;"> 
        Teléfono 
      </th>
    </tr>
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
        <td> ${t.principal} </td>
        <td> ${t.tipoDeTelefono} </td>
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
