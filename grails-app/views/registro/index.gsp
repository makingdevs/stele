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


<div class="container">
    <div class="row">
        <div class=" margin-bottom-30"> </div>
        <div class="col-md-8 col-md-offset-3 col-sm-8 col-sm-offset-2  ">
            <form class="reg-page  ">
                <div class="reg-header">
                    <h2>Registra un nuevo colegio</h2>                 
                </div>

                <label><i class="icon-book"></i> Nombre del colegio <span class="color-red">*</span></label>
                <input type="text" class="form-control margin-bottom-20">

                <label><i class="icon-user"></i> Nombre del responsable <span class="color-red">*</span></label>
                <input type="text" class="form-control margin-bottom-20">
                <label><i class="icon-user"></i> Apellido del responsable <span class="color-red">*</span></label>
                <input type="text" class="form-control margin-bottom-20">
                <label><i class="icon-envelope"></i> Correo electrónico <span class="color-red">*</span></label>
                <input type="text" class="form-control margin-bottom-20">
                <label><i class="icon-phone"></i> Teléfono <span class="color-red">*</span></label>
                <input type="text" class="form-control margin-bottom-20">

                <div class="row">
                    <div class="col-sm-6">
                        <label><i class="icon-key"></i> Contraseña <span class="color-red">*</span></label>
                        <input type="text" class="form-control margin-bottom-20">
                    </div>
                    <div class="col-sm-6">
                        <label><i class="icon-key"></i> Confirma <span class="color-red">*</span></label>
                        <input type="text" class="form-control margin-bottom-20">
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6">
                        <label><img src="assets/img/recaptcha.gif">   </label>
                    </div>
                </div>                

                <hr>

                <div class="controls form-inline">
                    <label class="checkbox"><input type="checkbox" />&nbsp; Acepto <a href="steleterminos.html" class="color-green">Términos y Condiciones</a> </br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; y el <a href="steleavisopriv.html" class="color-green">aviso de privacidad</a></label>

                    <button class="btn-u pull-right" type="submit">Registro</button>

                </div>
                <hr />
                <p>¿Ya estás registrado? <a href="stelelogin.html" class="color-green">Accede</a> a tu cuenta.</p>
            </form>
            </form>
        </div>
    </div>
</div><!--/container--> 

            
        </div><!--/col-md-4-->
    </div><!--/row-->        

</div><!--/container-->     
<!--=== End Content Part ===-->
</body>
</html> 