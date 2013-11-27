<%@ page import="com.makingdevs.TipoDeTelefono" %>
<g:formRemote name="telefonoAsync" update="listaTelefono" url="[controller:'telefono', action:'agregarTelefonoAsync']">
<div class="row-fluid">
  <div class="span12" id="listaTelefono">
    <div class="span4">
     <div class="profile-user-info profile-user-info-striped">
       <div class="profile-info-row ">
         <div class="profile-info-name"> 
           <i class="icon-phone"></i>
           Telefono 
         </div>
         <div class="profile-info-value  align-left">
           <input type="text" class="input-mini" maxlength="3" name="lada" placeholder="Lada"></input>
         </div>
         <div class="profile-info-value  align-left">
           <input type="text" class="input-small" maxlength="10" name="numeroTelefonico" placeholder="Numero"></input>
         </div>
         <div class="profile-info-value  align-left">
           <input type="text" class="input-mini" maxlength="6" name="extension" placeholder="Ext"></input>
         </div>
       </div>
       <div class="profile-info-row">
        <div class="profile-info-name"> Tipo </div>
        <div class="profile-info-value">
          <g:select class="input-small" name="tipoDeTelefono" from="${TipoDeTelefono.values()}" optionKey="key"/>
          <label class="checkbox">
            <g:checkBox name="principal" /> Principal
          </label>
        </div>
      </div>
      <div class="profile-info-row">
       <div class="profile-info-name">  </div>
       <div class="profile-info-value center">
        <button class="btn btn-primary">
          <i class="icon-plus-sign icon-white"></i>
        </button>
        </div>
      </div>
      </div>
    </div>
    <div class="span8" id="listaTelefono" name="listaTelefono">
      <table id="sample-table-1" class="table table-striped table-bordered table-hover">
       <thead >
         <tr>
           <th class="center">
             <i class="icon-ok-circle blue"></i>
             Principal 
           </th>
           <th>
             <i class="icon-bookmark-empty blue"></i>
             Tipo
           </th>
           <th>
             <i class="icon-phone blue"></i>
             Telefono
           </th> <th>                  
         </tr>
       </thead>
       <tbody>
        <g:each in="${telefonos?.sort({ it.id })}">
          <tr>
            <td class="center">
              <g:if test="${it.principal == true}">
              <i class="icon-phone bigger-125 blue"></i>
            </g:if>
            </td>
            <td class="center">
              ${it.tipoDeTelefono}
            </td>
            <td class="center">
              (${it.lada ?: " - "}) ${it.numeroTelefonico} Ext. ${it.extension ?: " - "}
            </td>
            <td>
              <g:remoteLink id="${it.id}" class="danger" controller="telefono" action="borrarTelefonoASync" update="listaTelefono"><i class="icon-trash icon-white"></i></g:remoteLink>
            </td>
          </tr>
        </g:each>
       </tbody>
      </table>
    </div>
  </div>
</div>
</g:formRemote>