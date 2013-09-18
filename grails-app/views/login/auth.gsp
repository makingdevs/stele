<html>
<head>
    <meta name="layout" content="steleTwitterBootstrapAuth"/>
    <title>Inicia tu sesión</title>
    <r:require module="auth"/>
</head> 

<body>


<!--=== Breadcrumbs ===-->
<div class="breadcrumbs margin-bottom-40">
  <div class="container">
        <h1 class="color-green pull-left">Login</h1>
    </div><!--/container-->
</div><!--/breadcrumbs-->
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
        <form class="log-page" action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
            <h3>Login to your account</h3>    
            <div class="input-prepend">
                <span class="add-on"><i class="icon-user"></i></span>
                <input type="text" class="input-xlarge" placeholder="Correo electrónico" name='j_username' id='username'>
            </div>
            <div class="input-prepend">
                <span class="add-on"><i class="icon-lock"></i></span>
                <input type="password" class="input-xlarge" placeholder="Contraseña" name='j_password' id='password'>
            </div>
            <div class="controls form-inline">
                <label class="checkbox"><input type='checkbox' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/> Stay Signed in</label>
                <button class="btn-u pull-right" type="submit">Login</button>
            </div>
            <hr />
            <h4>Forget your Password ?</h4>
            <p>no worries, <a class="color-green" href="#">click here</a> to reset your password.</p>
        </form>
    </div><!--/row-fluid-->
</div><!--/container-->   
        

<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
    });
</script>

</body>
</html> 