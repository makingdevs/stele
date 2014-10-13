<div class="row-fluid wizard-actions">
  <g:if test="${listaUsuariosProcesados}">
    <g:link controller="esquemaDePago" action="paraCamada" class="btn btn-success" params="[camada:camadaGenerada, dependientes: listaUsuariosProcesados]">
      Siguiente
      <i class="icon-arrow-right icon-on-right"></i>
    </g:link>
  </g:if>
  <g:else>
  <button class="btn btn-prev" disabled>
    <i class="icon-arrow-right"></i>
    Siguiente 
  </button>
  </g:else>
</div>
<g:set var="proceso" value="true" scope="flash" />
<g:hiddenField name="camada" value="${camadaGenerada}" />
<g:hiddenField name="listaDeUsuarios" value="${listaUsuariosProcesados}" />
<div id="fuelux-wizard" class="row-fluid " data-target="#step-container">
	<ul class="wizard-steps">
		<li data-target="#step1" class="complete" style="min-width: 16.666%; max-width: 16.666%;">
			<span class="step">1</span>
			<span class="title">Importe el archivo</span>
		</li>

		<li data-target="#step2" class="complete" style="min-width: 16.666%; max-width: 16.666%;">
			<span class="step">2</span>
			<span class="title">Verifique</span>
		</li>

		<li data-target="#step3" class="complete" style="min-width: 16.666%; max-width: 16.666%;">	
			<span class="step">3</span>
			<span class="title">Procesar Inscripción</span>
		</li>

		<li data-target="#step4" class="active" style="min-width: 16.666%; max-width: 16.666%;">
			<span class="step">4</span>
			<span class="title">Resultado</span>
		</li>

		<li data-target="#step5" style="min-width: 16.666%; max-width: 16.666%;">
			<span class="step">5</span>
			<span class="title">Cobro</span>
		</li>
		<li data-target="#step6" style="min-width: 16.666%; max-width: 16.666%;">
			<span class="step">6</span>
			<span class="title">Procesar Cobro</span>
		</li>													
	</ul>
	</ul>
</div>
