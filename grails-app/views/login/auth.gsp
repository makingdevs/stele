<html>
<head>
    <meta name="layout" content="steleTwitterBoostrapMain"/>
    <r:require modules="steleCss,steleJs" /> 
    <r:script type="text/javascript">
            $('#username').focus();
    </r:script>
</head> 
<body>
<div class=" margin-bottom-40"> </div>
<p>&nbsp;</p> 
<div class="container">     
  <g:if test='${flash.message}'>
    <div class="alert alert-danger">
      <button type="button" class="close" data-dismiss="alert">×</button>
      <div class='login_message'><strong>Cuidado!</strong> Nombre de usuario o contraseña incorrectos</div>
    </div>
  </g:if>
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
            <form action='${postUrl}' method='POST' id='loginForm' class="reg-page" autocomplete='off'>
                <div class="reg-header">            
                    <h2>Ingresa </h2>
                </div>

                <div class="input-group margin-bottom-20">
                    <span class="input-group-addon"><i class="icon-user"></i></span>
                    <input id="username" name='j_username' type="text" placeholder="Usuario (Correo electrónico)" class="form-control">
                </div>   
                &nbsp;          
                <div class="input-group margin-bottom-20">
                    <span class="input-group-addon"><i class="icon-lock"></i></span>
                    <input type="password" name='j_password' id='password' placeholder="Contraseña" class="form-control">
                </div>                    
                &nbsp;          
                <div class="row">
                    <div class="col-md-6">
                    </div>
                    <div class="col-md-6">
                        <button class="btn btn-info pull-right" type="submit">Ingresar</button>
                    </div>
                </div>

                <hr>

                <h4>Olvidaste tu contraseña?</h4>
                <p>Mandanos un email a <a href="mailto:info@stele..mx" class="">soporte@stele.mx</a> </br>con la siguiente información:</br>
                <strong> Colegio, nombre completo y teléfono</strong> </br>
                 
            </form>            
        </div>
    </div><!--/row-->
</div><!--/container-->     
<!--=== End Content Part ===-->
<p>&nbsp;</p> 

<div class=" margin-bottom-40"> </div>

</body>
</html> 
