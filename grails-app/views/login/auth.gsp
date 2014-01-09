<html>
<head>
    <meta name="layout" content="steleTwitterBoostrapMain"/>
    <title>Inicia tu sesión</title>

    <r:script>
        $(function() {
         $('#username').focus();
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
    <div class="row-fluid">
      <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3" align="center">
        <form action='${postUrl}' method='POST' id='loginForm' class="log-page" autocomplete='off' style="border: 1px groove #EEEEEE; width: 360px; height: 450px; padding-left: 10px">
          <div class="reg-header" align="CENTER">            
            <p>&nbsp;</p> 
            <h3>Ingresa </h3>
          </div>
          <div class="input-group margin-bottom-200" align="center">
              <span class="add-on"><i class="icon-user"></i></span>
              <input type="text" class="input-xlarge" placeholder="Correo electrónico" name='j_username' id='username'>
          </div>                    
          <div class="input-group margin-bottom-200" align="center">
              <span class="input-group-addon"><i class="icon-lock"></i></span>
              <input type="password" class="input-xlarge" placeholder=" Contraseña" name='j_password' id='password'>
          </div>     
          <p></p>    
          <div  align="center">
              <div class="span11">
                <button class="btn-u pull-right" type="submit">Login</button>
              </div>
          </div>
          <p>&nbsp;</p>       
          <p>&nbsp;</p>   
          <HR>  
          <div class="span12">
            <div align="left">
              <h4>Olvidaste tu contraseña?</h4>
              <p>Mandanos un email a <a href="mailto:info@stele..mx" class="">soporte@stele.mx</a> </br>con la siguiente información:</br>
              <strong> Colegio, nombre completo y teléfono</strong> </br>
            </div>
          </div>
          <p>&nbsp;</p>     
          <p>&nbsp;</p>     
          <p>&nbsp;</p>  
        </form>
      </div>
    </div><!--/row-fluid-->
  </div><!--/container-->        
</body>
</html> 