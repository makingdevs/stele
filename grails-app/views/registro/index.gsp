<!DOCTYPE html>
<html> 
<head>
<meta name="layout" content="steleTwitterBoostrapMain"/>
  <r:require modules="steleCss,steleJs,registrar" /> 
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
  <g:if test='${flash.error}'>  
    <div class="alert alert-danger">
      <button type="button" class="close" data-dismiss="alert">×</button>
      <div class='login_message'><strong>Cuidado!</strong> flash.error</div>
    </div>  
  </g:if>
    <div class="row margin-bottom-30">
        <div class="col-md-3 mb-margin-bottom-30">
            <!-- Posts -->
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
            <!-- End Posts -->
        </div><!--/col-md-8-->
        
        <div class="col-md-8">

<p>&nbsp;</p><p></p>
<div class="container">
    <div class="row">
        <div class=" margin-bottom-30"> </div>
        <div class="span8 offset2  span5 offset2  ">
            <form id="registroBasico" name="registroBasico" controller="registro" action="crear" class="reg-page">
              <div class="reg-header">
                <h2>Registra un nuevo colegio</h2>                 
              </div>
              <div class="control-group">    
                <label class="control-label" for="inputInstitucion"><i class="icon-book"></i> Nombre del colegio <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="institucion.name" value="${params?.institucion?.name}" name="institucion.name"  type="text" class="form-control margin-bottom-20" />
                </div>
              </div>
              <p>&nbsp;</p>
              <div class="control-group">
                <label class="control-label" for="inputNombre"><i class="icon-user"></i> Nombre del responsable <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="perfil.nombre" value="${params?.perfil?.nombre}" name="perfil.nombre" type="text" class="form-control margin-bottom-20">
                </div>
              </div>
              <p>&nbsp;</p>
              <div class="control-group">
                <label class="control-label" for="inputApellidoPaterno"><i class="icon-user"></i> Apellido Paterno del responsable <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="perfil.apellidoPaterno" value="${params?.perfil?.apellidoPaterno}" name="perfil.apellidoPaterno" type="text" class="form-control margin-bottom-20">
                </div>
              </div>
              <p>&nbsp;</p>
              <div class="control-group">
                <label class="control-label" for="inputApellidoMaterno"><i class="icon-user"></i> Apellido Materno del responsable <span class="color-blue">No obligatorio</span></label>
                <div class="controls">
                  <input id="perfil.apellidoMaterno" name="perfil.apellidoMaterno"  value="${params?.perfil?.apellidoMaterno}" type="text"  class="form-control margin-bottom-20">
                </div>
              </div>
              <p>&nbsp;</p>
              <div class="control-group">
                <label class="control-label" for="inputEmail"><i class="icon-envelope"></i> Correo electrónico <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="usuario.username" name="usuario.username" value="${params?.usuario?.username}" type="text" class="form-control margin-bottom-20">
                </div>
              </div>
              <p>&nbsp;</p>
              <div class="control-group">
                <label class="control-label" for="inputTelefono"><i class="icon-phone"></i> Teléfono <span class="color-red">*</span></label>
                <div class="controls">
                  <input id="numeroTelefonico" name="numeroTelefonico" value="${params?.numeroTelefonico}" type="tel" class="form-control margin-bottom-20" />
                </div>
              </div>
              <p>&nbsp;</p>
              <div class="row">
                <div class="col-sm-6">
                  <div class="control-group">
                    <label class="control-label" for="inputPassword"><i class="icon-key"></i> Contraseña <span class="color-red">*</span></label>
                    <div class="controls">
                      <input id="usuario.password" class="passwordOrigin form-control margin-bottom-20" name="usuario.password" type="password">
                    </div>
                  </div>
                </div>
                <div class="col-sm-6">
                  <div class="control-group">
                    <label class="control-label" for="inputConfirmPassword"><i class="icon-key"></i> Confirma <span class="color-red">*</span></label>
                    <div class="controls">
                      <input id="inputConfirmPassword" name="inputConfirmPassword" type="password"  class="passwordConfirm form-control margin-bottom-20" >
                    </div>
                  </div>
                </div>
              </div>
              <p>&nbsp;</p>
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
              <hr>
              <div class="controls form-inline">
                <label class="checkbox"><input id="avisoPrivacidad" name="avisoPrivacidad" type="checkbox" />&nbsp; Acepto <g:link controller="utilidades" action="terminosYCondiciones">Términos y Condiciones</g:link> </br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; y el <g:link controller="utilidades" action="avisoPrivacidad">Aviso de Privacidad</g:link></label>
              </div>
              <p>&nbsp;</p>

              <div class="controls form-inline">
               <button type="submit" id="submitForm" class="btn btn-large btn-block btn-info pull-right" disabled="disabled"> Registro     </button>
              </div>
              <p>&nbsp;</p>
              <hr />
              <p>¿Ya estás registrado? <a href="${createLink(controller: 'login')}" class="color-green">Accede</a> a tu cuenta.</p>
            </form>
        </div>
    </div>
</div><!--/container--> 

            
        </div><!--/col-md-4-->
    </div><!--/row-->        

</div><!--/container-->     
<!--=== End Content Part ===-->
<p>&nbsp;</p><p></p>
</body>
</html> 
