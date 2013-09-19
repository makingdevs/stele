<!DOCTYPE html>
<html> 
<head>
  <title>Stete | Registro</title>
  <meta name="layout" content="steleTwitterBootstrap"/>
  <r:require module="registrar" />
</head> 
<body>
  <header>
    <!--=== Content Part ===-->
    <div class="body">
      <div class="breadcrumbs margin-bottom-50">
        <div class="container">
          <h1 class="color-green pull-left">Registro</h1>
        </div><!--/container-->
      </div><!--/breadcrumbs-->
      <div class="container">
        <g:if test="${flash.error}">  
          <div class="alert alert-error">
            ${flash.error}
          </div>
        </g:if>
      </div>
      <div class="container">	
        <div class="row-fluid margin-bottom-10">
          <div class="span3">
            <g:render template="metas" />
            <div class="who margin-bottom-30">
              <div class="headline"><h3>Contáctanos</h3></div>
              <p>Si requieres más información sobre nuestros servicios</p>
              <ul class="unstyled">
                <li><a href="#"><i class="icon-envelope-alt"></i>info@stele.mx</a></li>
                <li><a href="#"><i class="icon-phone-sign"></i>+52 (55) 555 5555</a></li>
                <li><a href="#"><i class="icon-globe"></i>www.stele.mx</a></li>
                <li><a href="#"><i class="icon-twitter"></i>@SteleMX</a></li>
              </ul>
            </div>
          </div><!--/span3-->
      <g:form id="registroBasico" name="registroBasico" controller="registro" action="crear" class="reg-page">
          <h3>Registra una nueva cuenta</h3>
          <div class="control-group">    
            <label class="control-label" for="inputInstitucion"><i class="icon-book"></i> Nombre del colegio <span class="color-red">*</span></label>
            <div class="controls">
              <input id="institucion.nombre" value="${params?.institucion?.nombre}" name="institucion.nombre"  type="text" class="span12" />
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputNombre"><i class="icon-user"></i> Nombre del responsable <span class="color-red">*</span></label>
            <div class="controls">
              <input id="perfil.nombre" value="${params?.perfil?.nombre}" name="perfil.nombre" type="text" class="span12">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputApellidoPaterno"><i class="icon-user"></i> Apellido Paterno del responsable <span class="color-red">*</span></label>
            <div class="controls">
              <input id="perfil.apellidoPaterno" value="${params?.perfil?.apellidoPaterno}" name="perfil.apellidoPaterno" type="text" class="span12">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputApellidoMaterno"><i class="icon-user"></i> Apellido Materno del responsable <span class="color-blue">No obligatorio</span></label>
            <div class="controls">
              <input id="perfil.apellidoMaterno" name="perfil.apellidoMaterno"  value="${params?.perfil?.apellidoMaterno}" type="text"  class="span12">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputEmail"><i class="icon-envelope"></i> Correo electrónico <span class="color-red">*</span></label>
            <div class="controls">
              <input id="usuario.username" name="usuario.username" value="${params?.usuario?.username}" placeholder="your@mail.com" type="text" class="span12">
            </div>
          </div>
          <div class="control-group">
            <label><i class="icon-phone"></i> Teléfono <span class="color-red">*</span></label>
            <div class="controls">
              <input id="numeroTelefonico" name="numeroTelefonico" value="${params?.numeroTelefonico}" type="tel" class="span12" />
            </div>
          </div>

            <div class="span6">
              <div class="control-group">
                <label class="control-label" for="inputPassword"><i class="icon-key"></i> Contraseña <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="usuario.password" class="passwordOrigin" name="usuario.password" class="span12" type="password">
                </div>
              </div>
            </div>
            <div class="span6">
              <div class="control-group">
                <label class="control-label" for="inputConfirmPassword"><i class="icon-key"></i> Confirma <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="inputConfirmPassword" name="inputConfirmPassword" type="password" class="span12">
                </div>
              </div>
            </div>
          <div class="span12">
            <div class="control_group">
              <div class="controls">
                <recaptcha:ifEnabled>
                  <recaptcha:recaptcha theme="red"/>
                </recaptcha:ifEnabled>
              </div>
            </div>
          </div>  
        <div class="controls form-inline">
          <label class="checkbox"><input id="avisoPrivacidad" name="avisoPrivacidad" type="checkbox" />&nbsp; He leído los <a href="">términos y condiciones.</a></label>
          <button type="submit" id="submitForm" class="btn-u pull-right" disabled="disabled"> Registrar </button>
        </div>
        <hr />
        <p>¿Ya estás registrado? <a href="${createLink(controller: 'login')}" class="color-green">Accede</a> a tu cuenta.</p>
      </g:form>
    </div><!--/row-fluid-->
  </div><!--/container-->		
</div><!--/body-->
<!--=== End Content Part ===-->
</header>

<script type="text/javascript">
  jQuery(document).ready(function() {
        App.init();
  });
  $('#avisoPrivacidad').click(function(){
    if($(this).is(":checked")) {
      document.registroBasico.submitForm.disabled= false;
    } else {
      document.registroBasico.submitForm.disabled = true;
    }
  });
</script>

</body>
</html> 