<g:form controller="descuento" action="nuevo" class="form-horizontal">
  <div class="control-group">
    <label for="nombreDeDescuento" class="control-label">Nombre de descuento  : </label>
    <div class="controls">
      <input type="text" id="nombreDeDescuento" name="nombreDeDescuento" class="input-xxlarge" placeholder="Nombre de descuento">
    </div>
  </div>

  <div class="control-group">
    <label for="porcentaje" class="control-label">Porcentaje  : </label>
    <div class="controls">
      <div class="input-append">
        <input class="input-mini" id="porcentaje" name="porcentaje" type="text" placeholder="0.0">
        <span class="add-on">%</span>
      </div>
    </div>
  </div>

  <div class="control-group">
    <label for="cantidad" class="control-label">Cantidad  : </label>
    <div class="controls">
      <div class="input-prepend">
        <span class="add-on">$</span>
        <input class="input-mini" id="cantidad" name="cantidad" type="text" placeholder="0.0">
      </div>
    </div>
  </div>

  <div class="control-group">
    <label for="fechaDeVencimiento" class="control-label">Fecha de vencimiento: </label>
    <div class="controls">
      <g:datePicker name="fechaDeVencimiento" value="${new Date()}" precision="day" />
    </div>
  </div>

  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn btn-large btn-primary">Guardar cambios</button>
    </div>
  </div>
</g:form>
