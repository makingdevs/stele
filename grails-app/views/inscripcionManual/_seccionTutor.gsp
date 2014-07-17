<div class="span12">
  <h3 class="header smaller lighter purple">
    Padre o Tutor
    <small> >>Datos del Padre o Tutor</small>
  </h3>
  <div class="control-group">
    <label class="control-label" for="txtNombreTutor">Padre o Tutor</label>
    <div class="controls">
      <span class="input-icon">
        <input type="text" id="nombrePadre" name="nombrePadre" placeholder="nombre" value="${user?.perfil?.nombre}" />
      </span>
      <span class="input-icon">
        <input type="text" id="apellidoPaternoPadre" name="apellidoPaternoPadre" placeholder="apellido paterno" value="${user?.perfil?.apellidoPaterno}" />
      </span>
      <span class="input-icon">
        <input type="text" id="apellidoMaternoPadre" name="apellidoMaternoPadre" placeholder="apellido materno" value="${user?.perfil?.apellidoMaterno}" />
      </span>
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="txtNombreTutor">Contacto</label>
    <div class="controls">
      <span class="input-icon">
        <input type="text" id="telefono" name="telefono" placeholder="teléfono" value="${user?.perfil?.telefonos?.first()?.numeroTelefonico}" />
        <i class="icon-phone"></i> 
      </span>
      <span class="input-icon">
        <input type="email" id="email" name="email" placeholder="email" data-placement="bottom" data-rel="tooltip" data-original-title="la cuenta de correo sera su usuario para el sistema" value="${user?.username}" />
        <i class="icon-envelope"></i>
      </span>
    </div>
  </div>
</div>
