<div class="row-fluid wizard-actions">
  <button class="btn btn-prev">
    <i class="icon-arrow-left"></i>
    Previo
  </button>
  <button class="btn btn-success btn-next">
    Siguiente
    <i class="icon-arrow-right icon-on-right"></i>
  </button>
</div>
<g:set var="proceso" value="false" scope="flash" />
<div id="fuelux-wizard" class="row-fluid" data-target="#step-container">
  <ul class="wizard-steps">
    <li data-target="#step1" class="complete" style="min-width: 25%; max-width: 25%;">
      <span class="step">1</span>
      <span class="title">Importe el archivo</span>
    </li>

    <li data-target="#step2" class="complete" style="min-width: 25%; max-width: 25%;">
      <span class="step">2</span>
      <span class="title">Verifique</span>
    </li>

    <li data-target="#step3" class="active" style="min-width: 25%; max-width: 25%;"> 
      <span class="step">3</span>
      <span class="title">Procesar Incripción</span>
    </li>

    <li data-target="#step4" style="min-width: 25%; max-width: 25%;">
      <span class="step">4</span>
      <span class="title">Resultado</span>
    </li>
  </ul>
  </ul>
</div>