<g:formRemote name="busquedaDependientes" update="dependientes" url="[controller: 'dependiente', action:'search']">
<div class="span3 widget-container-span">
  <div class="widget-box">
    <div class="widget-header">
      <h5>Búsqueda</h5>
    </div>
    <div class="widget-body">
      <div class="widget-main">
        <div class="control-group">
          <label class="control-label" for="selectGrupo">Turno</label>
          <div class="controls">
            <input type="hidden" name="getNivelUrl" value="${g.createLink(action:'ajaxTurnoANivel', controller:'utilidades')}" /> 
            <g:select name="turno" id="turno" from="${turnos}" noSelection="['':'-Selecciona el Turno-']" />
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="selectNivel">Nivel</label>
          <div class="controls">
            <input type="hidden" name="getGrupoUrl" value="${g.createLink(action:'ajaxNivelAGrado', controller:'utilidades')}" />
            <g:select name="nivel" from="${niveles}" noSelection="['':'-Selecciona el Nivel-']" />
         </div>
       </div>  
       <div class="control-group">
        <label class="control-label" for="selectNivel">Grado</label>
        <div class="controls">
          <g:select name="grado" from="${grados}" noSelection="['':'-Selecciona el Grado-']" />
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="selectNivel">Grupo</label>
        <div class="controls">
          <g:select name="grupo" from="${grupos}" noSelection="['':'- Selecciona el Grupo-']" onchange="${remoteFunction(controller:'Utilidades', action:'ajaxGrupo', params:'\'grupo=\' + escape(this.value)',update:'busquedaForm')}" value="${grupo}"/>
        </div>
      </div>  
    </div>
    <div class="widget-toolbox padding-8 clearfix center">
      <button type="submit" class="btn  btn-info" >
        Agregar
        <i class="icon-arrow-right icon-on-right"></i>
      </button>
      <button type="reset" class="btn btn-info">
        Limpiar
      </button>
    </div>
  </div>
</div>
</div>
</g:formRemote>

<script id="nivel-template" type="text/x-handlebars-template">
    <option value="">-Selecciona el Nivel-</option>
    {{#each this}}
      <option value="{{this}}">{{this}}</option> 
    {{/each}}
</script>

<script id="grado-template" type="text/x-handlebars-template">
  <option value="">-Selecciona el Grado-</option>
  {{#each this}}
    <option value="{{this}}">{{this}}</option> 
  {{/each}}
</script>
