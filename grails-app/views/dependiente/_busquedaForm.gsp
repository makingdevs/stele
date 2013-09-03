<g:formRemote name="busquedaDependientes" update="dependientes" url="[controller: 'dependiente', action:'search']">
  <label>
    Turno del Dependiente 
  </label>
  <g:select name="turno" from="${turnos}" noSelection="['':'- Selecciona el turno-']" onchange="${remoteFunction(controller:'Dependiente', action:'ajaxTurnoANivel', params:'\'turno=\' + escape(this.value)',update:'busquedaForm')}" value="${turno}"/>
  <label>
    Nivel del Dependiente 
  </label>
  <g:select name="nivel" from="${niveles}" noSelection="['':'- Selecciona el Nivel-']" onchange="${remoteFunction(controller:'Dependiente', action:'ajaxNivelAGrado', params:'\'nivel=\' + escape(this.value)',update:'busquedaForm')}" value="${nivel}"/>
  <label>
    Grado del Dependiente
  </label>
  <g:select name="grado" from="${grados}" noSelection="['':'- Selecciona el Grado-']" onchange="${remoteFunction(controller:'Dependiente', action:'ajaxGradoAGrupo', params:'\'grado=\' + escape(this.value)',update:'busquedaForm')}" value="${grado}"/>
  <label>
    Grupo del Dependiente 
  </label>
  <g:select name="grupo" from="${grupos}" noSelection="['':'- Selecciona el Grupo-']" onchange="${remoteFunction(controller:'Dependiente', action:'ajaxGrupo', params:'\'grupo=\' + escape(this.value)',update:'busquedaForm')}" value="${grupo}"/>
  <br/>
  <button type="submit" class="btn btn-primary btn-large" >Buscar </button>

</g:formRemote>