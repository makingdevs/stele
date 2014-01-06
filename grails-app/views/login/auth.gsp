<html>
<head>
    <meta name="layout" content="steleTwitterBoostrapMain"/>
    <title>Inicia tu sesión</title>
    <r:require modules="stele"/>
    <r:script>
        $(function() {
         $('#username').focus();
        });
        jQuery(document).ready(function() {
          App.init();
          App.initSliders();
          App.initBxSlider();
        });
    </r:script>
</head> 
<body>
<div class=" margin-bottom-40"> </div>

<!--=== End Breadcrumbs ===-->
  <g:if test='${flash.message}'>
    <div class="alert alert-error">
      <button type="button" class="close" data-dismiss="alert">×</button>
      <div class='login_message'><strong>Cuidado!</strong> Nombre de usuario o contraseña incorrectos</div>
    </div>
  </g:if>
<!--=== Content Part ===-->
  <div class="container">   
    <div class="row">
      <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
        <form action='${postUrl}' method='POST' id='loginForm' class='reg-page' autocomplete='off'>
          <div class="reg-header">            
            <h2>Ingresa </h2>
          </div>
          <div class="input-group margin-bottom-200" align="center">
              <span class="input-group-addon"><i class="icon-user"></i></span>
              <input type="text" class="input-xlarge" placeholder="Correo     electrónico" name='j_username' id='username'>
          </div>                    
          <div class="input-group margin-bottom-200" align="center">
              <span class="input-group-addon"><i class="icon-lock"></i></span>
              <input type="password" class="input-xlarge" placeholder=" Contraseña" name='j_password' id='password'>
          </div>                    
          <div class="row">
              <div class="col-md-6"></div>
              <div class="col-md-6" align="center">
                <button class="btn-u pull-right" type="submit">Login</button>
              </div>
          </div>
          <hr>
          <h4>Olvidaste tu contraseña?</h4>
          <p>Mandanos un email a <a href="mailto:info@stele..mx" class="">soporte@stele.mx</a> </br>con la siguiente información:</br>
          <strong> Colegio, nombre completo y teléfono</strong> </br>
        </form>
      </div>
    </div><!--/row-fluid-->
  </div><!--/container-->        
</body>
</html> 