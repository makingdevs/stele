<!DOCTYPE html>
<html> 
  <head>
    <title>Stete | Registro</title>
    <meta name="layout" content="steleTwitterBootstrap"/>
    <r:require modules="registrar,stele" />
    <r:script type="text/javascript">
      $('#avisoPrivacidad').click(function(){
        if($(this).is(":checked")) {
          document.registroBasico.submitForm.disabled= false;
        } else {
          document.registroBasico.submitForm.disabled = true;
        }
      });
    </r:script>
  </head> 
  <body>
    <div class=" margin-bottom-10"> </div>

<!--=== Content Part ===-->
<div class="container">  
  <div class="container">
    <g:if test="${flash.error}">  
      <div class="alert alert-error">
        ${flash.error}
      </div>
    </g:if>
  </div>   
  <div class="row margin-bottom-30">
    <div class="span3 mb-margin-bottom-30"> 
      <div class="posts margin-bottom-40">
        <div class="headline headline-md"><h2>Elige bien:</h2></div>
        <div class="blog-twitter-inner">
        <dl class="dl-horizontal">
          <dt><g:img dir="/new/assets/img/sliders/elastislide/"  file="6.jpg" /></dt>
          <dd>
            <p><a href="#">Elígenos por administrar y facilitar a los padres el pago de las colegiaturas. </a></p> 
          </dd>
        </dl>
        </div>
        <dl class="dl-horizontal">
          <dt><g:img dir="/new/assets/img/sliders/elastislide/"  file="4.jpg" /></dt>
          <dd>
            <p><a href="#">Por ofrecerte una forma sencilla y eficaz de trabajar, simplificando  actividades. </a></p> 
          </dd>
        </dl>
        <dl class="dl-horizontal">
          <dt><g:img dir="/new/assets/img/sliders/elastislide/"  file="3.jpg" /></dt>
          <dd>
            <p><a href="#">Por contar con innovación tecnológica, confiable y segura.</a></p> 
          </dd>
        </dl>
        <dl class="dl-horizontal">
          <dt><g:img dir="/new/assets/img/sliders/elastislide/"  file="2.jpg" /></dt>
          <dd>
            <p><a href="#">Por que te apoyamos en tus planes de crecimiento.</a></p> 
          </dd>
        </dl>                
      </div><!--/posts-->
    </div><!--/col-md-8-->
    <div class="span8">
      <div class="container">
        <div class="row">
          <div class=" margin-bottom-30"> </div>
          <div class="span6 offset2 span7 offset4 ">
            <form id="registroBasico" name="registroBasico" controller="registro" action="crear" class="reg-page">
              <div class="reg-header">
                <h2>Registra un nuevo colegio</h2>                 
              </div>
              <div class="control-group">    
                <label class="control-label" for="inputInstitucion"><i class="icon-book"></i> Nombre del colegio <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="institucion.nombre" value="${params?.institucion?.nombre}" name="institucion.nombre"  type="text" class="span5" />
                </div>
              </div>
              <div class="control-group">
                <label class="control-label" for="inputNombre"><i class="icon-user"></i> Nombre del responsable <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="perfil.nombre" value="${params?.perfil?.nombre}" name="perfil.nombre" type="text" class="span5">
                </div>
              </div>
              <div class="control-group">
                <label class="control-label" for="inputApellidoPaterno"><i class="icon-user"></i> Apellido Paterno del responsable <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="perfil.apellidoPaterno" value="${params?.perfil?.apellidoPaterno}" name="perfil.apellidoPaterno" type="text" class="span5">
                </div>
              </div>
              <div class="control-group">
                <label class="control-label" for="inputApellidoMaterno"><i class="icon-user"></i> Apellido Materno del responsable <span class="color-blue">No obligatorio</span></label>
                <div class="controls">
                  <input id="perfil.apellidoMaterno" name="perfil.apellidoMaterno"  value="${params?.perfil?.apellidoMaterno}" type="text"  class="span5">
                </div>
              </div>
              <div class="control-group">
                <label class="control-label" for="inputEmail"><i class="icon-envelope"></i> Correo electrónico <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="usuario.username" name="usuario.username" value="${params?.usuario?.username}" type="text" class="span5">
                </div>
              </div>
              <div class="control-group">
                <label><i class="icon-phone"></i> Teléfono <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="numeroTelefonico" name="numeroTelefonico" value="${params?.numeroTelefonico}" type="tel" class="span5" />
                </div>
              </div>
              <div class="span6">
                <div class="control-group">
                  <label class="control-label" for="inputPassword"><i class="icon-key"></i> Contraseña <span class="color-red">*</span></label>
                  <div class="controls">
                    <input id="usuario.password" class="passwordOrigin" name="usuario.password" class="span7" type="password">
                  </div>
                </div>
              </div>
              <div class="span6">
                <div class="control-group">
                  <label class="control-label" for="inputConfirmPassword"><i class="icon-key"></i> Confirma <span class="color-red">*</span></label>
                  <div class="controls">
                    <input id="inputConfirmPassword" name="inputConfirmPassword" type="password"  class="passwordConfirm" >
                  </div>
                </div>
              </div>
              <g:if env="production">
                <div class="span12">
                  <div class="control_group">
                    <div class="controls">
                      <recaptcha:ifEnabled>
                        <recaptcha:recaptcha theme="red"/>
                      </recaptcha:ifEnabled>
                    </div>
                  </div>
                </div>  
              </g:if>               
              <hr />
              <div class="controls form-inline">
                <label class="checkbox"><input id="avisoPrivacidad" name="avisoPrivacidad" type="checkbox" />&nbsp; Acepto <a href="steleterminos.html" class="color-green">Términos y Condiciones</a> </br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; y el <g:link controller="utilidades" action="avisoPrivacidad">aviso de privacidad</g:link></label>
                <button type="submit" id="submitForm" class="btn-u pull-right" disabled="disabled"> Registro </button>
              </div>
              <hr />
              <p>¿Ya estás registrado? <a href="${createLink(controller: 'login')}" class="color-green">Accede</a> a tu cuenta.</p>
            </form>
          </div>
        </div>
      </div><!--/container-->             
    </div><!--/col-md-4-->
  </div><!--/row-->        
</div>
  
  
  </body>
</html> 