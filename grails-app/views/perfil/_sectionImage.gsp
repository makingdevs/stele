<div id="photoSection">
  <input type="hidden" value="${createLink(controller:'perfil', action:'uploadImage', id: usuario.id)}" id="url" />
  <g:if test="${usuario.avatar}">
    <img  src="${usuario.avatar.url()}" width="100" height="500" id="imagenPrincipal" /><p></p>
    <g:remoteLink action="removeImageProfile" controller="perfil" id="${usuario.id}" update="photoSection" params="[id:"${usuario.id}"]"><i class="icon-remove"></i></g:remoteLink>  
  </g:if>
  <g:else> 
    <input type="file" id="imagenAdministrador" class="dropzone" />
  </g:else>
  <div class="space-4"></div>
  <div class="width-80 label label-info label-large arrowed-in arrowed-in-right">
    <div class="inline position-relative">
      <span class="white middle bigger-120">
        ${usuario.nombre} ${usuario.apellidoPaterno} ${usuario.apellidoMaterno}
      </span>
    </div>
  </div>
</div>