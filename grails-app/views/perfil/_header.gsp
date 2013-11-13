<div class="span3 center">
  <img  src="${usuarioActual.perfil.avatar}"   width="120" height="120" />
  <div class="row-fluid">
    <div class="width-50 label label-info  arrowed-in arrowed-in-right">
      <span class="white middle bigger-120">${usuarioActual.perfil.nombre} ${usuarioActual.perfil.apellidoPaterno} ${usuarioActual.perfil.apellidoMaterno}</span>             
    </div>  
  </div>
</div>
<g:each in="${perfil}">
<div class="span2 center">
  <img  src="${it.avatar}"   width="100" height="100" />
  <div class="row-fluid">           
    <div class="width-50 label  label-grey">
      <span class="white middle bigger-120">${it.nombre} ${it.apellidoPaterno} ${it.apellidoMaterno}</span>              
    </div>  
  </div>
</div>
</g:each>